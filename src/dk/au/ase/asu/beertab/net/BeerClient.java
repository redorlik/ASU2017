package dk.au.ase.asu.beertab.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class BeerClient {

	private Socket sck;

	public BeerClient(String string, int i) throws UnknownHostException, IOException {
		sck = new Socket(string,i);
	}

	public void addPerson(String string) throws IOException {
		String str = Commands.Add_Person.getCommand()+":"+string+"\n";
		sck.getOutputStream().write(str.getBytes());
		
	}

}
