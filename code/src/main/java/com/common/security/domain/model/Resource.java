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
@Table(name = "SECURITY_RESOURCES")
@javax.persistence.Entity(name = "Resource")
public class Resource extends Entity<Long> {
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
	 * El sistema al que pertenece el recurso.
	 */
	private System system;
	/**
	 * El nombre del recurso.
	 */
	private String name;
	/**
	 * La descripción del recurso.
	 */
	private String description;

	/**
	 * El constructor de un recurso.
	 */
	public Resource() {
		super();
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Id
	@Column(name = "ID_SECURITY_RESOURCE", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Retorna el sistema al que pertenece este recurso.
	 * 
	 * @return El sistema al que pertenece este recurso.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_SYSTEM", referencedColumnName = "ID_SECURITY_SYSTEM", nullable = false)
	public System getSystem() {
		return system;
	}

	/**
	 * Permite cargar el sistema de este recurso.
	 * 
	 * @param system
	 *            El sistema de este recurso.
	 */
	public void setSystem(System system) {
		this.system = system;
	}

	/**
	 * Retorna el nombre de este recurso.
	 * 
	 * @return El nombre de este recurso.
	 */
	@Column(name = "NAME", columnDefinition = "varchar(255)", length = 255, nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * Permite cargar el nombre de este recurso.
	 * 
	 * @param name
	 *            El nombre de este recurso.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna la descripción de este recurso.
	 * 
	 * @return La descripción de este recurso.
	 */
	@Column(name = "DESCRIPTION", columnDefinition = "text", nullable = false)
	public String getDescription() {
		return description;
	}

	/**
	 * Permite cargar la descripción de este recurso.
	 * 
	 * @param description
	 *            La descripción de este recurso.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}