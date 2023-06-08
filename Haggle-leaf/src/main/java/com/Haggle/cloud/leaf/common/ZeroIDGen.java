package com.Haggle.cloud.leaf.common;

import com.Haggle.cloud.leaf.IDGen;


public class ZeroIDGen implements IDGen {

	@Override
	public Result get(String key) {
		return new Result(0, Status.SUCCESS);
	}

	@Override
	public boolean init() {
		return true;
	}

}
