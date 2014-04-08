package com.common.security.business.service;

import com.common.security.domain.model.Access;
import com.common.security.persistence.dao.AccessDao;

/**
 * La interfaz del servicio para los accesos.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface AccessService extends SecurityBaseService<Access, Long> {

	/**
	 * Se encarga de cargar el DAO de los accesos.
	 * 
	 * @param accessDao
	 *            El DAO de los accesos.
	 */
	public void setAccessDao(AccessDao accessDao);
}