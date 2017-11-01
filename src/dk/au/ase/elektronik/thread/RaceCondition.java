package dk.au.ase.elektronik.thread;

public class RaceCondition implements Runnable{

	private static String text="Hello World it is a beutiful day here in Herning.";
	private  static String res;
	private RaceCondition other;
	private Object obj = new Object();

	public RaceCondition() {
		// TODO Auto-generated constructor stub
	}
	public void setOther(RaceCondition other) {
		this.other = other;
	}
	public static void main(String[] args) {
		RaceCondition thread1 = new RaceCondition();
		RaceCondition thread2 = new RaceCondition();
		RaceCondition thread3 = new RaceCondition();
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
	public synchronized void method1() {
		
		System.out.println("Hejsa fra tråd: "+Thread.currentThread());
		String[] textlist = text.split(" ");
		other.method2(textlist);
	}
	public  void method2(String[] textlist) {
		synchronized(obj) {
		String res = "";
		int xx = 0;
		for (String x:textlist) {
			res +=x+" ";
			for (int i=0;i<10000;i++) {
				xx += 10; 
			}
		}
		System.out.println(res+" " + xx);
		}
	}
}
