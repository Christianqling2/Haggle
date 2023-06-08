package com.Haggle.cloud.api.leaf.feign;

import com.Haggle.cloud.common.feign.FeignInsideAuthConfig;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "Haggle-leaf",contextId ="segment")
public interface SegmentFeignClient {

	/**
	 * 获取id
	 * @param key
	 * @return
	 */
	@GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/segment")
	ServerResponseEntity<Long> getSegmentId(@RequestParam("key") String key);


}
