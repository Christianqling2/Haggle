package com.Haggle.cloud.rbac.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.Haggle.cloud.rbac.mapper.UserRoleMapper;
import com.Haggle.cloud.rbac.service.UserRoleService;


@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	private UserRoleMapper userRoleMapper;

}
