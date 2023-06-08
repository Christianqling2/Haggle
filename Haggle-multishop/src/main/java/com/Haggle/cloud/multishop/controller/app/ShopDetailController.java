package com.Haggle.cloud.multishop.controller.app;

import com.Haggle.cloud.api.multishop.vo.ShopDetailVO;
import com.Haggle.cloud.common.exception.HaggleException;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.multishop.service.ShopDetailService;
import com.Haggle.cloud.multishop.vo.ShopHeadInfoVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RequestMapping(value = "/ua/shop_detail")
@RestController("appShopDetailController")
@Tag(name = "app-店铺详情信息")
public class ShopDetailController {

    @Autowired
    private ShopDetailService shopDetailService;

    @GetMapping("/check_shop_name")
    @Operation(summary = "验证店铺名称是否重名" , description = "验证店铺名称是否重名")
    public ServerResponseEntity<Boolean> checkShopName(@RequestParam("shopName") String shopName) {
        Boolean res = shopDetailService.checkShopName(shopName);
        return ServerResponseEntity.success(res);
    }

    @GetMapping("/head_info")
    @Operation(summary = "店铺头部信息" , description = "店铺头部信息")
    public ServerResponseEntity<ShopHeadInfoVO> getShopHeadInfo(Long shopId) {
        ShopHeadInfoVO shopHeadInfoVO = new ShopHeadInfoVO();
        ShopDetailVO shopDetailVO = shopDetailService.getByShopId(shopId);
        if (Objects.isNull(shopDetailVO)) {
            throw new HaggleException("店铺不存在");
        }
        shopHeadInfoVO.setShopStatus(shopDetailVO.getShopStatus());
        if (!Objects.equals(shopDetailVO.getShopStatus(), 1)) {
            return ServerResponseEntity.success(shopHeadInfoVO);
        }
        shopHeadInfoVO.setShopId(shopId);
        shopHeadInfoVO.setType(shopDetailVO.getType());
        shopHeadInfoVO.setIntro(shopDetailVO.getIntro());
        shopHeadInfoVO.setShopLogo(shopDetailVO.getShopLogo());
        shopHeadInfoVO.setShopName(shopDetailVO.getShopName());
        shopHeadInfoVO.setMobileBackgroundPic(shopDetailVO.getMobileBackgroundPic());
        return ServerResponseEntity.success(shopHeadInfoVO);
    }
}
