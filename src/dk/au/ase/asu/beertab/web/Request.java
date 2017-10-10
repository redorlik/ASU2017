package dk.au.ase.asu.beertab.web;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Request extends Base{

	Method method;
	String path;
	
	public Request(String getPack) throws InvalidRequest, InvalidMethod, IOException, InterruptedException {

		InputStream is = new ByteArrayInputStream(getPack.getBytes());
		init(new BufferedReader(new InputStreamReader(is)));
	}
	public Request(BufferedReader ir) throws IOException, InvalidMethod, InvalidRequest, InterruptedException{
		super();
		init(ir);
	}
	public void init(BufferedReader ir) throws IOException, InvalidMethod, InvalidRequest, InterruptedException{
		while (!ir.ready()){
			System.out.print(".");Thread.sleep(100);
		}
		System.out.println("Request:");
		String sl = ir.readLine(); //Startline
		System.out.println(sl);
		String[] parts = sl.split(" ");
		setMethod(parts[0]);
		setPath(parts[1]);
		setProto(parts[2].trim());
		String line = ir.readLine(); //first header line
		
		if (line == null) throw new InvalidRequest();
		
		while (!line.equals("")){
			System.out.println(line);
			addHeader(line.split(":")[0],line.split(":")[1].trim()); //Headers
			line = ir.readLine();
		}
		if (ir.ready()) setBody(ir.readLine());
		
	}

	public void setMethod(String method) throws InvalidMethod {
		Method meth = Method.valueOf(method);
		if (meth==null) throw new InvalidMethod();
		this.method = meth;
	}

	public Method getMethod() {
		// TODO Auto-generated method stub
		return method;
	}


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
