package com.common.security.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.security.domain.model.Role;
import com.common.security.persistence.dao.RoleDao;

/**
 * La clase que implementa la interfaz del DAO para los roles.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class RoleDaoImpl extends SecurityBaseDaoImpl<Role, Long> implements RoleDao {
	private static final long serialVersionUID = 1L;
}