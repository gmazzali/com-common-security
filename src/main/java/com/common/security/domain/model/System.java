package com.common.security.domain.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	 * El constructor de un sistema.
	 */
	public System() {
		super();
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
}