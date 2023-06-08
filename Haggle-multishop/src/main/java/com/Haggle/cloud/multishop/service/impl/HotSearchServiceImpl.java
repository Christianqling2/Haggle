package com.Haggle.cloud.multishop.service.impl;

import com.Haggle.cloud.common.cache.constant.CacheNames;
import com.Haggle.cloud.common.database.dto.PageDTO;
import com.Haggle.cloud.common.database.util.PageUtil;
import com.Haggle.cloud.common.database.vo.PageVO;
import com.Haggle.cloud.multishop.dto.HotSearchDTO;
import com.Haggle.cloud.multishop.model.HotSearch;
import com.Haggle.cloud.multishop.mapper.HotSearchMapper;
import com.Haggle.cloud.multishop.service.HotSearchService;
import com.Haggle.cloud.multishop.vo.HotSearchVO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 热搜
 *
 * /**/ YXF
 * @date 2021-01-27 09:10:00
 */
@Service
public class HotSearchServiceImpl implements HotSearchService {

    @Autowired
    private HotSearchMapper hotSearchMapper;

    @Override
    public PageVO<HotSearchVO> page(PageDTO pageDTO, HotSearchDTO hotSearchDTO) {
        return PageUtil.doPage(pageDTO, () -> hotSearchMapper.list(hotSearchDTO));
    }

    @Override
    public HotSearchVO getByHotSearchId(Long hotSearchId) {
        return hotSearchMapper.getByHotSearchId(hotSearchId);
    }

    @Override
    public void save(HotSearch hotSearch) {
        hotSearchMapper.save(hotSearch);
    }

    @Override
    public void update(HotSearch hotSearch) {
        hotSearchMapper.update(hotSearch);
    }

    @Override
    public void deleteById(Long hotSearchId, Long shopId) {
        hotSearchMapper.deleteById(hotSearchId, shopId);
    }

    @Override
    @Cacheable(cacheNames = CacheNames.HOT_SEARCH_LIST_KEY, key = "#shopId")
    public List<HotSearchVO> listByShopId(Long shopId) {
        return hotSearchMapper.listByShopId(shopId);
    }

    @Override
    @CacheEvict(cacheNames = CacheNames.HOT_SEARCH_LIST_KEY, key = "#shopId")
    public void removeHotSearchListCache(Long shopId) {
    }
}
