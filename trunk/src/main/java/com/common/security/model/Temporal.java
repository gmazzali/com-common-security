package com.common.security.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.common.util.model.Entity;

/**
 * Representa una entidad temporal que posee un periodo de fechas acotado.
 * 
 * @since 10/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Temporal<I extends Serializable> extends Entity<I> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Entity.Attributes
	 */
	public interface Attributes extends Entity.Attributes {
		public static final String VALID_FROM = "validFrom";
		public static final String VALID_TO = "validTo";
	}

	/**
	 * La fecha desde la que es valida la entidad.
	 */
	private Date validFrom;
	/**
	 * La fecha hasta la que es valida la entidad.
	 */
	private Date validTo;

	/**
	 * Retorna la fecha desde la que es válida la entidad.
	 * 
	 * @return La feche desde la que es válida la entidad.
	 */
	@Column(name = "VALID_FROM", nullable = false)
	@javax.persistence.Temporal(TemporalType.TIMESTAMP)
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * Carga la fecha desde la que es válida la entidad.
	 * 
	 * @param validFrom
	 *            La fecha desde la que es válida la fecha.
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * Retorna la fecha hasta la que es válida la entidad.
	 * 
	 * @return La feche hasta la que es válida la entidad.
	 */
	@Column(name = "VALID_TO", nullable = true)
	@javax.persistence.Temporal(TemporalType.TIMESTAMP)
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * Carga la fecha hasta la que es válida la entidad.
	 * 
	 * @param validTo
	 *            La fecha hasta la que es válida la fecha.
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * Determina si la instancia actual esta vigente. Una instancia de Temporal esta vigente, cuando la fecha validFrom o validTo son nulos o el
	 * objeto date es mayor o igual a validFrom y menor o igual a validTo.
	 * 
	 * @param date
	 *            fecha sobre la cual se determina la validez.
	 * @return <i>true</i> si al entidad es vigente para la fecha recibida, en caso contrario retorna <i>false</i>.
	 */
	@Transient
	public boolean isValid(Date date) {
		boolean result = true;
		long datemilliseconds = date.getTime();

		if (this.getValidFrom() != null) {
			result = result && getValidFrom().getTime() <= datemilliseconds;
		}

		if (this.getValidTo() != null) {
			result = result && getValidTo().getTime() >= datemilliseconds;
		}

		return result;
	}

	/**
	 * Determina si la instancia actual esta vigente, tomando como fecha de referencia la fecha actual.
	 * 
	 * @return <i>true</i> si al entidad es vigente para la fecha actual, en caso contrario retorna <i>false</i>.
	 */
	@Transient
	public boolean isValid() {
		return this.isValid(new Date());
	}
}