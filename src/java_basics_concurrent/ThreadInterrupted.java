package java_basics_concurrent;
/**
 * 线程中断（interrupt）
 * 1.Thread.interrupt()    中断线程
 * 2.Thread.isInterrupt()  判断是否被中断
 * 3.Thread.interrupted()  判断是否被中断，并清除当前中断状态
 * @author cclouds
 *
 */
public class ThreadInterrupted {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 =new Thread(){
			@Override
			public void run(){
				while(true){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interruted");
						break;
					}
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("Interruted when sheep");
						//设置中断状态
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}
			}
			
		};
		
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();
	}

}
