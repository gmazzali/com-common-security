package com.common.security.business.service.impl;

import java.io.Serializable;

import com.common.security.business.service.SecurityBaseService;
import com.common.util.business.service.impl.BaseServiceImpl;
import com.common.util.domain.model.entity.Persistence;

/**
 * La clase que implementa la interfaz base para los servicios dentro de este framework.
 * 
 * @since 27/02/2014
 * @author Guillermo Mazzali
 * @version 1.0
 * 
 * @param <E>
 *            La clase que vamos a manejar dentro de este servicios.
 * @param <PK>
 *            La clase que corresponde al PK de la clase que vamos a manejar en este servicios.
 */
public abstract class SecurityBaseServiceImpl<E extends Persistence<PK>, PK extends Serializable> extends BaseServiceImpl<E, PK> implements
		SecurityBaseService<E, PK> {
	private static final long serialVersionUID = 1L;
}