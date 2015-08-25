package com.common.security.domain.model;

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
import javax.persistence.TemporalType;

import com.common.util.domain.model.entity.Entity;

/**
 * Representa el LOG de una acci�n de un usuario dentro de una sesi�n dentro del sistema.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_LOGS")
@javax.persistence.Entity(name = "Log")
public class Log extends Entity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Entity.Attributes
	 */
	public interface Attributes extends Entity.Attributes {
		public static final String SESSION = "session";
		public static final String TASK = "task";
		public static final String DESCRIPTION = "description";
		public static final String DATE = "date";
	}

	/**
	 * La sesi�n donde se ejecuto la tarea.
	 */
	private Session session;
	/**
	 * La tarea que corresponde con este LOG.
	 */
	private Task task;
	/**
	 * La descripci�n del LOG.
	 */
	private String description;
	/**
	 * La fecha cuando se produjo el LOG.
	 */
	private Date date;

	/**
	 * El constructor de un LOG.
	 */
	public Log() {
		super();
	}

	@Override
	public String toString() {
		return this.description;
	}

	@Id
	@Column(name = "ID_SECURITY_LOG", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Permite recuperar la sesi�n que corresponde al LOG.
	 * 
	 * @return La sesi�n que corresponde con el LOG.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_SESSION", referencedColumnName = "ID_SECURITY_SESSION", nullable = false)
	public Session getSession() {
		return session;
	}

	/**
	 * Carga la sesi�n que corresponde al LOG.
	 * 
	 * @param session
	 *            La sesi�n que corresponde con el LOG.
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * Permite recuperar la tarea que corresponde al LOG.
	 * 
	 * @return La tarea que corresponde con el LOG.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_TASK", referencedColumnName = "ID_SECURITY_TASK", nullable = false)
	public Task getTask() {
		return task;
	}

	/**
	 * Carga la tarea que corresponde al LOG.
	 * 
	 * @param task
	 *            La tarea que corresponde con el LOG.
	 */
	public void setTask(Task task) {
		this.task = task;
	}

	/**
	 * Permite recuperar la descripci�n que corresponde al LOG.
	 * 
	 * @return La descripci�n que corresponde con el LOG.
	 */
	@Column(name = "DESCRIPTION", columnDefinition = "text", nullable = false)
	public String getDescription() {
		return description;
	}

	/**
	 * Carga la descripci�n que corresponde al LOG.
	 * 
	 * @param description
	 *            La descripci�n que corresponde con el LOG.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Permite fecha la descripci�n que corresponde al LOG.
	 * 
	 * @return La fecha que corresponde con el LOG.
	 */
	@Column(name = "LOG_DATE", columnDefinition = "timestamp", nullable = false)
	@javax.persistence.Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}

	/**
	 * Carga la fecha que corresponde al LOG.
	 * 
	 * @param date
	 *            La fecha que corresponde con el LOG.
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}