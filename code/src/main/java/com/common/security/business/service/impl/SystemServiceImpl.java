package com.common.security.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.security.business.service.SystemService;
import com.common.security.domain.model.System;
import com.common.security.persistence.dao.SystemDao;
import com.common.util.domain.exception.UncheckedException;

/**
 * La clase que implementa la interfaz del servicio para los sistemas.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class SystemServiceImpl extends SecurityBaseServiceImpl<System, Long> implements SystemService {
	private static final long serialVersionUID = 1L;

	@Override
	@Autowired
	public void setSystemDao(SystemDao systemDao) {
		this.setDao(systemDao);
	}

	@Override
	public void validate(System entity) throws UncheckedException {
		// TODO Hacer el validador del sistema.
	}
}