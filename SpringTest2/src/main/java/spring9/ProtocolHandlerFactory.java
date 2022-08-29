package spring9;

import java.util.Map;

class RestHandler{
	//new RestHandler()->public RestHandler(){} 기본생성자 호출
}//var RestHandler={}

class SoapHandler{}

public class ProtocolHandlerFactory {
	//Map객체->HashMap,Hashtable
	private Map<String,Object> map;

	public void setMap(Map<String, Object> map) {
		this.map = map;
		System.out.println("setMap call=>"+map);
	}
	
	
}
