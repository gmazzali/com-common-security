package com.common.security.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.security.domain.model.Access;
import com.common.security.persistence.dao.AccessDao;

/**
 * La clase que implementa la interfaz del DAO para los accesos.
 * 
 * @since 08/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class AccessDaoImpl extends SecurityBaseDaoImpl<Access, Long> implements AccessDao {
	private static final long serialVersionUID = 1L;
}