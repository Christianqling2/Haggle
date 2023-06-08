package com.Haggle.cloud.product.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.Haggle.cloud.product.mapper.SpuSkuAttrValueMapper;
import com.Haggle.cloud.product.model.SpuSkuAttrValue;
import com.Haggle.cloud.product.service.SpuSkuAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SpuSkuAttrValueServiceImpl implements SpuSkuAttrValueService {

    @Autowired
    private SpuSkuAttrValueMapper spuSkuAttrValueMapper;

    @Override
    public void save(SpuSkuAttrValue spuSkuAttrValue) {
        spuSkuAttrValueMapper.save(spuSkuAttrValue);
    }

    @Override
    public void updateBatch(List<SpuSkuAttrValue> spuSkuAttrValues) {
        if (CollUtil.isNotEmpty(spuSkuAttrValues)) {
            spuSkuAttrValueMapper.updateBatch(spuSkuAttrValues);
        }
    }

    @Override
    public void deleteById(Long spuSkuAttrId) {
        spuSkuAttrValueMapper.deleteById(spuSkuAttrId);
    }

    @Override
    public void saveBatch(List<SpuSkuAttrValue> spuSkuAttrValues) {
        if (CollUtil.isEmpty(spuSkuAttrValues)) {
            return;
        }
        spuSkuAttrValueMapper.saveBatch(spuSkuAttrValues);
    }

    @Override
    public void updateBySpuId(Long spuId) {
        spuSkuAttrValueMapper.updateBySpuId(spuId);
    }

    @Override
    public void changeStatusBySkuId(List<Long> skuIds, Integer status) {
        spuSkuAttrValueMapper.changeStatusBySkuId(skuIds, status);
    }
}
