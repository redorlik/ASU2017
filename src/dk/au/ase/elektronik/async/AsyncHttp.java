package dk.au.ase.elektronik.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncHttp {

	public AsyncHttp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		Future<String> fut = es.submit(new Callable<String>() {
			public String call() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "Hello World";
			}
		});

		Executors.callable(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
