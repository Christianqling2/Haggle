package com.Haggle.cloud.product.service.impl;

import com.Haggle.cloud.product.mapper.SpuDetailMapper;
import com.Haggle.cloud.product.model.SpuDetail;
import com.Haggle.cloud.product.service.SpuDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuDetailServiceImpl implements SpuDetailService {

    @Autowired
    private SpuDetailMapper spuDetailMapper;

    @Override
    public void save(SpuDetail spuDetail) {
        spuDetailMapper.save(spuDetail);
    }

    @Override
    public void update(SpuDetail spuDetail) {
        spuDetailMapper.update(spuDetail);
    }

    @Override
    public void deleteById(Long spuId) {
        spuDetailMapper.deleteById(spuId);
    }
}
