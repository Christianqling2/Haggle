package com.Haggle.cloud.order.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.Haggle.cloud.order.model.OrderItem;
import com.Haggle.cloud.order.mapper.OrderItemMapper;
import com.Haggle.cloud.order.service.OrderItemService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public void save(OrderItem orderItem) {
        orderItemMapper.save(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        orderItemMapper.update(orderItem);
    }

    @Override
    public void deleteById(Long orderItemId) {
        orderItemMapper.deleteById(orderItemId);
    }

    @Override
    public List<OrderItem> listOrderItemsByOrderId(Long orderId) {
        return orderItemMapper.listOrderItemsByOrderId(orderId);
    }

    @Override
    public void saveBatch(List<OrderItem> orderItems) {
        if (CollUtil.isEmpty(orderItems)) {
            return;
        }
        orderItemMapper.saveBatch(orderItems);
    }

    @Override
    public List<String> getSpuNameListByOrderIds(long[] orderIdList) {
        return orderItemMapper.getSpuNameListByOrderIds(orderIdList);
    }

    @Override
    public Integer countByOrderId(Long orderId) {
        return orderItemMapper.countByOrderId(orderId);
    }


}
