package com.common.security.business.holder;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.common.security.domain.model.User;

/**
 * La clase donde vamos a mantener el sistema y el usuario que se encuentra logueado.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class SecurityHolder implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * El sistema cargado.
	 */
	private System system;
	/**
	 * El usuario logueado.
	 */
	private User user;
	/**
	 * La fecha del logueo del usuario dentro del sistema.
	 */
	private Date fechaLogin;

	/**
	 * El constructor del holder de seguridad.
	 */
	public SecurityHolder() {
		super();
	}

	/**
	 * Permite recuperar el sistema que actualmente se esta ejecutando en el contexto.
	 * 
	 * @return El sistema que se esta ejecutando en el contexto.
	 */
	public System getSystem() {
		return system;
	}

	/**
	 * Permite cargar el sistema que se esta ejecutando en el contexto.
	 * 
	 * @param system
	 *            El sistema que se esta ejecutando en el contexto.
	 */
	public void setSystem(System system) {
		this.system = system;
	}

	/**
	 * Permite recuperar el usuario que actualmente se encuentra logueado en el contexto.
	 * 
	 * @return El usuario que se encuentra logueado en el contexto.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Permite cargar el usuario que actualmente se encuentra logueado en el contexto.
	 * 
	 * @param user
	 *            El usuario que se encuentra logueado en el contexto.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Permite recuperar la fecha a la que se logueo el usuario al sistema.
	 * 
	 * @return La fecha a la que se logueo el usuario al sistema.
	 */
	public Date getFechaLogin() {
		return fechaLogin;
	}

	/**
	 * Permite cargar la fecha a la que se logueo el usuario al sistema.
	 * 
	 * @param user
	 *            La fecha a la que se logueo el usuario al sistema.
	 */
	public void setFechaLogin(Date fechaLogin) {
		this.fechaLogin = fechaLogin;
	}
}