package java_basics_concurrent;
/**
 * 等待（wait）和通知（notify）
 * wait()方法后，当前线程就会在这个对象上等待，转为等待状态
 * 等到其他线程调用notify()方法为止
 * 
 * @author cclouds
 *
 */
public class ThreadWaitNotify {

	final static Object object = new Object();

	public static class T1 extends Thread {

		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + ":T1 start!");

				try {
					System.out.println(System.currentTimeMillis()
							+ ": T1 wait for object");
					object.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + ":T1 end!");

			}

		}
	}

	public static class T2 extends Thread {
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis()
						+ ":T2 start! notify one thread");

				object.notify();
				System.out.println(System.currentTimeMillis() + ":T2 end! ");

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

	}
	
	
	public static void main(String[] args) {
		Thread t1 = new T1();
		Thread t2 = new T2();
		
		t1.start();
		t2.start();

	}

}
