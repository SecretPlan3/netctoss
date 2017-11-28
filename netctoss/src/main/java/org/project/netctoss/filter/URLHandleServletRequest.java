package org.project.netctoss.filter;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class URLHandleServletRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;
	
	public URLHandleServletRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		this.request = request;
	}
	
	@Override
	public String getRequestURI() {
		// TODO Auto-generated method stub
		String requestUrI = "";
		try {
			requestUrI = URLDecoder.decode(request.getRequestURI(), "utf-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return requestUrI;
	}
	
	
	@Override
	public String getServletPath() {
		// TODO Auto-generated method stub
		String servletPath = "";
		try {
			servletPath = URLDecoder.decode(request.getServletPath(), "utf-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return servletPath;
	}
	
	
	@Override
	public StringBuffer getRequestURL() {
		// TODO Auto-generated method stub
		String requestUrL = "";
		try {
			requestUrL = URLDecoder.decode(request.getRequestURL().toString(), "utf-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new StringBuffer(requestUrL);
	}
}
