package dk.au.ase.elektronik.thread;

import java.util.concurrent.Semaphore;

public class RaceCondition implements Runnable{

	private static String text="Hello World it is a beautiful day here in Herning.";
	private  static String res="";
	private RaceCondition other;
	private Object obj = new Object();
	private static Semaphore sem = new Semaphore(1);
	

	public RaceCondition() {
		// TODO Auto-generated constructor stub
		sem.release();
		System.out.println(sem.availablePermits());
	}
	public void setOther(RaceCondition other) {
		this.other = other;
	}
	public static void main(String[] args) {
		RaceCondition thread1 = new RaceCondition();
		RaceCondition thread2 = new RaceCondition();
		//RaceCondition thread3 = new RaceCondition();
		thread1.setOther(thread2);
		thread2.setOther(thread1);
		new Thread(thread1).start();
		new Thread(thread2).start();
	}

	@Override
	public  void  run() {
		// TODO Auto-generated method stub
		method1();
	}
	public  void method1() {
		
		System.out.println("Hejsa fra tråd: "+Thread.currentThread() +" "+this);
		String text2 = text+" "+Thread.currentThread();
		String[] textlist = text2.split(" ");
		try {
			other.method2(textlist);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void method2(String[] textlist) throws InterruptedException {
		sem.acquire(); //{
		//String res = "";
		int xx = 0;
		for (String x:textlist) {
			res +=x+" ";
			for (int i=0;i<10000;i++) {
				xx += 10; 
			}
		}
		sem.release();
		System.out.println(this+": "+res+" " + xx);
		
	}
}
