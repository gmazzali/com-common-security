package com.common.security.business.service;

import com.common.security.domain.model.Resource;
import com.common.security.persistence.dao.ResourceDao;

/**
 * La interfaz del servicio para los recursos.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface ResourceService extends SecurityBaseService<Resource, Long> {

	/**
	 * Se encarga de cargar el DAO de los recursos.
	 * 
	 * @param resourceDao
	 *            El DAO de los recursos.
	 */
	public void setResourceDao(ResourceDao resourceDao);
}