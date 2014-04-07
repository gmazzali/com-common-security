package com.common.security.business.service;

import com.common.security.domain.model.Profile;
import com.common.security.persistence.dao.ProfileDao;

/**
 * La interfaz del servicio para los perfiles.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface ProfileService extends SecurityBaseService<Profile, Long> {

	/**
	 * Se encarga de cargar el DAO de los perfiles.
	 * 
	 * @param profileDao
	 *            El DAO de los perfiles.
	 */
	public void setProfileDao(ProfileDao profileDao);
}