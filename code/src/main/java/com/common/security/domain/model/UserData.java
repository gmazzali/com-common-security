package com.common.security.domain.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.common.util.domain.model.Entity;

/**
 * Representa los datos extras de un usuario.
 * 
 * @since 10/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_USER_DATA")
@javax.persistence.Entity(name = "UserData")
public class UserData extends Entity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Entity.Attributes
	 */
	public interface Attributes extends Entity.Attributes {
		public static final String USER = "user";
		public static final String NAME = "name";
		public static final String SURNAME = "surname";
		public static final String BIRTHDAY = "birthday";
		public static final String ADDRESS = "address";
		public static final String TELPHONE = "telephone";
		public static final String EMAIL = "email";
		public static final String PASSWORD_EXPIRATION_CHECKED = "passwordExpirationChecked";
		public static final String PASSWORD_EXPIRATION_DAYS = "daysToExpirePassword";
	}

	/**
	 * El usuario.
	 */
	private User user;
	/**
	 * El nombre del usuario.
	 */
	private String name;
	/**
	 * El apellido del usuario.
	 */
	private String surname;
	/**
	 * La fecha de nacimiento del usuario.
	 */
	private Date birthday;
	/**
	 * La dirección del usuario.
	 */
	private String address;
	/**
	 * El teléfono del usuario.
	 */
	private String telephone;
	/**
	 * El email del usuario.
	 */
	private String email;
	/**
	 * El valor booleano que indica si el password del usuario va expirar.
	 */
	private Boolean passwordExpirationChecked;
	/**
	 * La cantidad de dias que vamos a tener la password válida del usuario.
	 */
	private Integer passwordExpirationDays;

	/**
	 * El constructor de los datos extras de un usuario.
	 */
	public UserData() {
		super();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.surname);
		buffer.append(", ");
		buffer.append(this.name);
		return buffer.toString();
	}

	@Id
	@Column(name = "ID_SECURITY_USER_DATA", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Retorna el usuario de estos datos.
	 * 
	 * @return El usuario de estos datos.
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_USER", referencedColumnName = "ID_SECURITY_USER", nullable = false)
	public User getUser() {
		return this.user;
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
	 * Retorna el nombre real del usuario.
	 * 
	 * @return El nombre real del usuario.
	 */
	@Column(name = "NAME", columnDefinition = "varchar", length = 255, nullable = false)
	public String getName() {
		return this.name;
	}

	/**
	 * Carga el nombre real del usuario.
	 * 
	 * @param name
	 *            El nombre real del usuario.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna el apellido real del usuario.
	 * 
	 * @return El apellido real del usuario.
	 */
	@Column(name = "SURNAME", columnDefinition = "varchar", length = 255, nullable = false)
	public String getSurname() {
		return this.surname;
	}

	/**
	 * Carga el apellido real del usuario.
	 * 
	 * @param surname
	 *            El apellido real del usuario.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Retorna la fecha de nacimiento del usuario.
	 * 
	 * @return La fecha de nacimiento del usuario.
	 */
	@Column(name = "BIRTHDAY", columnDefinition = "timestamp")
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return this.birthday;
	}

	/**
	 * Carga la fecha de nacimiento del usuario.
	 * 
	 * @param birthday
	 *            La fecha de nacimiento del usuario.
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * Retorna la dirección del usuario.
	 * 
	 * @return La dirección del usuario.
	 */
	@Column(name = "ADDRESS", columnDefinition = "text", nullable = false)
	public String getAddress() {
		return this.address;
	}

	/**
	 * Carga la dirección del usuario.
	 * 
	 * @param address
	 *            La dirección del usuario.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Retorna el teléfono del usuario.
	 * 
	 * @return El teléfono del usuario.
	 */
	@Column(name = "TELEPHONE", columnDefinition = "varchar", length = 100, nullable = false)
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Carga el teléfono del usuario.
	 * 
	 * @param telephone
	 *            El teléfono del usuario.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Retorna el email del usuario.
	 * 
	 * @return El email del usuario.
	 */
	@Column(name = "EMAIL", columnDefinition = "varchar", length = 255, nullable = false)
	public String getEmail() {
		return this.email;
	}

	/**
	 * Carga el email del usuario.
	 * 
	 * @param email
	 *            El email del usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna el valor booleano que nos indica si vamos a verificar si la password de un usuario expira.
	 * 
	 * @return El valor booleano que nos indica si vamos a verificar si la password de un usuario expira.
	 */
	@Column(name = "PASSWORD_EXPIRATION_CHECKED", columnDefinition = "boolean", nullable = false)
	public Boolean getPasswordExpirationChecked() {
		return this.passwordExpirationChecked;
	}

	/**
	 * Carga el valor booleano que nos indica si vamos a verificar si la password de un usuario expira.
	 * 
	 * @param passwordExpirationChecked
	 *            El valor booleano que nos indica si vamos a verificar si la password de un usuario expira.
	 */
	public void setPasswordExpirationChecked(Boolean passwordExpirationChecked) {
		this.passwordExpirationChecked = passwordExpirationChecked;
	}

	/**
	 * Retorna la cantidad de días que vamos a dejar que una password sea válida desde la última vez que se cambio.
	 * 
	 * @return La cantidad de días que vamos a dejar que una password sea válida desde la última vez que se cambio.
	 */
	@Column(name = "PASSWORD_EXPIRATION_DAYS", columnDefinition = "integer", nullable = true)
	public Integer getPasswordExpirationDays() {
		return this.passwordExpirationDays;
	}

	/**
	 * Carga la cantidad de días que vamos a dejar que una password sea válida desde la última vez que se cambio.
	 * 
	 * @param passwordExpirationDays
	 *            La cantidad de días que vamos a dejar que una password sea válida desde la última vez que se cambio.
	 */
	public void setPasswordExpirationDays(Integer passwordExpirationDays) {
		this.passwordExpirationDays = passwordExpirationDays;
	}
}