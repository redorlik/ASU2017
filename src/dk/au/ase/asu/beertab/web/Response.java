package dk.au.ase.asu.beertab.web;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Response extends Base {

	String status;

	public Response() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString(){
		String pack = getProto()+" "+getStatus()+"\r\n";
		Map headers = getHeaders();
		if (headers != null){
			Iterator<Entry<String, String>> it = getHeaders().entrySet().iterator();
		
			while (it.hasNext()){
				Entry<String,String> header = it.next();
				pack += header.getKey()+": "+header.getValue()+"\r\n";
			}
		}
		pack += "\r\n"+getBody();
		return pack;
	}

}
