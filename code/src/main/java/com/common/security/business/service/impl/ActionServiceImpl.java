package com.common.security.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.security.business.service.ActionService;
import com.common.security.domain.model.Action;
import com.common.security.persistence.dao.ActionDao;
import com.common.util.domain.exception.UncheckedException;

/**
 * La clase que implementa la interfaz del servicio para las acciones.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class ActionServiceImpl extends SecurityBaseServiceImpl<Action, Long> implements ActionService {
	private static final long serialVersionUID = 1L;

	@Override
	@Autowired
	public void setActionDao(ActionDao actionDao) {
		this.setDao(actionDao);
	}

	@Override
	public void validate(Action entity) throws UncheckedException {
		// TODO Hacer el validador de la acción.
	}
}