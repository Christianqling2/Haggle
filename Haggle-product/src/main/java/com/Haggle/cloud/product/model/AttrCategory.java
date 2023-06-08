package com.Haggle.cloud.product.model;

import java.io.Serializable;

import com.Haggle.cloud.common.model.BaseModel;



public class AttrCategory extends BaseModel implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 属性与分类关联id
     */
    private Long attrCategoryId;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 属性id
     */
    private Long attrId;

	public Long getAttrCategoryId() {
		return attrCategoryId;
	}

	public void setAttrCategoryId(Long attrCategoryId) {
		this.attrCategoryId = attrCategoryId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	@Override
	public String toString() {
		return "AttrCategory{" +
				"attrCategoryId=" + attrCategoryId +
				",createTime=" + createTime +
				",updateTime=" + updateTime +
				",categoryId=" + categoryId +
				",attrId=" + attrId +
				'}';
	}
}
