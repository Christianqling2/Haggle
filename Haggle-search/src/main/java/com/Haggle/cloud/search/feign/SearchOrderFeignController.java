package com.Haggle.cloud.search.feign;


import com.Haggle.cloud.api.dto.EsPageDTO;
import com.Haggle.cloud.api.feign.SearchOrderFeignClient;
import com.Haggle.cloud.api.vo.EsPageVO;
import com.Haggle.cloud.api.vo.search.EsOrderVO;
import com.Haggle.cloud.common.dto.OrderSearchDTO;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.search.manager.OrderSearchManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SearchOrderFeignController implements SearchOrderFeignClient {

    @Autowired
    private OrderSearchManager orderSearchManager;


    @Override
    public ServerResponseEntity<EsPageVO<EsOrderVO>> getOrderPage(OrderSearchDTO orderSearch) {
        EsPageDTO pageDTO = new EsPageDTO();
        pageDTO.setPageNum(orderSearch.getPageNum());
        pageDTO.setPageSize(orderSearch.getPageSize());
        return ServerResponseEntity.success(orderSearchManager.pageSearchResult(pageDTO, orderSearch));
    }
}
