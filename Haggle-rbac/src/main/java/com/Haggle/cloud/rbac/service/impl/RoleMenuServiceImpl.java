package com.Haggle.cloud.rbac.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.Haggle.cloud.rbac.mapper.RoleMenuMapper;
import com.Haggle.cloud.rbac.service.RoleMenuService;


@Service
public class RoleMenuServiceImpl implements RoleMenuService {

	@Resource
	private RoleMenuMapper roleMenuMapper;

}
