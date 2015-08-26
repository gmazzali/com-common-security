package com.common.security.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.security.domain.model.PasswordHistory;
import com.common.security.persistence.dao.PasswordHistoryDao;

/**
 * La clase que implementa la interfaz del DAO para el historial de los cambios de password.
 * 
 * @since 25/08/2015
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class PasswordHistoryDaoImpl extends SecurityBaseDaoImpl<PasswordHistory, Long> implements PasswordHistoryDao {
	private static final long serialVersionUID = 1L;
}