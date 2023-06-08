package com.Haggle.cloud.order.service.impl;

import com.Haggle.cloud.common.database.dto.PageDTO;
import com.Haggle.cloud.common.database.util.PageUtil;
import com.Haggle.cloud.common.database.vo.PageVO;
import com.Haggle.cloud.order.mapper.OrderAddrMapper;
import com.Haggle.cloud.order.model.OrderAddr;
import com.Haggle.cloud.order.service.OrderAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderAddrServiceImpl implements OrderAddrService {

    @Autowired
    private OrderAddrMapper orderAddrMapper;

    @Override
    public PageVO<OrderAddr> page(PageDTO pageDTO) {
        return PageUtil.doPage(pageDTO, () -> orderAddrMapper.list());
    }

    @Override
    public OrderAddr getByOrderAddrId(Long orderAddrId) {
        return orderAddrMapper.getByOrderAddrId(orderAddrId);
    }

    @Override
    public void save(OrderAddr orderAddr) {
        orderAddrMapper.save(orderAddr);
    }

    @Override
    public void update(OrderAddr orderAddr) {
        orderAddrMapper.update(orderAddr);
    }

    @Override
    public void deleteById(Long orderAddrId) {
        orderAddrMapper.deleteById(orderAddrId);
    }
}
