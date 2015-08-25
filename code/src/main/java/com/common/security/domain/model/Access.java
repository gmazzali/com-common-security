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

import com.common.security.domain.util.Constants;
import com.common.util.domain.model.entity.Entity;

/**
 * La clase que representa un acceso a un recurso mediante una acción.
 * 
 * @since 08/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_ACCESSES")
@javax.persistence.Entity(name = "Access")
public class Access extends Entity<Long> implements Comparable<Access> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Entity.Attributes
	 */
	public interface Attributes extends Entity.Attributes {
		public static final String RESOURCE = "resource";
		public static final String ACTION = "action";
	}

	/**
	 * El recurso al que queremos acceder.
	 */
	private Resource resource;
	/**
	 * La acción que estamos realizando para acceder.
	 */
	private Action action;

	/**
	 * El constructor de un acceso.
	 */
	public Access() {
		super();
	}

	@Override
	public int compareTo(Access access) {
		if (access != null) {
			return access.toString().compareTo(this.toString());
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.action != null ? this.action.getDescription() : "null");
		buffer.append(Constants.SEPARATOR);
		buffer.append(this.resource != null ? this.resource.getDescription() : "null");
		return buffer.toString();
	}

	@Id
	@Column(name = "ID_SECURITY_ACCESS", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Retorna el recurso de este acceso.
	 * 
	 * @return El recurso de este acceso.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_RESOURCE", referencedColumnName = "ID_SECURITY_RESOURCE", nullable = false)
	public Resource getResource() {
		return resource;
	}

	/**
	 * Permite cargar el recurso que corresponde a este acceso.
	 * 
	 * @param resource
	 *            El recurso de este acceso.
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/**
	 * Retorna el recurso de este acceso.
	 * 
	 * @return El recurso de este acceso.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_ACTION", referencedColumnName = "ID_SECURITY_ACTION", nullable = false)
	public Action getAction() {
		return action;
	}

	/**
	 * Permite cargar la acción que corresponde a este acceso.
	 * 
	 * @param action
	 *            La acción de este acceso.
	 */
	public void setAction(Action action) {
		this.action = action;
	}
}