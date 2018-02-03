package com.hrms.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 拦截器示例
 * @author 56474
 *
 */
public class InterceptorDemo extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//Action执行前。。。
		String result = invocation.invoke();// 执行时
		//Action执行后
		return result; // 返回action的结果或自己定义其它的结果
	}

}
