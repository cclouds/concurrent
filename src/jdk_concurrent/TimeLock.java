package jdk_concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 等待锁
 * @author cclouds
 *
 */
public class TimeLock implements Runnable{
	
	public static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		try {
			if(lock.tryLock(5, TimeUnit.SECONDS)){
				Thread.sleep(6000);
			}else{
				System.out.println("get lock fail");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(lock.isHeldByCurrentThread())
				lock.unlock();
		}
		
	}
	
	public static void main(String[] args) {
		TimeLock lock = new TimeLock();
		Thread t1 =new Thread(lock);
		Thread t2 =new Thread(lock);
		t1.start();
		t2.start();
	}

}
