package dk.au.ase.asu.beertab.GUI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static int LEN = 1024;
	private static ServerSocket server;
	private static byte[] b = new byte[LEN];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		server = new ServerSocket(8090);
		while(true) {
			Socket sck = server.accept();
			sck.getInputStream().read(b,0,LEN);
			String s = new String(b);
			sck.getOutputStream().write(s.toUpperCase().getBytes());
		}
	}

}
