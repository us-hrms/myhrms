package com.hrms.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	/**
	 * ��ȡʮ�����Ƶ�MD5�ַ���
	 * @param str
	 * @return
	 */
	public static String getMD5(String str){
		MessageDigest md = null;
		String result = null;
		try {
			md = MessageDigest.getInstance("MD5");
			byte [] input = str.getBytes("UTF-8");
			byte [] output = md.digest(input);
			result  = bytesToHex(output);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ���ֽ�תΪʮ������
	 * @param bytes
	 * @return
	 */
	private static String bytesToHex(byte[] bytes) {  
	    StringBuffer md5str = new StringBuffer();  
	    // ������ÿһ�ֽڻ���16��������md5�ַ���  
	    int digital;  
	    for (int i = 0; i < bytes.length; i++) {  
	        digital = bytes[i];  
	        //����ת��
	        if (digital < 0) {  
	        	digital += 256;  
	        }  
	        //�Ƿ����ʮ��
	        if (digital < 16) {  
	        md5str.append("0");  
	        }  
	        md5str.append(Integer.toHexString(digital));  
	    }  
	    return md5str.toString().toUpperCase();  
	}
}
