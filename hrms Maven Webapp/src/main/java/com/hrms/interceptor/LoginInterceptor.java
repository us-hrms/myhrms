package com.hrms.interceptor;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hrms.entity.Staff;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@Component
public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		Staff staff = (Staff) session.get("currStaff");
		if(staff!=null){
			//将当前登录的staff 填充到action中的currStaff 属性中去
			Field currStaff = invocation.getAction().getClass().getDeclaredField("currStaff");
			currStaff.setAccessible(true);
			currStaff.set(invocation.getAction(), staff);
			return invocation.invoke();
		}else
			return "toHome";
	}

}
