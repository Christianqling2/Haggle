package com.Haggle.cloud.platform.feign;

import com.Haggle.cloud.api.platform.feign.ConfigFeignClient;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.platform.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConfigFeignController implements ConfigFeignClient {

    @Autowired
    private SysConfigService sysConfigService;

    @Override
    public ServerResponseEntity<String> getConfig(String key) {
        return ServerResponseEntity.success(sysConfigService.getValue(key));
    }
}
