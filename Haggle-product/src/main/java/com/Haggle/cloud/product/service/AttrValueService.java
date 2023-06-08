package com.Haggle.cloud.product.service;

import com.Haggle.cloud.api.product.vo.AttrVO;
import com.Haggle.cloud.product.model.Attr;
import com.Haggle.cloud.product.model.AttrValue;

import java.util.List;


public interface AttrValueService {
	/**
	 * 根据属性值信息和属性id，保存属性值信息
	 * @param attrValues
	 * @param attrId
	 */
    void saveByAttrValuesAndAttrId(List<AttrValue> attrValues, Long attrId);

	/**
	 * 根据属性值信息和属性id，更新属性值信息
	 * @param attrVO
	 * @param dbAttr
	 */
	void update(Attr attrVO, AttrVO dbAttr);
}
