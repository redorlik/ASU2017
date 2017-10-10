package dk.au.ase.asu.beertab.web;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Acceptloop implements Runnable{
	ServerSocket srv;
	int port = 8090;
	int MAXTHREAD = 10;
	private boolean stop=false;
	
	public void	 loop() throws IOException{
		srv = new ServerSocket(port);
		ExecutorService exe = Executors.newScheduledThreadPool(MAXTHREAD);
		while(!stop){
			Socket sck = srv.accept();
			System.out.println("Socket : "+sck.toString());
			HttpHandler handle = new HttpHandler(sck);
			//handle.run();
			//new Thread(handle).start();
			exe.submit(handle);
		}
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		Acceptloop srv = new Acceptloop();
		try {
			srv.loop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			loop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stop() {
		stop=true;
		
	}
}
