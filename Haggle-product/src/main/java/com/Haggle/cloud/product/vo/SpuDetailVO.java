package com.Haggle.cloud.product.vo;

import com.Haggle.cloud.common.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;


public class SpuDetailVO extends BaseVO {
    private static final long serialVersionUID = 1L;

    @Schema(description = "商品id" )
    private Long spuId;

    @Schema(description = "商品详情" )
    private String detail;

	public Long getSpuId() {
		return spuId;
	}

	public void setSpuId(Long spuId) {
		this.spuId = spuId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "SpuDetailVO{" +
				"spuId=" + spuId +
				",createTime=" + createTime +
				",updateTime=" + updateTime +
				",detail=" + detail +
				'}';
	}
}
