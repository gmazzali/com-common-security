/**
 * 
 */
package com.common.security.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.common.util.domain.model.Entity;

/**
 * La clase que representa una acción dentro de la aplicación.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_ACTIONS")
@javax.persistence.Entity(name = "Action")
public class Action extends Entity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Entity.Attributes
	 */
	public interface Attributes extends Entity.Attributes {
		public static final String SYSTEM = "system";
		public static final String NAME = "name";
		public static final String DESCRIPTION = "description";
	}

	/**
	 * El sistema al que pertenece la acción.
	 */
	private System system;
	/**
	 * El nombre de la acción.
	 */
	private String name;
	/**
	 * La descripción de lo que realiza la acción.
	 */
	private String description;

	/**
	 * El constructor de una acción.
	 */
	public Action() {
		super();
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Id
	@Column(name = "ID_SECURITY_ACTION", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Retorna el sistema al que pertenece esta acción.
	 * 
	 * @return El sistema al que pertenece esta acción.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_SYSTEM", referencedColumnName = "ID_SECURITY_SYSTEM", nullable = false)
	public System getSystem() {
		return system;
	}

	/**
	 * Permite cargar el sistema de esta acción.
	 * 
	 * @param system
	 *            El sistema de esta acción.
	 */
	public void setSystem(System system) {
		this.system = system;
	}

	/**
	 * Retorna el nombre de esta acción.
	 * 
	 * @return El nombre de esta acción.
	 */
	@Column(name = "NAME", columnDefinition = "varchar(255)", length = 255, nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * Permite cargar el nombre de esta acción.
	 * 
	 * @param name
	 *            El nombre de esta acción.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna la descripción de esta acción.
	 * 
	 * @return La descripción de esta acción.
	 */
	@Column(name = "DESCRIPTION", columnDefinition = "text", nullable = false)
	public String getDescription() {
		return description;
	}

	/**
	 * Permite cargar la descripción de esta acción.
	 * 
	 * @param description
	 *            La descripción de esta acción.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}