package com.Haggle.cloud.api.product.feign;

import com.Haggle.cloud.api.product.vo.SkuVO;
import com.Haggle.cloud.common.feign.FeignInsideAuthConfig;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * /**/ FrozenWatermelon
 * @date 2020/11/12
 */
@FeignClient(value = "Haggle-product",contextId = "sku")
public interface SkuFeignClient {

    /**
     * 通过skuId获取sku信息
     * @param skuId skuId
     * @return sku信息
     */
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/sku/getById")
    ServerResponseEntity<SkuVO> getById(@RequestParam("skuId") Long skuId);

}
