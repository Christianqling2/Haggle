package com.Haggle.cloud.api.product.feign;

import com.Haggle.cloud.common.feign.FeignInsideAuthConfig;
import com.Haggle.cloud.common.order.vo.ShopCartItemVO;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * /**/ FrozenWatermelon
 * @date 2020/11/12
 */
@FeignClient(value = "Haggle-product",contextId = "shopCart")
public interface ShopCartFeignClient {

    /**
     * 获取购物项
     * @return 购物项
     */
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/shopCart/getById")
    ServerResponseEntity<List<ShopCartItemVO>> getCheckedShopCartItems();

    /**
     * 通过购物车id删除用户购物车物品
     * @param shopCartItemIds 购物车id
     * @return
     */
    @DeleteMapping("/delete_item")
    ServerResponseEntity<Void> deleteItem(@RequestBody List<Long> shopCartItemIds);
}
