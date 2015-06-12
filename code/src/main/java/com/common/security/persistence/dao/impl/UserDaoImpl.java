package com.common.security.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.security.domain.model.User;
import com.common.security.persistence.dao.UserDao;

/**
 * La clase que implementa la interfaz del DAO para los usuarios.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class UserDaoImpl extends SecurityBaseDaoImpl<User, Long> implements UserDao {
	private static final long serialVersionUID = 1L;
}