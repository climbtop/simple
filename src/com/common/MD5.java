package com.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.trendy.fw.common.crypto.CryptoKit;

public class MD5 {

	private static MessageDigest messageDigest = null;
	static {
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String getMD5(byte[] bytes) {
		messageDigest.update(bytes);
		return CryptoKit.bytesToHex(messageDigest.digest());
	}

	/**
	 * ʹ����ϢժҪMD5������ܼ������ַ������м��ܡ�
	 * <p>
	 * ���ַ������м��ܣ�����32λ�ļ����ַ�����Ĭ�ϼ���KeyΪ""
	 * <p>
	 * <p>
	 * 
	 * @param data
	 *            String Դ��
	 * @return String ���ܴ�
	 */
	synchronized static public final String getMD5(String str) {
		return getMD5(str, "");
	}

	/**
	 * ʹ����ϢժҪMD5������ܼ������ַ������м��ܡ�
	 * <p>
	 * ���ַ������м��ܣ�����32λ�ļ����ַ�����<b>���ܴ���key���Զ���</b>
	 * <P>
	 * 
	 * @param data
	 *            String Դ��
	 * @return String ���ܴ�
	 */
	synchronized static public final String getMD5(String str, String key) {
		if (str == null) {
			return null;
		}

		if (key == null || key.trim().equals("")) {
			key = "";
		}

		messageDigest.update(str.getBytes());
		return CryptoKit.bytesToHex(messageDigest.digest(key.getBytes()));
	}
}