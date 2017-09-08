package jdk_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 线程池
 * @author cclouds
 *
 */
public class ThreadPoolDemo {
	public static class MyTask implements Runnable {

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis() + ":Thread ID:"
					+ Thread.currentThread().getId());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		MyTask task = new MyTask();
		//固定大小的线程池
//		ExecutorService exec = Executors.newFixedThreadPool(5);
		//根据实际情况调整的线程池
		ExecutorService exec = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++) {
			exec.submit(task);
		}

	}

}
