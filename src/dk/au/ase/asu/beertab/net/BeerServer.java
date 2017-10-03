package dk.au.ase.asu.beertab.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;

import dk.au.ase.asu.beertab.GUI.Person;

public class BeerServer implements Runnable {
	ServerSocket server;
	private HashMap<String,Integer> tab = new HashMap<String, Integer>();
	
	public BeerServer(String string, int i) throws IOException {
		server = new ServerSocket();
		server.bind(new InetSocketAddress(i));
	}

	@Override
	public void run() {
		try {
			Socket sck = server.accept();
			InputStreamReader st = new InputStreamReader(sck.getInputStream());
			BufferedReader br = new BufferedReader(st);
			OutputStream ot = sck.getOutputStream();
			
			while (true) {
				System.out.println("Server Start");
				String resp = br.readLine();
				System.out.println("Server read message "+resp);
				if (resp.startsWith("Add Person :")) {
					String temp = resp.split(":")[1];
					System.out.println(temp);
					tab.put(temp,0);
				}else if (resp.startsWith("add drink")) {
					
				}else if (resp.startsWith("cheers")) {
					
				}else {
					ot.write("Error: No such command".getBytes());
				}
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Integer getPerson(String string) {
		// TODO Auto-generated method stub
		return tab.get(string);
	}

}
