package com.common.security.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa una tarea dentro del sistema.
 * 
 * @since 11/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_PROFILES")
@Entity(name = "Profile")
public class Profile extends Temporal<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Temporal.Attributes
	 */
	public interface Attributes extends Temporal.Attributes {
		public static final String SYSTEM = "system";
		public static final String ABBREVIATION = "abbreviation";
		public static final String NAME = "name";
		public static final String ROLES = "roles";
	}

	/**
	 * El sistema al que pertenece el perfil.
	 */
	private System system;
	/**
	 * La abreviación del nombre del perfil.
	 */
	private String abbreviation;
	/**
	 * El nombre del perfil.
	 */
	private String name;
	/**
	 * Los roles de este perfil.
	 */
	private Set<Role> roles;

	/**
	 * El constructor de un perfil.
	 */
	public Profile() {
		super();
		this.roles = new HashSet<Role>();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toString());
		buffer.append(" ");
		buffer.append(this.name);
		return buffer.toString();
	}

	@Id
	@Column(name = "ID_SECURITY_PROFILE", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return super.getId();
	}

	/**
	 * Retorna el sistema al que pertenece este perfil.
	 * 
	 * @return El sistema al que pertenece este perfil.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_SYSTEM", referencedColumnName = "ID_SECURITY_SYSTEM", nullable = false)
	public System getSystem() {
		return system;
	}

	/**
	 * Permite cargar el sistema al que pertenece este perfil.
	 * 
	 * @param system
	 *            El sistema al que va a pertenecer este perfil.
	 */
	public void setSystem(System system) {
		this.system = system;
	}

	/**
	 * Retorna la abreviación que usamos para este perfil.
	 * 
	 * @return La abreviación de este perfil.
	 */
	@Column(name = "ABBREVIATION", columnDefinition = "varchar(50)", length = 50, nullable = false)
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * Carga la abreviación que usamos para este perfil.
	 * 
	 * @param abbreviation
	 *            La abreviación que usamos para este perfil.
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * Retorna el nombre que usamos para este perfil.
	 * 
	 * @return El nombre de este perfil.
	 */
	@Column(name = "NAME", columnDefinition = "varchar(255)", length = 255, nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * Carga el nombre que usamos para este perfil.
	 * 
	 * @param name
	 *            El nombre que usamos para este perfil.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Permite recuperar el listado de roles que tenemos asignados a este perfil.
	 * 
	 * @return El conjunto de roles de este perfil.
	 */
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "SECURITY_ROLES_IN_PROFILES", joinColumns = { @JoinColumn(name = "ID_SECURITY_PROFILE") }, inverseJoinColumns = { @JoinColumn(name = "ID_SECURITY_ROLE") })
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Permite cargar el listado de roles a este perfil.
	 * 
	 * @param roles
	 *            El listado de roles a cargar dentro de este perfil.
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * Permite agregar un nuevo rol dentro de este perfil.
	 * 
	 * @param role
	 *            El nuevo rol a agregar dentro de este perfil.
	 */
	public void addRole(Role role) {
		if (role != null) {
			this.getRoles().add(role);
		}
	}

	/**
	 * Permite quitar un rol desde este perfil.
	 * 
	 * @param role
	 *            El rol a quitar desde este perfil.
	 */
	public void removeRole(Role role) {
		if (this.getRoles().contains(role)) {
			this.getRoles().remove(role);
		}
	}
}