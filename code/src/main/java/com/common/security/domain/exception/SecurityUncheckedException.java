package com.common.security.domain.exception;

import com.common.util.domain.exception.UncheckedException;
import com.common.util.domain.exception.error.ErrorDetail;
import com.common.util.domain.exception.error.Errors;

/**
 * Las excepciones no chequeadas que vamos a manejar dentro del framework de seguridad.
 * 
 * @since 27/02/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class SecurityUncheckedException extends UncheckedException {
	private static final long serialVersionUID = 1L;

	/**
	 * El constructor de una instancia de {@link SecurityUncheckedException} que no recibe parámetros.
	 */
	public SecurityUncheckedException() {
		super();
	}

	/**
	 * El constructor de una instancia de {@link SecurityUncheckedException} que recibe como parámetro un elemento {@link Throwable} para mantener el
	 * problema que produjo el lanzamiento de esta {@link SecurityUncheckedException}.
	 * 
	 * @param cause
	 *            La causa de un problema que vamos a contener dentro de esta excepción.
	 */
	public SecurityUncheckedException(Throwable cause) {
		super(cause);
	}

	/**
	 * El constructor de una instancia de {@link SecurityUncheckedException} que recibe como parámetro el conjunto de {@link Errors} que vamos a
	 * contener.
	 * 
	 * @param errors
	 *            El conjunto de errores que vamos a contener dentro de esta excepción.
	 */
	public SecurityUncheckedException(Errors errors) {
		super(errors);
	}

	/**
	 * El constructor de una instancia de {@link SecurityUncheckedException} que recibe como parámetro el {@link Throwable} para mantener el problema
	 * que produjo el lanzamiento de esta {@link SecurityUncheckedException} y un un mensaje de {@link ErrorDetail} que vamos a crear en el momento.
	 * 
	 * @param cause
	 *            La causa de un problema que vamos a contener dentro de esta excepción.
	 * @param defaultMessage
	 *            El mensaje por omisión del detalle del error.
	 * @param keyMessage
	 *            La clave del mensaje del detalle del error.
	 * @param parameters
	 *            Los parámetros que requerimos para el detalle del error.
	 */
	public SecurityUncheckedException(Throwable cause, String defaultMessage, String keyMessage, Object... parameters) {
		super(cause, defaultMessage, keyMessage, parameters);
	}

	/**
	 * El constructor de una instancia de {@link SecurityUncheckedException} que recibe como parámetro un mensaje de {@link ErrorDetail} que vamos a
	 * crear en el momento.
	 * 
	 * @param defaultMessage
	 *            El mensaje por omisión del detalle del error.
	 * @param keyMessage
	 *            La clave del mensaje del detalle del error.
	 * @param parameters
	 *            Los parámetros que requerimos para el detalle del error.
	 */
	public SecurityUncheckedException(String defaultMessage, String keyMessage, Object... parameters) {
		super(defaultMessage, keyMessage, parameters);
	}
}
