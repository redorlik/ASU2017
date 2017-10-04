package dk.au.ase.asu.beertab.net;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NetworkTest {

	static BeerClient client;
	static BeerServer server;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		server = new BeerServer("localhost",5589);
		Thread srv = new Thread(server);
		srv.start();
		client = new BeerClient("localhost",5589);
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_addPerson() throws UnknownHostException, IOException, InterruptedException {
		client.addPerson("Anders");
		Thread.sleep(10);
		assertNotNull(server.getPerson("Anders"));
		assertEquals((Integer)server.getPerson("Anders"),(Integer)0);
	}
	@Test
	public void test_addDrink() throws IOException, InterruptedException {
		client.addDrink("Øl");
		client.addDrink("Vin");
		client.addDrink("Rom");
		Thread.sleep(10);
		assertNotNull(server.getDrink("Øl"));
		assertEquals(server.getDrink("Øl"),"Øl");
		assertEquals(server.getDrink("Vin"),"Vin");
		assertEquals(server.getDrink("Whisky"),"");
	}
}
