package com.common.security.business.util;

import java.security.MessageDigest;

import com.common.security.domain.exception.SecurityUncheckedException;

/**
 * La clase de codificación de strings.
 * 
 * @since 10/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class Encoder {

	/***
	 * Encripta un string mediante un algoritmo. La salida es obtenida completamente en mayúscula.
	 * 
	 * @param string
	 *            El texto pasado para su codificación. En caso de que sea un valor <code>null</code>, se retorna <code>null</code>.
	 * @param encoderType
	 *            El algoritmo de encriptacion deseado. Puede ser: {@link EncoderType#MD2}, {@link EncoderType#MD5}, {@link EncoderType#SHA_1},
	 *            {@link EncoderType#SHA_256}, {@link EncoderType#SHA_384}, {@link EncoderType#SHA_512}. En caso de que sea un valor <code>null</code>
	 *            , se toma el valor {@link EncoderType#MD5}.
	 * @return El string encritado y convertido en mayúscula, o un valor <code>null</code> en caso de que el string recibido sea <code>null</code>.
	 */
	public static String encode(String string, EncoderType encoderType) {
		// Si el string es nulo, retornamos nulo.
		if (string == null) {
			return null;
		}

		// Si el encoder es nulo, tomamos MD5.
		if (encoderType == null) {
			encoderType = EncoderType.MD5;
		}

		try {
			// Obtenemos una instancia del algoritmo seleccionado.
			MessageDigest messageDigest = MessageDigest.getInstance(encoderType.getName());
			messageDigest.reset();

			// Le seteamos el texto al algoritmo.
			messageDigest.update(string.getBytes());
			byte[] digestor = messageDigest.digest();

			// Transformamos la salida y la retornamos.
			return Encoder.hexadecimalToString(digestor).toUpperCase();
		} catch (Exception ex) {
			throw new SecurityUncheckedException("The decode is missing", "errors.security.decode.missing");
		}
	}

	/**
	 * Convierte un arreglo de bytes a valores hexadecimales y los coloca dentro de un string para su retorno.
	 * 
	 * @param digest
	 *            El arreglo de bytes a convertir.
	 * @return El String creado a partir de <code>digest</code>.
	 */
	private static String hexadecimalToString(byte[] digest) {
		String retorno = "";
		for (byte aux : digest) {
			int b = aux & 0xff;
			if (Integer.toHexString(b).length() == 1) {
				retorno += "0";
			}
			retorno += Integer.toHexString(b);
		}
		return retorno;
	}
}