package com.Haggle.cloud.api.user.feign;

import com.Haggle.cloud.api.user.vo.UserApiVO;
import com.Haggle.cloud.common.feign.FeignInsideAuthConfig;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户信息feign连接
 * /**/ FrozenWatermelon
 * @date 2020/12/07
 */
@FeignClient(value = "Haggle-user",contextId = "user")
public interface UserFeignClient {

    /**
     * 根据用户id列表，获取用户信息
     * @param userIds 用户id列表
     * @return 用户列表信息
     */
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/user/getUserByUserIds")
    ServerResponseEntity<List<UserApiVO>> getUserByUserIds(@RequestParam("userId") List<Long> userIds);

    /**
     * 根据用户id获取用户详细信息
     * @param userId 用户id
     * @return 用户详细信息
     */
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/user/getUserAndOpenIdsByUserId")
    ServerResponseEntity<UserApiVO> getUserAndOpenIdsByUserId(@RequestParam("userId") Long userId);

    /**
     * 获取用户数据
     * @param userId
     * @return
     */
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/user/getUserData")
    ServerResponseEntity<UserApiVO> getUserData(Long userId);

}
