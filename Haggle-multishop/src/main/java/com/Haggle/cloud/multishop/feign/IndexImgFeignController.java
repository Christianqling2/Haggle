package com.Haggle.cloud.multishop.feign;

import com.Haggle.cloud.api.multishop.feign.IndexImgFeignClient;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.multishop.service.IndexImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexImgFeignController implements IndexImgFeignClient {

    @Autowired
    private IndexImgService indexImgService;

    @Override
    public ServerResponseEntity<Void> deleteBySpuId(Long spuId, Long shopId) {
        indexImgService.deleteBySpuId(spuId, shopId);
        return ServerResponseEntity.success();
    }
}
