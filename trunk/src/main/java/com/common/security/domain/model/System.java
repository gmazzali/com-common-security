package com.common.security.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.common.util.domain.model.Entity;

/**
 * Abstracción que representa un Sistema o Aplicativo (desde el punto de vista de la seguridad).
 * 
 * @since 10/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_SYSTEMS")
@javax.persistence.Entity(name = "System")
public class System extends Entity<Long> {
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
	 * El constructor de un sistema.
	 */
	public System() {
		super();
		this.profiles = new HashSet<Profile>();
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Id
	@Column(name = "ID_SECURITY_SYSTEM", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return super.getId();
	}

	/**
	 * Retorna el nombre del sistema.
	 * 
	 * @return El nombre del sistema.
	 */
	@Column(name = "NAME", columnDefinition = "text", nullable = false, unique = true)
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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = Profile.Attributes.SYSTEM, targetEntity = Disablement.class, orphanRemoval = true)
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
}