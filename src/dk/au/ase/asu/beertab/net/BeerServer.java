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
	private HashMap<String,HashMap> tab = new HashMap<String, HashMap>();
	private List<String> drinks = new LinkedList<String>();
	private boolean alive = true;
	
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
			
			while (alive ) {
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
				int num;
				switch (cmd) {
					case Add_Person:
						tab.put(temp[1],new HashMap());
						break;
					case Add_Drink:
						drinks.add(temp[1]);
						break;
					case Buy_drink:{
						String[] args = temp[1].split(" ");
						HashMap pers_tab = tab.get(args[0]);
						Integer tmp = null;
						if (pers_tab == null) {
							tab.put(args[0],new HashMap());
							pers_tab = tab.get(args[0]);
						}
						tmp = (Integer) pers_tab.get(args[1]);
						num = Integer.parseInt(args[2]);
						if (tmp == null) tab.get(args[0]).put(args[1],num);
						else tab.get(args[0]).put(args[1],tmp+num);
						break;}
					default:
						ot.write("Error: No such command".getBytes());
				}
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public HashMap getPerson(String string) {
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

	public HashMap getTab(String string) {
		
		return tab.get(string);
	}

	public void kill() {
		alive = false;
		
	}

}
