package com.capgemini.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
	public Encryption() {
	}

	public static String encrypt(String plainMessage) {
		String initialBufferValue16Digit = "a1b2c3d4e5f6g7h8";
		String keyString16Digit = "1234567890123456";
		String resultEncryptedString = "";
		try {
			IvParameterSpec initializationVector = new IvParameterSpec(initialBufferValue16Digit.getBytes("UTF-8"));
			SecretKeySpec secretKey = new SecretKeySpec(keyString16Digit.getBytes(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, initializationVector);

			byte[] encryptedString = cipher.doFinal(plainMessage.getBytes());
			resultEncryptedString = Base64.getEncoder().encodeToString(encryptedString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultEncryptedString;
	}
}
