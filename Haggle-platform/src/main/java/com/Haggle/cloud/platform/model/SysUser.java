package com.Haggle.cloud.platform.model;

import java.io.Serializable;

import com.Haggle.cloud.common.database.annotations.DistributedId;
import com.Haggle.cloud.common.model.BaseModel;

public class SysUser extends BaseModel implements Serializable{

    /**
     * 平台用户id
     */
	@DistributedId("Haggle-platform-user")
    private Long sysUserId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 员工编号
     */
    private String code;

    /**
     * 联系方式
     */
    private String phoneNum;

    /**
     * 是否已经设置账号
     */
    private Integer hasAccount;

	public Long getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getHasAccount() {
		return hasAccount;
	}

	public void setHasAccount(Integer hasAccount) {
		this.hasAccount = hasAccount;
	}

	@Override
	public String toString() {
		return "SysUserVO{" +
				"sysUserId=" + sysUserId +
				",createTime=" + createTime +
				",updateTime=" + updateTime +
				",nickName=" + nickName +
				",avatar=" + avatar +
				",code=" + code +
				",phoneNum=" + phoneNum +
				",hasAccount=" + hasAccount +
				'}';
	}
}
