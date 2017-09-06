package java_basics_concurrent;

import java.util.ArrayList;
/**
 * 并发ArrayList
 * @author cclouds
 *
 */
public class ThreadArrayList {
	static ArrayList<Integer> list = new ArrayList<Integer>(10);

	public static class AddThread implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10000000; i++) {
				list.add(i);
			}

		}

	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new AddThread());
		Thread t2 = new Thread(new AddThread());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(list.size());
	}
}
