package dk.au.ase.asu.beertab.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;

public class HttpHandler implements Callable,Runnable {

	private Socket sck;
	public HttpHandler(Socket sck) {
		// TODO Auto-generated constructor stub
		this.sck = sck;
	}
	public String handleHttp() throws InterruptedException {
		String err = "All ok";
		try {
			BufferedReader inp_stream = new BufferedReader(
							new InputStreamReader(
									sck.getInputStream()));
			String line = inp_stream.readLine();//Read command line
			System.out.println(line);
			String command = line.split(" ")[0];
			System.out.println(command);
			if (command.equals("GET")) {
				// Find the path : line.split(" ")[1]
				// Read header section
				line = inp_stream.readLine();
				String head = line+"\r\n";
				while (!line.equals("")) {
					System.out.println(line);
					line = inp_stream.readLine();
					head += line+"\r\n";
				}
				int inp;
				//Read body sektion
				while (inp_stream.ready()) {
					inp = inp_stream.read();
					System.out.print(inp+" ");
				}
				System.out.println("BODY Section");
				while (!line.equals("")) {
					System.out.println(line);
					line = inp_stream.readLine();
				}
				String stat = "HTTP/1.1 200 ok\r\n";
				
				String body = "To be or not to be , that is the question.";
				String str = stat+head+"\r\n"+ body;
				Thread.sleep(100);
				OutputStream output = sck.getOutputStream();
				output.write(str.getBytes());
				output.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			err = e.getMessage();
		}
		return err;
		
	}
	@Override
	public void run() {
		try {
			handleHttp();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		String err = "Alt er OK";
		try {
			handleHttp();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			err = e.getMessage();
		}
		return err;
	}

}
