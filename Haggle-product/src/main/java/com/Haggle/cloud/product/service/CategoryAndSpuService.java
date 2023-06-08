package com.Haggle.cloud.product.service;

import com.Haggle.cloud.api.product.vo.CategoryVO;
import com.Haggle.cloud.product.dto.CategoryDTO;
import com.Haggle.cloud.product.model.Category;

import java.util.List;


public interface CategoryAndSpuService {
	/**
	 * 分类的启用和禁用
	 * @param categoryDTO
	 * @return
	 */
    Boolean categoryEnableOrDisable(CategoryDTO categoryDTO);

}
