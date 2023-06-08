package com.Haggle.cloud.auth.controller;

import com.Haggle.cloud.common.security.bo.TokenInfoBO;
import com.Haggle.cloud.auth.dto.RefreshTokenDTO;
import com.Haggle.cloud.auth.manager.TokenStore;
import com.Haggle.cloud.api.auth.vo.TokenInfoVO;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@Tag(name = "token")
public class TokenController {

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private MapperFacade mapperFacade;

	@PostMapping("/ua/token/refresh")
	public ServerResponseEntity<TokenInfoVO> refreshToken(@Valid @RequestBody RefreshTokenDTO refreshTokenDTO) {
		ServerResponseEntity<TokenInfoBO> tokenInfoServerResponseEntity = tokenStore
				.refreshToken(refreshTokenDTO.getRefreshToken());
		if (!tokenInfoServerResponseEntity.isSuccess()) {
			return ServerResponseEntity.transform(tokenInfoServerResponseEntity);
		}
		return ServerResponseEntity
				.success(mapperFacade.map(tokenInfoServerResponseEntity.getData(), TokenInfoVO.class));
	}

}
