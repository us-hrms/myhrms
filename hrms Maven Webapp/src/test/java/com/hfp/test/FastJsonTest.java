package com.hfp.test;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class FastJsonTest {

//	@Test
	public void json(){
		boolean result = true;
		System.out.println(JSONObject.toJSONString(result));
	}
}
