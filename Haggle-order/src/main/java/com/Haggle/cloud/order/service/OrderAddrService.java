package com.Haggle.cloud.order.service;

import com.Haggle.cloud.common.database.dto.PageDTO;
import com.Haggle.cloud.common.database.vo.PageVO;
import com.Haggle.cloud.order.model.OrderAddr;


public interface OrderAddrService {

	/**
	 * 分页获取用户订单配送地址列表
	 * @param pageDTO 分页参数
	 * @return 用户订单配送地址列表分页数据
	 */
	PageVO<OrderAddr> page(PageDTO pageDTO);

	/**
	 * 根据用户订单配送地址id获取用户订单配送地址
	 *
	 * @param orderAddrId 用户订单配送地址id
	 * @return 用户订单配送地址
	 */
	OrderAddr getByOrderAddrId(Long orderAddrId);

	/**
	 * 保存用户订单配送地址
	 * @param orderAddr 用户订单配送地址
	 */
	void save(OrderAddr orderAddr);

	/**
	 * 更新用户订单配送地址
	 * @param orderAddr 用户订单配送地址
	 */
	void update(OrderAddr orderAddr);

	/**
	 * 根据用户订单配送地址id删除用户订单配送地址
	 * @param orderAddrId
	 */
	void deleteById(Long orderAddrId);
}
