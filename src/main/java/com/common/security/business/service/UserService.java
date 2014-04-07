package com.common.security.business.service;

import com.common.security.domain.model.User;
import com.common.security.persistence.dao.UserDao;

/**
 * La interfaz del servicio para los usuarios.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface UserService extends SecurityBaseService<User, Long> {

	/**
	 * Se encarga de cargar el DAO de los usuarios.
	 * 
	 * @param userDao
	 *            El DAO de los usuarios.
	 */
	public void setUserDao(UserDao userDao);
}