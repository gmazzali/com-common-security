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
 * Representa un rol dentro del sistema.
 * 
 * @since 08/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_ROLES")
@Entity(name = "Role")
public class Role extends Temporal<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Temporal.Attributes
	 */
	public interface Attributes extends Temporal.Attributes {
		public static final String SYSTEM = "system";
		public static final String ABBREVIATION = "abbreviation";
		public static final String NAME = "name";
		public static final String ACCESSES = "accesses";
	}

	/**
	 * El sistema al que pertenece el rol.
	 */
	private System system;
	/**
	 * La abreviación del nombre del rol.
	 */
	private String abbreviation;
	/**
	 * El nombre del rol.
	 */
	private String name;
	/**
	 * El conjunto de accesos permitidos al rol.
	 */
	private Set<Access> accesses;

	/**
	 * El constructor de un rol.
	 */
	public Role() {
		super();
		this.accesses = new HashSet<Access>();
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
	@Column(name = "ID_SECURITY_ROLE", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return super.getId();
	}

	/**
	 * Retorna el sistema al que pertenece este rol.
	 * 
	 * @return El sistema al que pertenece este rol.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_SYSTEM", referencedColumnName = "ID_SECURITY_SYSTEM", nullable = false)
	public System getSystem() {
		return system;
	}

	/**
	 * Permite cargar el sistema al que pertenece este rol.
	 * 
	 * @param system
	 *            El sistema al que va a pertenecer este rol.
	 */
	public void setSystem(System system) {
		this.system = system;
	}

	/**
	 * Retorna la abreviación que usamos para este rol.
	 * 
	 * @return La abreviación de este rol.
	 */
	@Column(name = "ABBREVIATION", columnDefinition = "varchar(50)", length = 50, nullable = false)
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * Carga la abreviación que usamos para este rol.
	 * 
	 * @param abbreviation
	 *            La abreviación que usamos para este rol.
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * Retorna el nombre que usamos para este rol.
	 * 
	 * @return El nombre de este rol.
	 */
	@Column(name = "NAME", columnDefinition = "varchar(255)", length = 255, nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * Carga el nombre que usamos para este rol.
	 * 
	 * @param name
	 *            El nombre que usamos para este rol.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Permite recuperar el listado de accesos que tenemos asignados a este rol.
	 * 
	 * @return El conjunto de accesos de este rol.
	 */
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "SECURITY_ACCESSES_IN_ROLES", joinColumns = { @JoinColumn(name = "ID_SECURITY_ROLE") }, inverseJoinColumns = { @JoinColumn(name = "ID_SECURITY_ACCESS") })
	public Set<Access> getAccesses() {
		return accesses;
	}

	/**
	 * Permite cargar el listado de accesos a este rol.
	 * 
	 * @param accesses
	 *            El listado de accesos a cargar dentro de este rol.
	 */
	public void setAccesses(Set<Access> accesses) {
		this.accesses = accesses;
	}

	/**
	 * Permite agregar un nuevo acceso dentro de este rol.
	 * 
	 * @param access
	 *            El nuevo acceso a agregar dentro de este rol.
	 */
	public void addAccess(Access access) {
		if (access != null) {
			this.getAccesses().add(access);
		}
	}

	/**
	 * Permite quitar un acceso desde este rol.
	 * 
	 * @param access
	 *            El acceso a quitar desde este rol.
	 */
	public void removeAccess(Access access) {
		if (this.getAccesses().contains(access)) {
			this.getAccesses().remove(access);
		}
	}
}