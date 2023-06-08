package com.Haggle.cloud.product.dto.shopcart;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

/
public class CheckShopCartItemDTO {

    @NotNull
    @Schema(description = "购物车ID" , required = true)
    private Long shopCartItemId;

    @NotNull
    @Schema(description = "商品是否勾选 1:勾选 0:未勾选" )
    private Integer isChecked;

    public Long getShopCartItemId() {
        return shopCartItemId;
    }

    public void setShopCartItemId(Long shopCartItemId) {
        this.shopCartItemId = shopCartItemId;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return "CheckShopCartItemDTO{" +
                "shopCartItemId=" + shopCartItemId +
                ", isChecked=" + isChecked +
                '}';
    }
}
