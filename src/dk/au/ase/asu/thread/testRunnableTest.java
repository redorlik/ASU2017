package dk.au.ase.asu.thread;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testRunnableTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	public String create_string(String x, int count) {
		String xx = "";
		for (int i=0;i<count;i++) {
			xx = xx + x;
		}
		return xx;
	}
	
	public int count_char(String x, String y) {
		String xx = x;
		int i = 0;
		while (xx.contains(y)){
			i += 1;
			xx = xx.substring(xx.indexOf(y,0)+1);
		}
		return i;
	}
	
	@Test
	public void test_count() {
		assertEquals(count_char(create_string("a ",14),"a"),14);
	}
	@Test
	public void test() throws InterruptedException {
	
		testRunnable srcv = new testRunnable(create_string("b ",15));
		testRunnable srcv2 = new testRunnable(create_string("a ",14));
		srcv.start();
		srcv2.start();
		srcv.join();
		srcv2.join();
		System.out.println(srcv.test);
		assertEquals(srcv.test,srcv2.test);
		assertEquals(14,count_char(srcv.test,"a"));
		assertEquals(count_char(srcv.test,"b"),15);
	}
	public class TestData {
		private int number;
		private List<String> strings;
		private List<Integer> antal;

		public TestData(int number) {
			this.number = number;
			this.strings = new ArrayList<String>();
			this.antal = new ArrayList<Integer>();
			create_data();
		}
		
		public void create_data() {
			for (int i=0;i<number;i++) {
				strings.add( String.format("%d ",i));
				antal.add( i*10);
			}
		}
	}
	@Test
	public void test_data() {
		int tests = 5;
		TestData data = new TestData(tests);
		
		assertEquals((Integer)10,data.antal.get(1));
		assertEquals("1 ",data.strings.get(1));
	}
	
	@Test
	public void test_gen() throws InterruptedException {
		int tests = 5;
		TestData data = new TestData(tests);
		testRunnable[] test_insts = new testRunnable[tests];
		for (int i = 0; i< tests;i++) {
			test_insts[i] = new testRunnable(create_string(data.strings.get(i),
					data.antal.get(i)));
			test_insts[i].start();
		}
		for (int i = 0; i< tests;i++) {
			test_insts[i].join();
		}
		assertEquals(data.antal.get(0),(Integer)count_char(test_insts[tests-1].test,
				data.strings.get(0)));
	}
	@Test
	public void test_multi() throws InterruptedException {
		int tests = 5;
		String[] test_strings = {"aa ","b ","c ","d ","e "};
		int[] test_numbers = { 5,10,15,25,30};
		testRunnable[] test_insts = new testRunnable[tests];
		for (int i = 0; i< tests;i++) {
			test_insts[i] = new testRunnable(create_string(test_strings[i],test_numbers[i]));
			test_insts[i].start();
		}
		for (int i = 0; i< tests;i++) {
			test_insts[i].join();
		}
		System.out.println(test_insts[3].test);
		assertEquals(5,count_char(test_insts[3].test,"aa"));
	}
}
