package com.common.security.business.service;

import java.io.Serializable;

import com.common.util.business.service.BaseService;
import com.common.util.domain.model.Persistence;

/**
 * La interfaz que define el servicio base para el framework de seguridad.
 * 
 * @since 27/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 * 
 * @param <E>
 *            La clase que vamos a manejar dentro de este servicio.
 * @param <PK>
 *            La clase que corresponde al PK de la clase que vamos a manejar en este servicio.
 */
public interface SecurityBaseService<E extends Persistence<PK>, PK extends Serializable> extends BaseService<E, PK> {
}