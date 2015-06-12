package com.common.security.business.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.common.security.business.service.UserService;
import com.common.security.domain.model.Disablement;
import com.common.security.domain.model.User;
import com.common.security.persistence.dao.UserDao;
import com.common.util.business.tool.date.DatePrecision;
import com.common.util.business.tool.date.DateUtil;
import com.common.util.domain.annotation.Service;
import com.common.util.domain.exception.UncheckedException;

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
	public Boolean isDisabledUser(User user) {
		Date today = new Date();
		for (Disablement disablement : user.getDisablements()) {
			if (DateUtil.between(today, disablement.getValidFrom(), disablement.getValidTo(), DatePrecision.MILLISECOND)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void validate(User entity) throws UncheckedException {
		// TODO Hacer el validador del usuario.
	}

	@Override
	public Boolean login(String userName, String password) {
		// TODO Hacer el login del usuario.
		return null;
	}
}