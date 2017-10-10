package dk.au.ase.asu.beertab.web;


import java.util.HashMap;

public class Base {
	
	HashMap<String,String> headers = new HashMap<String,String>();
	String body;
	String proto;
	
	public HashMap<String, String> getHeaders() {
		return headers;
	}
	public void addHeader(String key, String value){
		headers.put(key, value);
	}
	public void setHeaders(HashMap<String, String> headers) {
		this.headers = headers;
	}
	public String getBody() {
		if (body == null){
			body="";
		}
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getProto() {
		return proto;
	}
	public void setProto(String proto) {
		this.proto = proto;
	}
	
	
}
