package com.capgemini.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Decryption {
	public Decryption() {
	}

	public static String decrypt(String encryptedMessage) {
		String initialBufferValue16Digit = "a1b2c3d4e5f6g7h8";
		String keyString16Digit = "1234567890123456";
		String resultPlainString = "";
		try {
			IvParameterSpec initializationVector = new IvParameterSpec(initialBufferValue16Digit.getBytes("UTF-8"));
			SecretKeySpec secretKey = new SecretKeySpec(keyString16Digit.getBytes(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, initializationVector);

			byte[] encryptedInBytes = Base64.getDecoder().decode(encryptedMessage);
			byte[] decryptedString = cipher.doFinal(encryptedInBytes);
			resultPlainString = new String(decryptedString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPlainString;
	}
}
