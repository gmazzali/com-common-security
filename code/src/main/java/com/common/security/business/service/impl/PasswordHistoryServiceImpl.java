package com.common.security.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.security.business.service.PasswordHistoryService;
import com.common.security.domain.model.PasswordHistory;
import com.common.security.persistence.dao.PasswordHistoryDao;
import com.common.util.domain.exception.UncheckedException;

/**
 * La clase que implementa la interfaz del servicio para el historial de los cambios de passwords.
 * 
 * @since 25/08/2015
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class PasswordHistoryServiceImpl extends SecurityBaseServiceImpl<PasswordHistory, Long> implements PasswordHistoryService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setPasswordHistoryDao(PasswordHistoryDao accessDao) {
		this.setDao(accessDao);
	}

	@Override
	public void validate(PasswordHistory entity) throws UncheckedException {
		// TODO Hacer el validador del acceso.
	}
}