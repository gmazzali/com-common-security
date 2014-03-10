package com.common.security.util;

/**
 * Los tiops de codificaciones que podemos tener dentro del sistema.
 * 
 * <ul>
 * <li>{@link EncoderType#MD2}</li>
 * <li>{@link EncoderType#MD5}</li>
 * <li>{@link EncoderType#SHA_1}</li>
 * <li>{@link EncoderType#SHA_256}</li>
 * <li>{@link EncoderType#SHA_384}</li>
 * <li>{@link EncoderType#SHA_512}</li>
 * </ul>
 * 
 * @since 10/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public enum EncoderType {

	MD2("MD2"), MD5("MD5"), SHA_1("SHA-1"), SHA_256("SHA-256"), SHA_384("SHA-384"), SHA_512("SHA-512");

	/**
	 * El nombre del codificador.
	 */
	private String name;

	/**
	 * El constructor de un tipo de codificador.
	 * 
	 * @param name
	 *            El nombre del codificador.
	 */
	private EncoderType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * Retorna el nombre del codificador.
	 * 
	 * @return El nombre del codificador.
	 */
	public String getName() {
		return name;
	}
}