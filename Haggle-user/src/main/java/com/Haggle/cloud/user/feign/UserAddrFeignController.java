package com.Haggle.cloud.user.feign;

import com.Haggle.cloud.api.user.feign.UserAddrFeignClient;
import com.Haggle.cloud.common.order.vo.UserAddrVO;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.common.security.AuthUserContext;
import com.Haggle.cloud.user.service.UserAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserAddrFeignController implements UserAddrFeignClient {

    @Autowired
    private UserAddrService userAddrService;

    @Override
    public ServerResponseEntity<UserAddrVO> getUserAddrByAddrId(Long addrId) {
        return ServerResponseEntity.success(userAddrService.getUserAddrByUserId(addrId,AuthUserContext.get().getUserId()));
    }
}
