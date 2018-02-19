package com.hrms.util;

import java.util.List;

public class HQLHelper {
	
	public static StringBuffer toHqlWhere(List<String> params){
		StringBuffer param = null;
		//ºÏ³Éstring
		for (int i = 0; i < params.size(); i++) {
			if(i==0)
				param = new StringBuffer(params.get(i));
			else
				param.append(" and "+params.get(i));
		}
		return param;
	}
}
