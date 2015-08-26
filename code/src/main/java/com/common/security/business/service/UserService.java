package com.common.security.business.service;

import com.common.security.domain.model.User;

/**
 * La interfaz del servicio para los usuarios.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface UserService extends SecurityBaseService<User, Long> {

	/**
	 * Permite saber si un usuario se encuentra deshabilitado dentro del sistema.
	 * 
	 * @param El
	 *            usuario que vamos a validar si esta habilitado o no dentro del sistema.
	 * @return <i>true</i> en caso de que el usuario actualmente se encuentre deshabilitado, en caso contrario, retorna <i>false</i>.
	 */
	public Boolean isDisabledUser(User user);

	public Boolean login(String userName, String password);
}