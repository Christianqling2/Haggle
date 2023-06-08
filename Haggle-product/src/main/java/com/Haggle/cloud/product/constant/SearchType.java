package com.Haggle.cloud.product.constant;


public enum SearchType {

	/**
	 * 不需要作为搜索参数
	 */
	NOT_SEARCH(0),

	/**
	 * 搜索参数
	 */
	SEARCH(1)
	;

	private final Integer value;

	public Integer value() {
		return value;
	}

	SearchType(Integer value) {
		this.value = value;
	}

}
