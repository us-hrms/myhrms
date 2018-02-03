package com.hrms.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class PrintWriteUtil {
	
	/**
	 * ∞Ô÷˙–¥»Îresponse
	 * @param response
	 * @param info
	 * @return
	 */
	public static boolean write(HttpServletResponse response,String info){
		PrintWriter out = null;
		boolean result = true;
		try {
			out =  response.getWriter();
			out.print(info);
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = false;
		}finally{
			if(out != null)
				out.close();
		}
		return result;
	}
}
