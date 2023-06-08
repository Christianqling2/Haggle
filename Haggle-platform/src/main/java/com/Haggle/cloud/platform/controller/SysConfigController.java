package com.Haggle.cloud.platform.controller;

import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.platform.model.SysConfig;
import com.Haggle.cloud.platform.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/sys_config")
public class SysConfigController {


    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 获取保存支付宝支付配置信息
     */
    @GetMapping("/info/{key}")
    public ServerResponseEntity<String> info(@PathVariable("key")String key){
        return ServerResponseEntity.success(sysConfigService.getValue(key));
    }

    /**
     * 保存配置
     */
    @PostMapping("/save")
    public ServerResponseEntity<Void> save(@RequestBody @Valid SysConfig sysConfig){
        sysConfigService.saveOrUpdateSysConfig(sysConfig);
        return ServerResponseEntity.success();
    }




}
