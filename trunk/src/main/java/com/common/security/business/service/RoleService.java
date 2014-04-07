package com.common.security.business.service;

import com.common.security.domain.model.Role;
import com.common.security.persistence.dao.RoleDao;

/**
 * La interfaz del servicio para los roles.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface RoleService extends SecurityBaseService<Role, Long> {

	/**
	 * Se encarga de cargar el DAO de los roles.
	 * 
	 * @param profileDao
	 *            El DAO de los roles.
	 */
	public void setRoleDao(RoleDao roleDao);
}