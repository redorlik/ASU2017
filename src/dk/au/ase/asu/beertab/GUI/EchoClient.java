package dk.au.ase.asu.beertab.GUI;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket sck = new Socket("localhost",8090);
		sck.getOutputStream().write("Hello low WorlD".getBytes());
		byte[] b = new byte[1024];
		sck.getInputStream().read(b );
		System.out.println(new String(b));
	}

}
