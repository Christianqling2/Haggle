package com.Haggle.cloud.platform.model;

import java.io.Serializable;

import com.Haggle.cloud.common.model.BaseModel;

public class SysConfig extends BaseModel implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private Long id;

    /**
     * key
     */
    private String paramKey;

    /**
     * value
     */
    private String paramValue;

    /**
     * 备注
     */
    private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysConfigVO{" +
				"id=" + id +
				",paramKey=" + paramKey +
				",paramValue=" + paramValue +
				",remark=" + remark +
				'}';
	}
}
