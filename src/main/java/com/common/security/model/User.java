package com.common.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.security.util.Encoder;
import com.common.security.util.EncoderType;
import com.common.util.tool.VerifierUtil;

/**
 * Clase que representa un usuario global del sistema.
 * 
 * @since 10/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_USERS")
@Entity(name = "User")
public class User extends Temporal<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Entity.Attributes
	 */
	public interface Attributes extends Temporal.Attributes {
		public static final String USERNAME = "username";
		public static final String ENCODE_TYPE = "encoderType";
		public static final String ENCODE_PASSWORD = "encodedPassword";
	}

	/**
	 * El nombre de usuario del usuario.
	 */
	private String username;
	/**
	 * El tipo de codificador de la password.
	 */
	private EncoderType encoderType;
	/**
	 * La password del usuario, esta ya se encuentra codificada.
	 */
	private String encodedPassword;

	/**
	 * El constructor de un usuario.
	 */
	public User() {
		super();
	}

	@Override
	public String toString() {
		return this.getUsername();
	}

	@Id
	@Column(name = "ID_SECURITY_USER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return super.getId();
	}

	/**
	 * Retorna el nombre del usuario.
	 * 
	 * @return El nombre del usuario.
	 */
	@Column(name = "USERNAME", length = 256, nullable = false, unique = true)
	public String getUsername() {
		return username;
	}

	/**
	 * Carga el nombre del usuario.
	 * 
	 * @param username
	 *            El nombre del usuario.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Retorna el tipo de codificación que estamos usando para la password.
	 * 
	 * @return El tipo de codificación que estamos usando para la password.
	 */
	@Column(name = "ENCODE", length = 16, nullable = false, unique = true)
	public EncoderType getEncoderType() {
		return encoderType;
	}

	/**
	 * Carga el tipo de codificación que estamos usando para la password.
	 * 
	 * @param encoderType
	 *            El tipo de codificación que estamos usando para la password.
	 */
	public void setEncoderType(EncoderType encoderType) {
		this.encoderType = encoderType;
	}

	/**
	 * Retorna la password ya codificada en MD5.
	 * 
	 * @return La password ya codificada en MD5.
	 */
	@Column(name = "PASSWORD", length = 256, nullable = false, unique = true)
	public String getEncodedPassword() {
		return encodedPassword;
	}

	/**
	 * Carga la password ya codificada en MD5.
	 * 
	 * @param encodedPassword
	 *            La password ya codificada en MD5.
	 */
	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

	/**
	 * Permite verificar si una password dada (sin codificarse) es igual a la password que tenemos almacenada en el usuario.
	 * 
	 * @param password
	 *            La password que queremos verificar si es la misma que la que tenemos actualmente en este usuario.
	 * @return <i>true</i> en caso de que la password recibida es igual a la almacenada dentro del usuario, en caso contrario retornamos <i>false</i>.
	 */
	public boolean samePassword(String password) {
		return VerifierUtil.<String> equals(this.encodedPassword, Encoder.encode(password, this.encoderType));
	}

	/**
	 * Carga la password no codificada.
	 * 
	 * @param password
	 *            La password no codificada.
	 */
	public void setPassword(String password) {
		this.encodedPassword = Encoder.encode(password, this.encoderType);
	}
}