package com.common.security.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.security.domain.model.Profile;
import com.common.security.persistence.dao.ProfileDao;

/**
 * La clase que implementa la interfaz del DAO para los perfiles.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class ProfileDaoImpl extends SecurityBaseDaoImpl<Profile, Long> implements ProfileDao {
	private static final long serialVersionUID = 1L;
}