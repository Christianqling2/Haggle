package com.Haggle.cloud.product.feign;

import com.Haggle.cloud.api.product.feign.SkuFeignClient;
import com.Haggle.cloud.api.product.vo.SkuVO;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.product.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SkuFeignController implements SkuFeignClient {

    @Autowired
    private SkuService skuService;


    @Override
    public ServerResponseEntity<SkuVO> getById(Long skuId) {
        return ServerResponseEntity.success(skuService.getSkuBySkuId(skuId));
    }
}
