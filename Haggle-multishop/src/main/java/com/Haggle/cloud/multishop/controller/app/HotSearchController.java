package com.Haggle.cloud.multishop.controller.app;

import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.multishop.service.HotSearchService;
import com.Haggle.cloud.multishop.vo.HotSearchVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("appHotSearchController")
@RequestMapping("/ua/app/hot_search")
@Tag(name = "app-热搜")
public class HotSearchController {

    @Autowired
    private HotSearchService hotSearchService;

	@GetMapping("/list")
	@Operation(summary = "获取热搜列表" , description = "获取热搜列表")
	@Parameter(name = "shopId", description = "店铺id")
	public ServerResponseEntity<List<HotSearchVO>> listByShopId(@RequestParam("shopId") Long shopId) {
		List<HotSearchVO> hotSearches = hotSearchService.listByShopId(shopId);
		return ServerResponseEntity.success(hotSearches);
	}
}
