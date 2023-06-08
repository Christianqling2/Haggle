package com.Haggle.cloud.api.feign;

import com.Haggle.cloud.api.vo.EsPageVO;
import com.Haggle.cloud.api.vo.search.EsOrderVO;
import com.Haggle.cloud.common.dto.OrderSearchDTO;
import com.Haggle.cloud.common.feign.FeignInsideAuthConfig;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 订单搜索
 * /**/ FrozenWatermelon
 * @date 2021/02/05
 */
@FeignClient(value = "Haggle-search",contextId = "searchOrder")
public interface SearchOrderFeignClient {


    /**
     * 订单搜索
     * @param orderSearch 订单搜索参数
     * @return 订单列表
     */
    @PutMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/searchOrder/getOrderPage")
    ServerResponseEntity<EsPageVO<EsOrderVO>> getOrderPage(@RequestBody OrderSearchDTO orderSearch);

}
