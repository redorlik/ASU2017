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
import java.util.LinkedList;
import java.util.List;

import dk.au.ase.asu.beertab.GUI.Person;

public class BeerServer implements Runnable {
	ServerSocket server;
	private HashMap<String,Integer> tab = new HashMap<String, Integer>();
	private List<String> drinks = new LinkedList<String>();
	
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
				String resp = br.readLine();
				System.out.println("Server read message "+resp);
				String[] temp = resp.split(":");
				Commands cmd = null;
				
				for (Commands p:Commands.values()) {
					if (p.getCommand().equals(temp[0])) {
						cmd = p;
						break;
					}		
				}
				switch (cmd) {
					case Add_Person:
						tab.put(temp[1],0);
						break;
					case Add_Drink:
						drinks.add(temp[1]);
						break;
					case Buy_drink:
						break;
					default:
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

	public String getDrink(String string) {
		// TODO Auto-generated method stub
		String res = "";
		for (String s:drinks) {
			if (s.equals(string)) res = s;
		}
		return res;
	}

}
