package com.Haggle.cloud.multishop.controller.app;

import com.Haggle.cloud.multishop.service.IndexImgService;
import com.Haggle.cloud.multishop.vo.IndexImgVO;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController("appIndexImgController")
@RequestMapping("/ua/index_img")
@Tag(name = "app-轮播图")
public class IndexImgController {

    @Autowired
    private IndexImgService indexImgService;

	@GetMapping("/list")
	@Operation(summary = "获取轮播图列表" , description = "分页获取轮播图列表")
	@Parameter(name = "shopId", description = "店铺id（平台：0）")
	public ServerResponseEntity<List<IndexImgVO>> getList(@RequestParam("shopId") Long shopId) {
		List<IndexImgVO> indexImgPage = indexImgService.getListByShopId(shopId);
		return ServerResponseEntity.success(indexImgPage);
	}
}
