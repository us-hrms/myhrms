package com.hrms.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ������ʾ��
 * @author 56474
 *
 */
public class InterceptorDemo extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//Actionִ��ǰ������
		String result = invocation.invoke();// ִ��ʱ
		//Actionִ�к�
		return result; // ����action�Ľ�����Լ����������Ľ��
	}

}
