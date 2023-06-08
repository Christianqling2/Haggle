package com.Haggle.cloud.rbac.service.impl;

import com.Haggle.cloud.common.cache.constant.CacheNames;
import com.Haggle.cloud.rbac.mapper.MenuMapper;
import com.Haggle.cloud.rbac.model.Menu;
import com.Haggle.cloud.rbac.service.MenuService;
import com.Haggle.cloud.rbac.vo.MenuSimpleVO;
import com.Haggle.cloud.rbac.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public MenuVO getByMenuId(Long menuId) {
		return menuMapper.getByMenuId(menuId);
	}

	@Override
	@CacheEvict(cacheNames = CacheNames.MENU_LIST_KEY, key = "#menu.bizType")
	public void save(Menu menu) {
		menuMapper.save(menu);
	}

	@Override
	@CacheEvict(cacheNames = CacheNames.MENU_LIST_KEY, key = "#menu.bizType")
	public void update(Menu menu) {
		menuMapper.update(menu);
	}

	@Override
	@CacheEvict(cacheNames = CacheNames.MENU_LIST_KEY, key = "#sysType")
	public void deleteById(Long menuId, Integer sysType) {
		menuMapper.deleteById(menuId,sysType);
	}

	@Override
	@Cacheable(cacheNames = CacheNames.MENU_LIST_KEY, key = "#sysType")
	public List<Menu> listBySysType(Integer sysType) {
		return menuMapper.listBySysType(sysType);
	}

    @Override
    public List<MenuSimpleVO> listWithPermissions(Integer sysType) {
        return menuMapper.listWithPermissions(sysType);
    }

	@Override
	@Cacheable(cacheNames = CacheNames.MENU_ID_LIST_KEY, key = "#userId")
	public List<Long> listMenuIds(Long userId) {
		return menuMapper.listMenuIds(userId);
	}

}
