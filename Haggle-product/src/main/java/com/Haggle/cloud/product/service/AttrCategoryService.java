package com.Haggle.cloud.product.service;

import com.Haggle.cloud.api.product.vo.CategoryVO;

import java.util.List;


public interface AttrCategoryService {

	/**
	 * 保存属性与属性分组关联信息
	 * @param attrId 属性id
	 * @param categoryId 分类id列表
	 */
	void save(Long attrId, List<Long> categoryId);

	/**
	 * 更新属性与属性分组关联信息
	 * @param attrId
	 * @param categoryId
	 * @return
	 */
	List<Long> update(Long attrId, List<Long> categoryId);

	/**
	 * 根据属性Id，获取属性关联的分类列表信息
	 * @param attrId
	 * @return
	 */
    List<CategoryVO> listByAttrId(Long attrId);
}
