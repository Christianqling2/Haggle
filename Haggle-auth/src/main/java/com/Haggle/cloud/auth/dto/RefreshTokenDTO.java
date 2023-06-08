package com.Haggle.cloud.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;


public class RefreshTokenDTO {

	/**
	 * refreshToken
	 */
	@NotBlank(message = "refreshToken不能为空")
	@Schema(description = "refreshToken" , required = true)
	private String refreshToken;

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Override
	public String toString() {
		return "RefreshTokenDTO{" + "refreshToken='" + refreshToken + '\'' + '}';
	}

}
