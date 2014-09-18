package com.demo.scheduler;

public class QuartzJob {
	public void work() {
		System.out.println(Thread.currentThread() + " doing job!");
	}
}
