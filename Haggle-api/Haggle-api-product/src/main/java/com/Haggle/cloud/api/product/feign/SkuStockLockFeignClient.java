package com.Haggle.cloud.api.product.feign;

import com.Haggle.cloud.api.product.dto.SkuStockLockDTO;
import com.Haggle.cloud.common.feign.FeignInsideAuthConfig;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * /**/ FrozenWatermelon
 * @date 2020/12/22
 */
@FeignClient(value = "Haggle-product",contextId = "skuStockLock")
public interface SkuStockLockFeignClient {

    /**
     * 锁定库存
     * @param skuStockLocks 参数
     * @return 是否成功
     */
    @PostMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/skuStockLock/lock")
    ServerResponseEntity<Void> lock(@RequestBody List<SkuStockLockDTO> skuStockLocks);

}
