package com.common.security.domain.app;

/**
 * La interfaz que define el comportamiento principal de la aplicación para el control de la seguridad del mismo.
 * 
 * @since 09/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface SecurityExecuteApp {

	/**
	 * Permite inicializar todos los componentes de seguridad para arrancar la aplicación.
	 */
	public void preExecuteApp();

	/**
	 * Permite correr el proceso principal de la aplicación.
	 */
	public void executeApp();

	/**
	 * Permite finalizar todos los componentes de seguridad una vez finalizada la aplicación.
	 */
	public void postExecuteApp();
}