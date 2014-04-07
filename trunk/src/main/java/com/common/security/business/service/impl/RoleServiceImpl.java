package com.common.security.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.common.security.business.service.RoleService;
import com.common.security.domain.model.Role;
import com.common.security.persistence.dao.RoleDao;
import com.common.util.domain.annotation.Service;
import com.common.util.domain.exception.CheckedException;

/**
 * La clase que implementa la interfaz del servicio para los roles.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class RoleServiceImpl extends SecurityBaseServiceImpl<Role, Long> implements RoleService {
	private static final long serialVersionUID = 1L;

	@Override
	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.setDao(roleDao);
	}

	@Override
	public void validate(Role entity) throws CheckedException {
		// TODO Hacer el validador del rol.
	}
}