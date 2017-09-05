package java_basics_concurrent;

/**
 * 线程优先级 数字越大优先级越高
 * 
 * @author cclouds
 *
 */
public class ThreadPriority {
	public static class HighPriority extends Thread {
		static int count = 0;

		public void run() {
			while (true) {
				synchronized (ThreadPriority.class) {
					count++;
					if (count > 10000000) {
						System.out.println("HighPriority id complete");
						break;
					}

				}
			}
		}
	}

	public static class LowPriority extends Thread {
		static int count = 0;

		public void run() {
			while (true) {
				synchronized (ThreadPriority.class) {
					count++;
					if (count > 10000000) {
						System.out.println("LowPriority id complete");
						break;
					}

				}
			}
		}

	}

	public static void main(String[] args) {
		HighPriority high = new HighPriority();
		LowPriority low = new LowPriority();
		high.setPriority(Thread.MAX_PRIORITY);
		low.setPriority(Thread.MIN_PRIORITY);
		high.start();
		low.start();
	}
}
