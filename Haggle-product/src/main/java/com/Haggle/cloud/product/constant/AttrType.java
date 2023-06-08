package com.Haggle.cloud.product.constant;


public enum AttrType {

	/**
	 * 销售属性
	 */
	SALES(0),

	/**
	 * 基本属性
	 */
	BASIC(1)
	;

	private final Integer value;

	public Integer value() {
		return value;
	}

	AttrType(Integer value) {
		this.value = value;
	}

}
