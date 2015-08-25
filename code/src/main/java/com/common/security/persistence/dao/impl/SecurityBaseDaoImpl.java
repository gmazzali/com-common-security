package com.common.security.persistence.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.security.persistence.dao.SecurityBaseDao;
import com.common.util.domain.model.entity.Persistence;
import com.common.util.persistence.dao.impl.BaseDaoImpl;

/**
 * La clase que implementa la interfaz base para los DAOs dentro de este framework.
 * 
 * @since 05/02/2014
 * @author Guillermo Mazzali
 * @version 1.0
 * 
 * @param <E>
 *            La clase que vamos a manejar dentro de este DAO.
 * @param <PK>
 *            La clase que corresponde al PK de la clase que vamos a manejar en este DAO.
 */
public abstract class SecurityBaseDaoImpl<E extends Persistence<PK>, PK extends Serializable> extends BaseDaoImpl<E, PK> implements
		SecurityBaseDao<E, PK> {
	private static final long serialVersionUID = 1L;

	@Override
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}