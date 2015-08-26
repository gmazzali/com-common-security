package com.common.security.persistence.dao;

import com.common.security.domain.model.PasswordHistory;

/**
 * La interfaz del DAO para el historial de los cambios de password.
 * 
 * @since 25/08/2015
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface PasswordHistoryDao extends SecurityBaseDao<PasswordHistory, Long> {
}