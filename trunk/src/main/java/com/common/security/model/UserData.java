package com.common.security.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.common.util.model.Entity;

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
		buffer.append(this.name);
		buffer.append(", ");
		buffer.append(this.surname);
		return buffer.toString();
	}

	@Id
	@Column(name = "ID_SECURITY_USER_DATA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return super.getId();
	}

	/**
	 * Retorna el usuario.
	 * 
	 * @return El usuario.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_USER", referencedColumnName = "ID_SECURITY_USER", nullable = false)
	public User getUser() {
		return user;
	}

	/**
	 * Carga el usuario.
	 * 
	 * @param user
	 *            El usuario.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Retorna el nombre real del usuario.
	 * 
	 * @return El nombre real del usuario.
	 */
	@Column(name = "NAME", length = 256, nullable = false, unique = true)
	public String getName() {
		return name;
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
	@Column(name = "SURNAME", length = 256, nullable = false, unique = true)
	public String getSurname() {
		return surname;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getPasswordExpirationChecked() {
		return passwordExpirationChecked;
	}

	public void setPasswordExpirationChecked(Boolean passwordExpirationChecked) {
		this.passwordExpirationChecked = passwordExpirationChecked;
	}

	public Integer getPasswordExpirationDays() {
		return passwordExpirationDays;
	}

	public void setPasswordExpirationDays(Integer passwordExpirationDays) {
		this.passwordExpirationDays = passwordExpirationDays;
	}
}