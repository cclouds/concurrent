package jdk_concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockCondition implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition cond = lock.newCondition();

	@Override
	public void run() {
		try {
			lock.lock();
			cond.await();
			System.out.println("Thread is going on");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReenterLockCondition tl =new ReenterLockCondition();
		Thread t1 =new Thread(tl);
		t1.start();
		Thread.sleep(2000);
		lock.lock();
		cond.signal();
		lock.unlock();
		
	}

}
