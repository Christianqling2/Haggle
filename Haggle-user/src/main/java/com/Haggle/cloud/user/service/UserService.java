package com.Haggle.cloud.user.service;

import com.Haggle.cloud.api.user.vo.UserApiVO;
import com.Haggle.cloud.common.database.dto.PageDTO;
import com.Haggle.cloud.common.database.vo.PageVO;
import com.Haggle.cloud.user.dto.UserRegisterDTO;
import com.Haggle.cloud.user.model.User;

import java.util.List;


public interface UserService {

	/**
	 * 分页获取用户表列表
	 * @param pageDTO 分页参数
	 * @return 用户表列表分页数据
	 */
	PageVO<UserApiVO> page(PageDTO pageDTO);

	/**
	 * 根据用户表id获取用户表
	 *
	 * @param userId 用户表id
	 * @return 用户表
	 */
	UserApiVO getByUserId(Long userId);

	/**
	 * 更新用户表
	 * @param user 用户表
	 */
	void update(User user);

	/**
	 * 根据用户id列表，获取用户信息
	 * @param userIds
	 * @return
	 */
	List<UserApiVO> getUserByUserIds(List<Long> userIds);

	/**
	 * 根据用户id获取用户详细信息
	 * @param userId 用户id
	 * @return 用户详细信息
	 */
	UserApiVO getUserAndOpenIdsByUserId(Long userId);

	/**
	 * 保存用户
	 * @param param 注册信息
	 * @return uid
	 */
    Long save(UserRegisterDTO param);
}
