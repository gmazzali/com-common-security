package com.common.security.business.service;

import com.common.security.domain.model.Action;
import com.common.security.persistence.dao.ActionDao;

/**
 * La interfaz del servicio para las acciones.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface ActionService extends SecurityBaseService<Action, Long> {

	/**
	 * Se encarga de cargar el DAO de las acciones.
	 * 
	 * @param actionDao
	 *            El DAO de las acciones.
	 */
	public void setActionDao(ActionDao actionDao);
}