package com.common.security.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.common.security.business.service.AccessService;
import com.common.security.domain.model.Access;
import com.common.security.persistence.dao.AccessDao;
import com.common.util.domain.annotation.Service;
import com.common.util.domain.exception.CheckedException;

/**
 * La clase que implementa la interfaz del servicio para los accesos.
 * 
 * @since 08/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class AccessServiceImpl extends SecurityBaseServiceImpl<Access, Long> implements AccessService {
	private static final long serialVersionUID = 1L;

	@Override
	@Autowired
	public void setAccessDao(AccessDao accessDao) {
		this.setDao(accessDao);
	}

	@Override
	public void validate(Access entity) throws CheckedException {
		// TODO Hacer el validador del acceso.
	}
}