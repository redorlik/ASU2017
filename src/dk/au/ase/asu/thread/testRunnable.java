package dk.au.ase.asu.thread;

import java.util.concurrent.locks.ReentrantLock;

public class testRunnable extends Thread {

	static String test = "";
	String text;
	static ReentrantLock lock;
	
	public testRunnable(String text) {
		// TODO Auto-generated constructor stub
		this.text = text;
		this.lock = new ReentrantLock();
	}
	public void run() {
		String[] l = this.text.split(" ");
		for(int x=0;x<l.length;x++) {
			
			try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mYmethod(l[x]);
		}
		System.out.println("Thread finished");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testRunnable srcv = new testRunnable("b b b b b b b b b b b b b b b");
		testRunnable srcv2 = new testRunnable("a a a a a a a a a a a a a a");
		System.out.println("Thread initialised");
		srcv.start();
		srcv2.start();
		System.out.println("Thread running");
		try {
			srcv.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(srcv.test);
	}

	public  void mYmethod(String word) {
		
		lock.lock();
		this.test = this.test +" "+ word;
		lock.unlock();

		try {
			sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
