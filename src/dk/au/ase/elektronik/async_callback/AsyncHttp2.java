package dk.au.ase.elektronik.async_callback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
/*
 * Async HTTP server
 * 				Få fat i en forbindelse (Socket)
 * 					Læs telegram fra socket inputstream
 * 					Find kommando (Get,head,...)
 * 					Udfør kommando
 * 					Send svar
 * 
 */
public class AsyncHttp2 {

	private int port;
	private static ServerSocket srv;
	private static int i=0;

	public static void main(String[] args) {
		AsyncHttp2 srver = null;
		try {
			srver = new AsyncHttp2(8785);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		srver.Go();
	}
	public AsyncHttp2(int port) throws IOException {
		// TODO Auto-generated constructor stub
		this.port = port;
		srv = new ServerSocket(this.port);
	}

	public void Go() {
		while (true) {
			CompletableFuture cf = CompletableFuture.supplyAsync(AsyncHttp2::accept_loop).
					thenAcceptAsync(AsyncHttp2::ReadVerb);
//			try {
//				cf.get();
//			} catch (InterruptedException | ExecutionException e) {
		// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		}
	}
	public void sendResponse(String res) {
		
	}
	public static void ReadVerb(Socket sck)  {
		BufferedReader inp = null;
		i++;
		try {
			inp = new BufferedReader(new InputStreamReader(sck.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			line = inp.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] parts = line.split(" ");
		System.out.println(parts[0]);
		String res;
		switch (parts[0]) {
			case "GET": res = doGet(inp); break;
			case "HEAD": res = doHEAD(inp); break;
			default: res = "";
			
		}
		res = "HTTP/1.1 200 OK \r\n"+res;
		System.out.println(res);
		OutputStream out = null;
		try {
			out = sck.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.write(res.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sck.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i);
	}
	private static String doHEAD(BufferedReader inp) {
		// TODO Auto-generated method stub
		return "";
	}
	private static String doGet(BufferedReader inp) {
		// TODO Auto-generated method stub
		return "\r\n\r\n";
	}
	public static Socket accept_loop() {
		
		Socket sck = null;
		
			try {
				 sck = srv.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return sck;
	}
}
