package com.common.security.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Abstracción que representa un Sistema o Aplicativo (desde el punto de vista de la seguridad).
 * 
 * @since 10/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_SYSTEMS")
@javax.persistence.Entity(name = "System")
public class System extends Temporal<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * El nombre del sistema.
	 */
	private String name;
	/**
	 * El listado de los perfiles del sistema.
	 */
	private Set<Profile> profiles;
	/**
	 * El listado de los recursos disponibles en el sistema.
	 */
	private Set<Resource> resources;
	/**
	 * El listado de las acciones disponibles en el sistema.
	 */
	private Set<Action> actions;

	/**
	 * El constructor de un sistema.
	 */
	public System() {
		super();
		this.profiles = new HashSet<Profile>();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toString()).append(" ").append(this.name);
		return buffer.toString();
	}

	@Id
	@Override
	@Column(name = "ID_SECURITY_SYSTEM", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/**
	 * Retorna el nombre del sistema.
	 * 
	 * @return El nombre del sistema.
	 */
	@Column(name = "NAME", columnDefinition = "varchar", length = 50, nullable = false, unique = true)
	public String getName() {
		return name;
	}

	/**
	 * Carga el nombre del sistema.
	 * 
	 * @param name
	 *            El nombre del sistema.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna el conjunto de perfiles del sistema.
	 * 
	 * @return El conjunto de perfiles del sistema.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Profile.Attributes.SYSTEM, targetEntity = Profile.class, orphanRemoval = true)
	public Set<Profile> getProfiles() {
		return profiles;
	}

	/**
	 * Carga el conjunto de perfiles del sistema.
	 * 
	 * @param profiles
	 *            El conjunto de perfiles del sistema.
	 */
	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

	/**
	 * Permite agregar un nuevo perfil al sistema.
	 * 
	 * @param profile
	 *            El nuevo perfil que vamos a agregar en el sistema.
	 */
	public void addProfile(Profile profile) {
		if (profile != null) {
			this.getProfiles().add(profile);
			profile.setSystem(this);
		}
	}

	/**
	 * Permite quitar un perfil al sistema.
	 * 
	 * @param profile
	 *            El perfil que vamos a quitar del sistema.
	 */
	public void removeProfile(Profile profile) {
		if (this.getProfiles().contains(profile)) {
			this.getProfiles().remove(profile);
			profile.setSystem(null);
		}
	}

	/**
	 * Retorna el conjunto de recursos del sistema.
	 * 
	 * @return El conjunto de recursos del sistema.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Resource.Attributes.SYSTEM, targetEntity = Resource.class, orphanRemoval = true)
	public Set<Resource> getResources() {
		return this.resources;
	}

	/**
	 * Carga el conjunto de recursos del sistema.
	 * 
	 * @param resources
	 *            El conjunto de recursos del sistema.
	 */
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	/**
	 * Permite agregar un nuevo recurso al sistema.
	 * 
	 * @param resource
	 *            El nuevo recurso que vamos a agregar en el sistema.
	 */
	public void addResource(Resource resource) {
		if (resource != null) {
			this.getResources().add(resource);
			resource.setSystem(this);
		}
	}

	/**
	 * Permite quitar un recurso al sistema.
	 * 
	 * @param resource
	 *            El recurso que vamos a quitar del sistema.
	 */
	public void removeResource(Resource resource) {
		if (this.getResources().contains(resource)) {
			this.getResources().remove(resource);
			resource.setSystem(null);
		}
	}

	/**
	 * Retorna el conjunto de acciones del sistema.
	 * 
	 * @return El conjunto de acciones del sistema.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Action.Attributes.SYSTEM, targetEntity = Action.class, orphanRemoval = true)
	public Set<Action> getActions() {
		return this.actions;
	}

	/**
	 * Carga el conjunto de acciones del sistema.
	 * 
	 * @param resources
	 *            El conjunto de acciones del sistema.
	 */
	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}

	/**
	 * Permite agregar una nueva acción al sistema.
	 * 
	 * @param resource
	 *            El nuevo acciones que vamos a agregar en el sistema.
	 */
	public void addAction(Action action) {
		if (action != null) {
			this.getActions().add(action);
			action.setSystem(this);
		}
	}

	/**
	 * Permite quitar una acción al sistema.
	 * 
	 * @param resource
	 *            La acción que vamos a quitar del sistema.
	 */
	public void removeAction(Action action) {
		if (this.getActions().contains(action)) {
			this.getActions().remove(action);
			action.setSystem(null);
		}
	}
}