package com.common.security.domain.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.util.domain.model.Entity;

/**
 * Representa una tarea dentro del sistema.
 * 
 * @since 11/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_TASKS")
@javax.persistence.Entity(name = "Task")
public class Task extends Entity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Entity.Attributes
	 */
	public interface Attributes extends Entity.Attributes {
		public static final String NAME = "name";
		public static final String DESCRIPTION = "description";
	}

	/**
	 * El nombre de la tarea.
	 */
	private String name;
	/**
	 * La descripción de lo que realiza la tarea.
	 */
	private String description;

	/**
	 * El constructor de una tarea.
	 */
	public Task() {
		super();
	}

	@Id
	@Column(name = "ID_SECURITY_TASK", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Retorna el nombre de la tarea.
	 * 
	 * @return El nombre de la tarea.
	 */
	@Column(name = "NAME", columnDefinition = "varchar(255)", length = 255, nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * Permite cargarle el nombre a la tarea.
	 * 
	 * @param name
	 *            El nombre de la tarea.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Retorna la descripción de la tarea.
	 * 
	 * @return La descripción de la tarea.
	 */
	@Column(name = "DESCRIPTION", columnDefinition = "text", nullable = false)
	public String getDescription() {
		return description;
	}

	/**
	 * Permite cargarle la descripción a la tarea.
	 * 
	 * @param description
	 *            La descripción de la tarea.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}