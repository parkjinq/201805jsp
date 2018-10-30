package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ParameterWrapper extends HttpServletRequestWrapper {

	private Map<String, String[]> newMap;
	
	public ParameterWrapper(HttpServletRequest request) {
		super(request);
		
		//request객체의 parameterMap객체를 복사하여 새로운 map객체를 생성
		newMap = new HashMap<String, String[]>(request.getParameterMap());
	}
	
	public void setParameter(String key, String[] values) {
		newMap.put(key, values);
	}
	
	/*
		parameter 관련 메서드 재정의
			getParameter(String name)
			getParameterValues(String name)
			getParameterMap()
			getParameterNames()
	 */
	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return newMap;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return newMap.get(name);
	}
	
	@Override
	public String getParameter(String name) {
		String[] values = newMap.get(name);
		if(values == null){
			return null;
		} else {
			return values[0];
		}
	}
	
	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(newMap.keySet());
	}
	
}















