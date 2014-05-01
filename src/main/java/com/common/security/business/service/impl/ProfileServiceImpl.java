package com.common.security.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.common.security.business.service.ProfileService;
import com.common.security.domain.model.Profile;
import com.common.security.persistence.dao.ProfileDao;
import com.common.util.domain.annotation.Service;
import com.common.util.domain.exception.UncheckedException;

/**
 * La clase que implementa la interfaz del servicio para los perfiles.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class ProfileServiceImpl extends SecurityBaseServiceImpl<Profile, Long> implements ProfileService {
	private static final long serialVersionUID = 1L;

	@Override
	@Autowired
	public void setProfileDao(ProfileDao profileDao) {
		this.setDao(profileDao);
	}

	@Override
	public void validate(Profile entity) throws UncheckedException {
		// TODO Hacer el validador del perfil.
	}
}