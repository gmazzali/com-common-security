package com.common.security.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Permite representar una participación de un usuario dentro de un sistema dado.
 * 
 * @since 05/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class Participation extends Temporal<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * El usuario de la participación.
	 */
	private User user;
	/**
	 * El sistema donde va a participar el usuario.
	 */
	private System system;
	/**
	 * El perfil con el que participa el usuario dentro del sistema.
	 */
	private Profile profile;
	/**
	 * El valor que indica si el usuario esta habilitado para participar del sistema.
	 */
	private Boolean enabled;
	/**
	 * el conjunto de sesiones que corresponde al usuario dentro del sistema.
	 */
	private Set<Session> sessions;

	/**
	 * El consdtructor de una participación.
	 */
	public Participation() {
		this.enabled = false;
		this.sessions = new HashSet<Session>();
	}

	@Id
	@Override
	@Column(name = "ID_SECURITY_PARTICIPATION", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/**
	 * Retorna el usuario de la participación.
	 * 
	 * @return El usuario de la participación.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_USER", referencedColumnName = "ID_SECURITY_USER", nullable = false)
	public User getUser() {
		return this.user;
	}

	/**
	 * Carga el usuario de la participación.
	 * 
	 * @param user
	 *            El usuario de la participación.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Retorna el sistema de la participación.
	 * 
	 * @return El sistema de la participación.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_SYSTEM", referencedColumnName = "ID_SECURITY_SYSTEM", nullable = false)
	public System getSystem() {
		return this.system;
	}

	/**
	 * Carga el sistema de la participación.
	 * 
	 * @param system
	 *            El sistema de la participación.
	 */
	public void setSystem(System system) {
		this.system = system;
	}

	/**
	 * Retorna el perfil con el que participa el usuario dentro del sistema.
	 * 
	 * @return El perfil con el que participa el usuario dentro del sistema.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_PROFILE", referencedColumnName = "ID_SECURITY_PROFILE", nullable = false)
	public Profile getProfile() {
		return this.profile;
	}

	/**
	 * Carga el perfil con el que participa el usuario dentro del sistema.
	 * 
	 * @param profile
	 *            El perfil con el que participa el usuario dentro del sistema.
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * Permite saber si un un usuario tiene la participación habilitada dentro de un sistema.
	 * 
	 * @return <i>true</i> en caso de que el usuario tenga la participación habilitada dentro del sistema, en caso contrario retorna <i>false</i>.
	 */
	@Column(name = "ENABLED", columnDefinition = "bool", nullable = false)
	public Boolean isEnabled() {
		return this.enabled;
	}

	/**
	 * Carga el estado en el que se encuentra la participación de un usuario dentro de un sistema.
	 * 
	 * @param enabled
	 *            El valor que indica el estado que va a tener la participación de un usuario dentro del sistema.
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Retorna el conjunto de sesiones que creo el usuario dentro del sistema.
	 * 
	 * @return El conjunto de sesiones que creo el usuario dentro del sistema.
	 */
	@OneToMany(mappedBy = Session.Attributes.PARTICIPATION, targetEntity = Participation.class, orphanRemoval = true)
	public Set<Session> getSessions() {
		return this.sessions;
	}

	/**
	 * Permite cargar el listado de las sesiones que tiene un usuario dentro del sistema.
	 * 
	 * @param sessions
	 *            El conjunto de sesiones que tiene el usuario dentro del sistema.
	 */
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	/**
	 * Permite agregar una nueva sesión en la participación.
	 * 
	 * @param session
	 *            La nueva sesión a agregar.
	 */
	public void addSession(Session session) {
		this.getSessions().add(session);
		session.setParticipation(this);
	}

	/**
	 * Permite quitar la sesión de la participación.
	 * 
	 * @param session
	 *            La sesión que queremos quitar de la participación.
	 */
	public void removeSession(Session session) {
		this.getSessions().remove(session);
		session.setParticipation(null);
	}
}