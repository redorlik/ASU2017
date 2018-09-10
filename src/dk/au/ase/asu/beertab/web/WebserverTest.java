package dk.au.ase.asu.beertab.web;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

public class WebserverTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws MalformedURLException {
		URL url = new URL("http://localhost:8108/");
		
	}

}
