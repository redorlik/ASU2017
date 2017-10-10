package dk.au.ase.asu.beertab.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class HttpHandler implements Runnable {
	private Socket sck;
	private Request rqs = null;
	private Response rsp = new Response();
	private BufferedReader input;
	
	public HttpHandler(Socket sock) throws IOException{
		sck = sock;
		input = new BufferedReader(new InputStreamReader(sck.getInputStream()));
		
	}
//	public void finalize(){
//		try {
//			sck.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	private void doNotImplemented() {
		System.out.println("Not Implemented");
		doHead();
		rsp.setStatus("501 Not Implemented");
		
	}
	private void doPOST(){
		
		synchronized (rsp){
			this.doHead();
			
		}
	}

	private void doGET() {
		System.out.println("doGET");
		
		doHead();
		rqs.getPath();
		rsp.setStatus("200 OK");
		rsp.setBody("<html><body>Hello World</body></html>\r\n");
	}

	private void doHead() {
		//System.out.println("doHEAD");
		
		// XXX not good enough
		if (!(rqs == null)) rsp.setHeaders(rqs.getHeaders());
		rsp.setProto("HTTP/1.1");
		rsp.setStatus("200 OK");
		
	}

	@Override
	public void run() {
		String pck = "";
		
	
		System.out.println("Handler");
		
		try {
			//if (input.ready()){
				System.out.print("********");
				rqs = new Request(input);
			//}
			//input.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (InvalidMethod e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Ready to dispatch "+rqs.getMethod());
		catch (InvalidRequest e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rqs == null) doNotImplemented();
		else{
			switch (rqs.getMethod()){
				case GET: doGET(); break;
				case HEAD: doHead(); break;
				case POST:;
				default : doNotImplemented();
			}
		}
		System.out.println("Ready to write "+ rsp);
		
		OutputStream out;
		try {
			out = sck.getOutputStream();
			out.write(rsp.toString().getBytes());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
