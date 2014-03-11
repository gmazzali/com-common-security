package com.common.security.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.common.util.tool.FormatUtil;

/**
 * Representa si un usuario fue deshabilitado.
 * 
 * @since 11/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_DISABLEMENTS")
@Entity(name = "Disablement")
public class Disablement extends Temporal<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Entity.Attributes
	 */
	public interface Attributes extends Temporal.Attributes {
		public static final String MOTIVE = "motive";
		public static final String USER = "user";
	}

	/**
	 * El motivo por el que se deshabilito.
	 */
	private String motive;
	/**
	 * El usuario de la deshabilitación.
	 */
	private User user;

	/**
	 * El constructor de una deshabilitación.
	 */
	public Disablement() {
		super();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		buffer.append(FormatUtil.formatDate(this.validFrom));
		buffer.append("-");
		buffer.append(FormatUtil.formatDate(this.validTo));
		buffer.append("] ");
		buffer.append(this.motive);
		return buffer.toString();
	}

	@Id
	@Column(name = "ID_SECURITY_DISABLEMENT", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return super.getId();
	}

	/**
	 * Retorna el usuario de estos datos.
	 * 
	 * @return El usuario de estos datos.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_USER", referencedColumnName = "ID_SECURITY_USER", nullable = false)
	public User getUser() {
		return user;
	}

	/**
	 * Carga el usuario de estos datos.
	 * 
	 * @param user
	 *            El usuario de estos datos.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Retorna el motivo por que que se deshabilito el usuario.
	 * 
	 * @return El motivo por que que se deshabilito el usuario.
	 */
	@Column(name = "MOTIVE", columnDefinition = "text", nullable = false)
	public String getMotive() {
		return motive;
	}

	/**
	 * Carga el motivo por que que se deshabilito el usuario.
	 * 
	 * @param motive
	 *            El motivo por que que se deshabilito el usuario.
	 */
	public void setMotive(String motive) {
		this.motive = motive;
	}
}