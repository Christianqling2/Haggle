package com.Haggle.cloud.common.exception;

import com.Haggle.cloud.common.response.ResponseEnum;

/**
 * /**/ FrozenWatermelon
 * @date 2020/7/11
 */
public class HaggleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Object object;

	private ResponseEnum responseEnum;

	public HaggleException(String msg) {
		super(msg);
	}

	public HaggleException(String msg, Object object) {
		super(msg);
		this.object = object;
	}

	public HaggleException(String msg, Throwable cause) {
		super(msg, cause);
	}


	public HaggleException(ResponseEnum responseEnum) {
		super(responseEnum.getMsg());
		this.responseEnum = responseEnum;
	}

	public HaggleException(ResponseEnum responseEnum, Object object) {
		super(responseEnum.getMsg());
		this.responseEnum = responseEnum;
		this.object = object;
	}


	public Object getObject() {
		return object;
	}

	public ResponseEnum getResponseEnum() {
		return responseEnum;
	}

}
