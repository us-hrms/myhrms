package com.hfp.test;

import org.junit.Test;

import com.hrms.util.MD5Util;

public class MD5Test {

	@Test
	public void md5(){
		System.out.println(MD5Util.getMD5("HFP"));
		System.out.println(MD5Util.getMD5("HFP"));
		System.out.println(MD5Util.getMD5("HFPHFPHFPHFPHFPHFPHFPHFPHFPHFPHFPHFP"));
		System.out.println(MD5Util.getMD5("HFPHFPHFPHFPHFPHFPHFPHFPHFPHFPHFPHFP"));
		System.out.println(MD5Util.getMD5("HFP").length());
		System.out.println(MD5Util.getMD5("HFPHFPHFPHFPHFPHFPHFPHFPHFPHFPHFPHFP").length());
	}
	
	public void md5t(){
		System.out.println(MD5Util.getMD5(""));
	}
}
