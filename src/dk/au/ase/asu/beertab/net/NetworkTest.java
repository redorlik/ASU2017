package dk.au.ase.asu.beertab.net;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NetworkTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws UnknownHostException, IOException, InterruptedException {
		
		BeerServer server = new BeerServer("localhost",5589);
		Thread srv = new Thread(server);
		srv.start();
		BeerClient client = new BeerClient("localhost",5589);
		//Thread.sleep(1000);
		client.addPerson("Anders");
		Thread.sleep(1000);
		assertNotNull(server.getPerson("Anders"));
	}

}
