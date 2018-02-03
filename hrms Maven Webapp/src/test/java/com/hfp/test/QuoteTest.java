package com.hfp.test;

import org.junit.Test;

import com.hrms.entity.Staff;

public class QuoteTest {

//	@Test
	public void quote(){
		Staff s= new Staff();
		s.setId(1l);
		System.out.println(s.getId());
		change1(s);
		System.out.println(s.getId());
		change2(s);
		System.out.println(s.getId());
	}
	
	
	public void change1(Staff staff){
		staff.setId(2l);
	}
	
	public void change2(Staff staff){
		Staff s = new Staff();
		s.setId(3l);
		staff = s;
	}
}
