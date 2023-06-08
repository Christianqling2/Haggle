package com.Haggle.cloud.product.feign;

import com.Haggle.cloud.api.product.dto.SkuStockLockDTO;
import com.Haggle.cloud.api.product.feign.SkuStockLockFeignClient;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.product.service.*;
import com.Haggle.cloud.product.service.SkuStockLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SkuStockLockFeignController implements SkuStockLockFeignClient {


    @Autowired
    private SkuStockLockService skuStockLockService;

    @Override
    public ServerResponseEntity<Void> lock(List<SkuStockLockDTO> skuStockLocksParam) {
        return skuStockLockService.lock(skuStockLocksParam);
    }
}
