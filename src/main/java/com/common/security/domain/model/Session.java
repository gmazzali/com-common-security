package com.common.security.domain.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import com.common.util.domain.model.Entity;

/**
 * Representa una sesi�n dentro del sistema.
 * 
 * @since 10/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_SESSIONS")
@javax.persistence.Entity(name = "Session")
public class Session extends Entity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Entity.Attributes
	 */
	public interface Attributes extends Entity.Attributes {
		public static final String PARTICIPATION = "participation";
		public static final String INIT_DATE = "initDate";
		public static final String END_DATE = "endDate";
		public static final String END_MOTIVE = "sessionEndMotive";
		public static final String OBSERVATIONS = "observations";
		public static final String LOGS = "logs";
	}

	/**
	 * La participaci�n a la que corresponde esta sesi�n.
	 */
	private Participation participation;
	/**
	 * La fecha y hora de inicio de esta sesi�n.
	 */
	private Date initDate;
	/**
	 * La fecha y hora de finalizaci�n de esta sesi�n.
	 */
	private Date endDate;
	/**
	 * El motivo por el que se cerro la sesi�n.
	 */
	private String endMotive;
	/**
	 * La observaci�n de la sesi�n.
	 */
	private String observation;
	/**
	 * El listado de los logs de la sesi�n.
	 */
	private Set<Log> logs;

	/**
	 * El constructor de una sesi�n por default.
	 */
	public Session() {
		super();
		this.initDate = new Date();
		this.logs = new HashSet<Log>();
	}

	/**
	 * El constructor que recibe una participaci�n.
	 * 
	 * @param participation
	 *            La participaci�n de esta sesi�n.
	 */
	public Session(Participation participation) {
		this();
		this.participation = participation;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		return buffer.toString();
	}

	@Id
	@Column(name = "ID_SECURITY_SESSION", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Retorna la participaci�n de la sesi�n.
	 * 
	 * @return La participaci�n de la sesi�n.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SECURITY_PARTICIPATION", referencedColumnName = "ID_SECURITY_PARTICIPATION", nullable = false)
	public Participation getParticipation() {
		return participation;
	}

	/**
	 * Permite cargar la participaci�n de la sesi�n.
	 * 
	 * @param participation
	 *            La participaci�n de la sesi�n.
	 */
	public void setParticipation(Participation participation) {
		this.participation = participation;
	}

	/**
	 * Retorna la fecha y hora de inicio de la sesi�n.
	 * 
	 * @return La fecha y hora de inicio de la sesi�n.
	 */
	@Column(name = "INIT_DATE", columnDefinition = "timestamp", nullable = false)
	@javax.persistence.Temporal(TemporalType.TIMESTAMP)
	public Date getInitDate() {
		return initDate;
	}

	/**
	 * Permite cargar la fecha y hora de inicio de la sesi�n.
	 * 
	 * @param initDate
	 *            La fecha y hora de inicio de la sesi�n.
	 */
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	/**
	 * Retorna la fecha y hora de finalizaci�n de la sesi�n.
	 * 
	 * @return La fecha y hora de finalizaci�n de la sesi�n.
	 */
	@Column(name = "END_DATE", columnDefinition = "timestamp", nullable = true)
	@javax.persistence.Temporal(TemporalType.TIMESTAMP)
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Permite cargar la fecha y hora de finalizaci�n de la sesi�n.
	 * 
	 * @param endDate
	 *            La fecha y hora de finalizaci�n de la sesi�n.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Retorna el motivo de finalizaci�n de la sesi�n.
	 * 
	 * @return El motivo de finalizaci�n de la sesi�n.
	 */
	@Column(name = "END_MOTIVE", columnDefinition = "varchar(255)", length = 255, nullable = true)
	public String getEndMotive() {
		return endMotive;
	}

	/**
	 * Permite cargar el motivo de finalizaci�n de la sesi�n.
	 * 
	 * @param endMotive
	 *            El motivo de finalizaci�n de la sesi�n.
	 */
	public void setEndMotive(String endMotive) {
		this.endMotive = endMotive;
	}

	/**
	 * Retorna la observaci�n de finalizaci�n de la sesi�n.
	 * 
	 * @return La observaci�n de finalizaci�n de la sesi�n.
	 */
	@Column(name = "OBSERVATION", columnDefinition = "text", nullable = true)
	public String getObservation() {
		return observation;
	}

	/**
	 * Permite cargar la observaci�n de finalizaci�n de la sesi�n.
	 * 
	 * @param observation
	 *            La observaci�n de finalizaci�n de la sesi�n.
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}

	/**
	 * Retorna el conjunto de logs que corresponde a esta sesi�n.
	 * 
	 * @return El conjunto de logs de esta sesi�n.
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = Log.Attributes.SESSION, targetEntity = Log.class, orphanRemoval = true)
	public Set<Log> getLogs() {
		return logs;
	}

	/**
	 * Permite cargar el conjunto de logs que corresponde a esta sesi�n.
	 * 
	 * @param logs
	 *            El conjunto de logs de esta sesi�n.
	 */
	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	/**
	 * Permite cargar un log dentro del conjunto de estos en la sesi�n.
	 * 
	 * @param log
	 *            El log que vamos a cargar dentro de esta sesi�n.
	 */
	public void addLog(Log log) {
		if (log != null) {
			this.getLogs().add(log);
			log.setSession(this);
		}
	}

	/**
	 * Permite quitar un log desde el conjunto de estos en la sesi�n.
	 * 
	 * @param log
	 *            El log que vamos a quitar desde esta sesi�n.
	 */
	public void removeLog(Log log) {
		if (this.getLogs().contains(log)) {
			this.getLogs().remove(log);
			log.setSession(null);
		}
	}
}