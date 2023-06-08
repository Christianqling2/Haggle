package com.Haggle.cloud.leaf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * /**/ leaf
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class LeafServerException extends RuntimeException {

	public LeafServerException(String msg) {
		super(msg);
	}

}
