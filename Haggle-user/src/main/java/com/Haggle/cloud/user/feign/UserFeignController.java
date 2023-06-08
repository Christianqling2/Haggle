package com.Haggle.cloud.user.feign;

import com.Haggle.cloud.api.user.feign.UserFeignClient;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.user.service.UserService;
import com.Haggle.cloud.api.user.vo.UserApiVO;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class UserFeignController implements UserFeignClient {

    @Autowired
    private UserService userService;
    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public ServerResponseEntity<List<UserApiVO>> getUserByUserIds(List<Long> userIds) {
        List<UserApiVO> userList = userService.getUserByUserIds(userIds);
        return ServerResponseEntity.success(userList);
    }

    @Override
    public ServerResponseEntity<UserApiVO> getUserData(Long userId) {
        UserApiVO user = userService.getByUserId(userId);
        return ServerResponseEntity.success(user);
    }

    @Override
    public ServerResponseEntity<UserApiVO> getUserAndOpenIdsByUserId(Long userId) {
        return ServerResponseEntity.success(userService.getUserAndOpenIdsByUserId(userId));
    }
}
