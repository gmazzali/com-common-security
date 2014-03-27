package com.common.security.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.common.security.business.util.Encoder;
import com.common.security.business.util.EncoderType;
import com.common.util.business.tool.VerifierUtil;
import com.common.util.business.tool.date.DatePrecision;
import com.common.util.business.tool.date.DateUtil;

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
		public static final String USER_DATA = "userData";
		public static final String CHANGE_PASSWORD_HISTORIES = "changePasswordHistories";
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
	 * Los datos extras del usuario.
	 */
	private UserData userData;
	/**
	 * El historial de cambios de password.
	 */
	private List<ChangePasswordHistory> changePasswordHistories;
	/**
	 * El historial de dehabilitaciones.
	 */
	private List<Disablement> disablements;

	/**
	 * El constructor de un usuario.
	 */
	public User() {
		super();
		this.changePasswordHistories = new ArrayList<ChangePasswordHistory>();
		this.disablements = new ArrayList<Disablement>();
	}

	@Override
	public String toString() {
		return this.getUsername();
	}

	@Id
	@Column(name = "ID_SECURITY_USER", columnDefinition = "integer")
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
	@Column(name = "USERNAME", columnDefinition = "text", nullable = false, unique = true)
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
	@Column(name = "ENCODE", columnDefinition = "varchar", length = 10, nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
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
	@Column(name = "PASSWORD", columnDefinition = "text", nullable = false, unique = true)
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

	/**
	 * Retorna los datos extras que tenemos del usuario.
	 * 
	 * @return Los datos extras que tenemos del usuario.
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_USER", referencedColumnName = "ID_SECURITY_USER", nullable = false)
	public UserData getUserData() {
		return userData;
	}

	/**
	 * Carga los datos extras que tenemos del usuario.
	 * 
	 * @param userData
	 *            Los datos extras que tenemos del usuario.
	 */
	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	/**
	 * Retorna el historial de los cambios de password que realizo el usuario.
	 * 
	 * @return El historial de los cambios de password que realizo el usuario.
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", targetEntity = ChangePasswordHistory.class, orphanRemoval = true)
	public List<ChangePasswordHistory> getChangePasswordHistories() {
		return changePasswordHistories;
	}

	/**
	 * Carga el historial de los cambios de password que realizo el usuario.
	 * 
	 * @param changePasswordHistories
	 *            El historial de los cambios de password que realizo el usuario.
	 */
	public void setChangePasswordHistories(List<ChangePasswordHistory> changePasswordHistories) {
		this.changePasswordHistories = changePasswordHistories;
	}

	/**
	 * Permite cargar una entrada en el historial de cambios de password del usuario.
	 * 
	 * @param changePasswordHistory
	 *            La entrada que vamos a guardar para este usuario.
	 */
	public void addChangePasswordHistory(ChangePasswordHistory changePasswordHistory) {
		changePasswordHistory.setUser(this);
		this.changePasswordHistories.add(changePasswordHistory);
	}

	/**
	 * Permite quitar una entrada en el historial de cambios de password del usuario.
	 * 
	 * @param changePasswordHistory
	 *            La entrada que vamos a quitar de este usuario.
	 */
	public void removeChangePasswordHistory(ChangePasswordHistory changePasswordHistory) {
		changePasswordHistory.setUser(null);
		this.changePasswordHistories.remove(changePasswordHistory);
	}

	/**
	 * Permite cargar un conjunto de entradas en el historial de cambios de password del usuario.
	 * 
	 * @param changePasswordHistories
	 *            El conjunto de entradas que vamos a guardar para este usuario.
	 */
	public void addAllChangePasswordHistories(List<ChangePasswordHistory> changePasswordHistories) {
		for (ChangePasswordHistory changePasswordHistory : changePasswordHistories) {
			this.addChangePasswordHistory(changePasswordHistory);
		}
	}

	/**
	 * Permite quitar un conjunto de entradas en el historial de cambios de password del usuario.
	 * 
	 * @param changePasswordHistories
	 *            El conjunto de entradas que vamos a quitar de este usuario.
	 */
	public void removeAllChangePasswordHistories(List<ChangePasswordHistory> changePasswordHistories) {
		for (ChangePasswordHistory changePasswordHistory : changePasswordHistories) {
			this.removeChangePasswordHistory(changePasswordHistory);
		}
	}

	/**
	 * Retorna el historial de las deshabilitaciones del usuario.
	 * 
	 * @return El historial de las deshabilitaciones del usuario.
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", targetEntity = Disablement.class, orphanRemoval = true)
	public List<Disablement> getDisablements() {
		return disablements;
	}

	/**
	 * Carga el historial de las deshabilitaciones del usuario.
	 * 
	 * @param changePasswordHistories
	 *            El historial de las deshabilitaciones del usuario.
	 */
	public void setDisablements(List<Disablement> disablements) {
		this.disablements = disablements;
	}

	/**
	 * Permite cargar una entrada en el historial de las deshabilitaciones del usuario.
	 * 
	 * @param disablement
	 *            La entrada que vamos a guardar para este usuario.
	 */
	public void addDisablement(Disablement disablement) {
		disablement.setUser(this);
		this.disablements.add(disablement);
	}

	/**
	 * Permite quitar una entrada en el historial de las deshabilitaciones del usuario.
	 * 
	 * @param disablement
	 *            La entrada que vamos a quitar de este usuario.
	 */
	public void removeDisablement(Disablement disablement) {
		disablement.setUser(null);
		this.disablements.remove(disablement);
	}

	/**
	 * Permite cargar un conjunto de entradas en el historial de las deshabilitaciones del usuario.
	 * 
	 * @param disablements
	 *            El conjunto de entradas que vamos a guardar para este usuario.
	 */
	public void addAllDisablements(List<Disablement> disablements) {
		for (Disablement disablement : disablements) {
			this.addDisablement(disablement);
		}
	}

	/**
	 * Permite quitar un conjunto de entradas en el historial de las deshabilitaciones del usuario.
	 * 
	 * @param disablements
	 *            El conjunto de entradas que vamos a quitar de este usuario.
	 */
	public void removeAllDisablements(List<Disablement> disablements) {
		for (Disablement disablement : disablements) {
			this.removeDisablement(disablement);
		}
	}

	/**
	 * Permite saber si un usuario se encuentra deshabilitado dentro del sistema.
	 * 
	 * @return <i>true</i> en caso de que el usuario actualmente se encuentre deshabilitado, en caso contrario, retorna <i>false</i>.
	 */
	@Transient
	public Boolean isDisabledUser() {
		Date today = new Date();
		for (Disablement disablement : this.disablements) {
			if (DateUtil.between(today, disablement.getValidFrom(), disablement.getValidTo(), DatePrecision.MILLISECOND)) {
				return true;
			}
		}
		return false;
	}
}