package com.common.security.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.security.domain.model.System;
import com.common.security.persistence.dao.SystemDao;

/**
 * La clase que implementa la interfaz del DAO para los usuarios.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class SystemDaoImpl extends SecurityBaseDaoImpl<System, Long> implements SystemDao {
	private static final long serialVersionUID = 1L;
}