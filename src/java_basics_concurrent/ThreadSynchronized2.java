package java_basics_concurrent;

public class ThreadSynchronized2 implements Runnable {

	static ThreadSynchronized2 instance = new ThreadSynchronized2();

	static int i = 0;

	@Override
	public void run() {
		for (int j = 0; j < 10000000; j++) {
			increase();
		}

	}

	private synchronized void increase() {
		i++;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 =new Thread(instance);
		Thread t2 =new Thread(instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
		
	}

}
