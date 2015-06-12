package com.common.security.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.security.domain.model.Resource;
import com.common.security.persistence.dao.ResourceDao;

/**
 * La clase que implementa la interfaz del DAO para los recursos.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class ResourceDaoImpl extends SecurityBaseDaoImpl<Resource, Long> implements ResourceDao {
	private static final long serialVersionUID = 1L;
}