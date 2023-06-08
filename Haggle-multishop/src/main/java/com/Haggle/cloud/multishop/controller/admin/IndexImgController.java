package com.Haggle.cloud.multishop.controller.admin;

import com.Haggle.cloud.api.product.feign.SpuFeignClient;
import com.Haggle.cloud.api.product.vo.SpuVO;
import com.Haggle.cloud.common.constant.StatusEnum;
import com.Haggle.cloud.common.database.dto.PageDTO;
import com.Haggle.cloud.common.database.vo.PageVO;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.common.security.AuthUserContext;
import com.Haggle.cloud.multishop.dto.IndexImgDTO;
import com.Haggle.cloud.multishop.model.IndexImg;
import com.Haggle.cloud.multishop.service.IndexImgService;
import com.Haggle.cloud.multishop.vo.IndexImgVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;


@RestController("adminIndexImgController")
@RequestMapping("/admin/index_img")
@Tag(name = "admin-轮播图")
public class IndexImgController {

    @Autowired
    private IndexImgService indexImgService;
    @Autowired
    private MapperFacade mapperFacade;
    @Autowired
    private SpuFeignClient spuFeignClient;

	@GetMapping("/page")
	@Operation(summary = "获取轮播图列表" , description = "分页获取轮播图列表")
	public ServerResponseEntity<PageVO<IndexImgVO>> page(@Valid PageDTO pageDTO, IndexImgDTO indexImgDTO) {
	    indexImgDTO.setShopId(AuthUserContext.get().getTenantId());
		PageVO<IndexImgVO> indexImgPage = indexImgService.page(pageDTO, indexImgDTO);
		return ServerResponseEntity.success(indexImgPage);
	}

	@GetMapping
    @Operation(summary = "获取轮播图" , description = "根据imgId获取轮播图")
    public ServerResponseEntity<IndexImgVO> getByImgId(@RequestParam Long imgId) {
        IndexImgVO indexImg = indexImgService.getByImgId(imgId);
        if (Objects.nonNull(indexImg.getSpuId())) {
            ServerResponseEntity<SpuVO> spuResponse = spuFeignClient.getById(indexImg.getSpuId());
            indexImg.setSpu(spuResponse.getData());
        }
        return ServerResponseEntity.success(indexImg);
    }

    @PostMapping
    @Operation(summary = "保存轮播图" , description = "保存轮播图")
    public ServerResponseEntity<Void> save(@Valid @RequestBody IndexImgDTO indexImgDTO) {
        IndexImg indexImg = mapperFacade.map(indexImgDTO, IndexImg.class);
        indexImg.setImgId(null);
        indexImg.setShopId(AuthUserContext.get().getTenantId());
        indexImg.setStatus(StatusEnum.ENABLE.value());
        indexImgService.save(indexImg);
        return ServerResponseEntity.success();
    }

    @PutMapping
    @Operation(summary = "更新轮播图" , description = "更新轮播图")
    public ServerResponseEntity<Void> update(@Valid @RequestBody IndexImgDTO indexImgDTO) {
        IndexImg indexImg = mapperFacade.map(indexImgDTO, IndexImg.class);
        indexImg.setShopId(AuthUserContext.get().getTenantId());
        indexImgService.update(indexImg);
        return ServerResponseEntity.success();
    }

    @DeleteMapping
    @Operation(summary = "删除轮播图" , description = "根据轮播图id删除轮播图")
    public ServerResponseEntity<Void> delete(@RequestParam Long imgId) {
        indexImgService.deleteById(imgId, AuthUserContext.get().getTenantId());
        return ServerResponseEntity.success();
    }
}
