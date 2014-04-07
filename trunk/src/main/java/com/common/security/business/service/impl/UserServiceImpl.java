package com.common.security.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.common.security.business.service.UserService;
import com.common.security.domain.model.User;
import com.common.security.persistence.dao.UserDao;
import com.common.util.domain.annotation.Service;
import com.common.util.domain.exception.CheckedException;

/**
 * La clase que implementa la interfaz del servicio para los usuarios.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class UserServiceImpl extends SecurityBaseServiceImpl<User, Long> implements UserService {
	private static final long serialVersionUID = 1L;

	@Override
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.setDao(userDao);
	}

	@Override
	public void validate(User entity) throws CheckedException {
		// TODO Hacer el validador del usuario.
	}
}