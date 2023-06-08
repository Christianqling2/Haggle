package com.Haggle.cloud.leaf.feign;

import com.Haggle.cloud.api.leaf.feign.SegmentFeignClient;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.leaf.common.Result;
import com.Haggle.cloud.leaf.common.Status;
import com.Haggle.cloud.leaf.exception.LeafServerException;
import com.Haggle.cloud.leaf.exception.NoKeyException;
import com.Haggle.cloud.leaf.service.SegmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


/**/
@RestController
public class SegmentFeignController implements SegmentFeignClient {

	private static final Logger logger = LoggerFactory.getLogger(SegmentFeignController.class);


	@Autowired
	private SegmentService segmentService;

	@Override
	public ServerResponseEntity<Long> getSegmentId(String key) {
		return ServerResponseEntity.success(get(key, segmentService.getId(key)));
	}


	private Long get(String key, Result id) {
		Result result;
		if (key == null || key.isEmpty()) {
			throw new NoKeyException();
		}
		result = id;
		if (Objects.equals(result.getStatus(), Status.EXCEPTION)) {
			throw new LeafServerException(result.toString());
		}
		return result.getId();
	}
}
