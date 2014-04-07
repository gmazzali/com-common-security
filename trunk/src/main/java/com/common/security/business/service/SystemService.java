package com.common.security.business.service;

import com.common.security.domain.model.System;
import com.common.security.persistence.dao.SystemDao;

/**
 * La interfaz del servicio para los sistemas.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface SystemService extends SecurityBaseService<System, Long> {

	/**
	 * Se encarga de cargar el DAO de los sistemas.
	 * 
	 * @param userDao
	 *            El DAO de los sistemas.
	 */
	public void setSystemDao(SystemDao systemDao);
}