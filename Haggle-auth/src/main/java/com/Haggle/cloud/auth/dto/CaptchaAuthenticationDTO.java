package com.Haggle.cloud.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;


public class CaptchaAuthenticationDTO extends AuthenticationDTO {

	@Schema(description = "验证码" , required = true)
	private String captchaVerification;

	public String getCaptchaVerification() {
		return captchaVerification;
	}

	public void setCaptchaVerification(String captchaVerification) {
		this.captchaVerification = captchaVerification;
	}


	@Override
	public String toString() {
		return "CaptchaAuthenticationDTO{" + "captchaVerification='" + captchaVerification + '\'' + "} "
				+ super.toString();
	}

}
