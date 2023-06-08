package com.Haggle.cloud.product.controller.app;

import com.Haggle.cloud.product.service.AttrService;
import com.Haggle.cloud.api.product.vo.AttrVO;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("appAttrController")
@RequestMapping("/ua/attr")
@Tag(name = "app-属性信息")
public class AttrController {

    @Autowired
    private AttrService attrService;

    @Autowired
	private MapperFacade mapperFacade;

	@GetMapping
	@Operation(summary = "获取属性信息" , description = "根据attrId获取属性信息")
	public ServerResponseEntity<AttrVO> getByAttrId(@RequestParam Long attrId) {
		return ServerResponseEntity.success(attrService.getByAttrId(attrId));
	}
}
