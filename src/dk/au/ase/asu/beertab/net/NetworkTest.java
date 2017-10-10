package dk.au.ase.asu.beertab.net;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;

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
		assertEquals((HashMap)server.getPerson("Anders"),new HashMap<String,Integer>());
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
	@Test
	public void test_buying() throws IOException, InterruptedException {
		client.addPerson("Anders");
		client.addDrink("Øl");
		client.BuyDrink("Anders","Øl",1);
		client.BuyDrink("Anders","Vin",10);
		Thread.sleep(10);
		assertNotNull(server.getTab("Anders"));
		assertEquals(server.getTab("Anders").get("Øl"),1);
		assertEquals(server.getTab("Anders").get("Vin"),10);
	}
}
