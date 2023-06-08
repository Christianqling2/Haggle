package com.Haggle.cloud.user.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.Haggle.cloud.api.auth.constant.SysTypeEnum;
import com.Haggle.cloud.api.auth.dto.AuthAccountDTO;
import com.Haggle.cloud.api.auth.feign.AccountFeignClient;
import com.Haggle.cloud.api.auth.vo.AuthAccountVO;
import com.Haggle.cloud.api.leaf.feign.SegmentFeignClient;
import com.Haggle.cloud.api.user.vo.UserApiVO;
import com.Haggle.cloud.common.cache.constant.UserCacheNames;
import com.Haggle.cloud.common.database.dto.PageDTO;
import com.Haggle.cloud.common.database.util.PageUtil;
import com.Haggle.cloud.common.database.vo.PageVO;
import com.Haggle.cloud.common.exception.HaggleException;
import com.Haggle.cloud.common.response.ResponseEnum;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.common.util.IpHelper;
import com.Haggle.cloud.user.dto.UserRegisterDTO;
import com.Haggle.cloud.user.model.User;
import com.Haggle.cloud.user.mapper.UserMapper;
import com.Haggle.cloud.user.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import ma.glasnost.orika.MapperFacade;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountFeignClient accountFeignClient;
    @Autowired
    private MapperFacade mapperFacade;
    @Autowired
    private SegmentFeignClient segmentFeignClient;

    @Override
    public PageVO<UserApiVO> page(PageDTO pageDTO) {
        return PageUtil.doPage(pageDTO, () -> userMapper.list());
    }

    @Override
    @Cacheable(cacheNames = UserCacheNames.USER_INFO, key = "#userId")
    public UserApiVO getByUserId(Long userId) {
        return userMapper.getByUserId(userId);
    }

    @Override
    @CacheEvict(cacheNames = UserCacheNames.USER_INFO, key = "#user.userId")
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public List<UserApiVO> getUserByUserIds(List<Long> userIds) {
        if (CollUtil.isEmpty(userIds)) {
            return new ArrayList<>();
        }
        return userMapper.getUserByUserIds(userIds);
    }

    @Override
    public UserApiVO getUserAndOpenIdsByUserId(Long userId) {
        return userMapper.getUserAndOpenIdsByUserId(userId);
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public Long save(UserRegisterDTO param) {
        this.checkRegisterInfo(param);

        ServerResponseEntity<Long> segmentIdResponse = segmentFeignClient.getSegmentId(User.DISTRIBUTED_ID_KEY);
        if (!segmentIdResponse.isSuccess()) {
            throw new HaggleException(ResponseEnum.EXCEPTION);
        }
        Long userId = segmentIdResponse.getData();

        param.setUserId(userId);

        AuthAccountDTO authAccountDTO = new AuthAccountDTO();
        authAccountDTO.setCreateIp(IpHelper.getIpAddr());
        authAccountDTO.setPassword(param.getPassword());
        authAccountDTO.setIsAdmin(0);
        authAccountDTO.setSysType(SysTypeEnum.ORDINARY.value());
        authAccountDTO.setUsername(param.getUserName());
        authAccountDTO.setStatus(1);
        authAccountDTO.setUserId(userId);

        // 保存统一账户信息
        ServerResponseEntity<Long> serverResponse = accountFeignClient.save(authAccountDTO);
        // 抛异常回滚
        if (!serverResponse.isSuccess()) {
            throw new HaggleException(serverResponse.getMsg());
        }

        User user = new User();
        user.setUserId(userId);
        user.setPic(param.getImg());
        user.setNickName(param.getNickName());
        user.setStatus(1);
        // 这里保存之后才有用户id
        userMapper.save(user);

        return serverResponse.getData();
    }

    private void checkRegisterInfo(UserRegisterDTO userRegisterDTO) {
        ServerResponseEntity<AuthAccountVO> responseEntity = accountFeignClient.getByUsernameAndSysType(userRegisterDTO.getUserName(), SysTypeEnum.ORDINARY);
        if (!responseEntity.isSuccess()) {
            throw new HaggleException(responseEntity.getMsg());
        }
        if (Objects.nonNull(responseEntity.getData())) {
            throw new HaggleException("用户名已存在");
        }
    }

}
