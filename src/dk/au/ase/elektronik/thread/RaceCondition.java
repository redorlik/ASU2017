package dk.au.ase.elektronik.thread;

public class RaceCondition implements Runnable{

	private static String text="Hello World it is a beutiful day here in Herning.";
	private  static String res;

	public RaceCondition() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		RaceCondition thread1 = new RaceCondition();
		RaceCondition thread2 = new RaceCondition();
		RaceCondition thread3 = new RaceCondition();
		new Thread(thread1).start();
		new Thread(thread2).start();
		new Thread(thread3).start();
	}

	@Override
	public  void  run() {
		// TODO Auto-generated method stub
		res = "";
		int xx = 0;
		String[] textlist = text.split(" ");
		synchronized(RaceCondition.class) {
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
