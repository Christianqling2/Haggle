package com.Haggle.cloud.order.service.impl;

import com.Haggle.cloud.order.model.OrderPayInfo;
import com.Haggle.cloud.order.mapper.OrderPayInfoMapper;
import com.Haggle.cloud.order.service.OrderPayInfoService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;


public class OrderPayInfoServiceImpl implements OrderPayInfoService {

    @Autowired
    private OrderPayInfoMapper orderPayInfoMapper;

    @Override
    public void save(OrderPayInfo orderPayInfo) {
        orderPayInfoMapper.save(orderPayInfo);
    }

    @Override
    public void update(OrderPayInfo orderPayInfo) {
        orderPayInfoMapper.update(orderPayInfo);
    }

    @Override
    public void deleteById(Long payId) {
        orderPayInfoMapper.deleteById(payId);
    }
}
