package com.Haggle.cloud.leaf;

import com.Haggle.cloud.leaf.common.Result;

/**
 * /**/ leaf
 */
public interface IDGen {

	/**
	 * get
	 * @param key key
	 * @return Result
	 */
	Result get(String key);

	/**
	 * init
	 * @return inited
	 */
	boolean init();

}
