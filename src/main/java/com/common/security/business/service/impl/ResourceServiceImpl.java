package com.common.security.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.common.security.business.service.ResourceService;
import com.common.security.domain.model.Resource;
import com.common.security.persistence.dao.ResourceDao;
import com.common.util.domain.annotation.Service;
import com.common.util.domain.exception.UncheckedException;

/**
 * La clase que implementa la interfaz del servicio para los recursos.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class ResourceServiceImpl extends SecurityBaseServiceImpl<Resource, Long> implements ResourceService {
	private static final long serialVersionUID = 1L;

	@Override
	@Autowired
	public void setResourceDao(ResourceDao resourceDao) {
		this.setDao(resourceDao);
	}

	@Override
	public void validate(Resource entity) throws UncheckedException {
		// TODO Hacer el validador del recurso.
	}
}