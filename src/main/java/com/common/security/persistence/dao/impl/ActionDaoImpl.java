package com.common.security.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.security.domain.model.Action;
import com.common.security.persistence.dao.ActionDao;

/**
 * La clase que implementa la interfaz del DAO para las acciones.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class ActionDaoImpl extends SecurityBaseDaoImpl<Action, Long> implements ActionDao {
	private static final long serialVersionUID = 1L;
}