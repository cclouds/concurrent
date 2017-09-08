package jdk_concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 计划任务
 * @author cclouds
 *
 */
public class ScheduledExecutorServiceDemo {
	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
		
		/**
		 * 创建一个周期性任务，任务开始于给定的初始延时。后续的任务按照给定的周期进行
		 * 后续第一个任务将在initialDelay+period时执行，
		 * 后续第二个任务将在initialDelay+period*2时进行，
		 * 以此类推
		 */
		// ses.scheduleAtFixedRate(new Runnable() {
		//
		// @Override
		// public void run() {
		// try {
		// Thread.sleep(1000);
		// System.out.println(System.currentTimeMillis()/1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		//
		// }
		// }, 0, 2, TimeUnit.SECONDS);

		
		/**
		 * 创建并执行一个周期性任务。任务开始于初始延时时间，后续任务将会按照给定的延时进行处理，
		 * 即上一个任务的结束时间到下一个任务的开始时间的时间差
		 */
		ses.scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println(System.currentTimeMillis() / 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 0, 2, TimeUnit.SECONDS);
	}

}
