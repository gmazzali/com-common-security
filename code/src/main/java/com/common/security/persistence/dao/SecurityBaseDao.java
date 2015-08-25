package com.common.security.persistence.dao;

import java.io.Serializable;

import com.common.util.domain.model.entity.Persistence;
import com.common.util.persistence.dao.BaseDao;

/**
 * La interfaz que define el DAO base para el framework de seguridad.
 * 
 * @since 11/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 * 
 * @param <E>
 *            La clase que vamos a manejar dentro de este DAO.
 * @param <PK>
 *            La clase que corresponde al PK de la clase que vamos a manejar en este DAO.
 */
public interface SecurityBaseDao<E extends Persistence<PK>, PK extends Serializable> extends BaseDao<E, PK> {
}