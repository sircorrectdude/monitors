package com.evodat.webapp.util;

/**
 * @author joris
 * 
 */
public class SignalValue implements Runnable {
	private static final SignalValue SINGLETON = new SignalValue(0);

	public static SignalValue getInstance() {
		return SINGLETON;
	}

	private int remainTime;

	private SignalValue(int remainTime) {
		this.remainTime = remainTime;
	}

	public void run() {
		this.runTimer();
	}

	public void runTimer() {
		while (remainTime > 0) {
//			System.out.println("Remaining: " + getRemainTime() + " seconds");
			try {
				remainTime--;
				Thread.sleep(1000L); // 1000L = 1000ms = 1 second
			} catch (InterruptedException e) {
			}
		}
	}

	public int getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(int runTime) {
		this.remainTime = runTime;
		new Thread(SignalValue.getInstance()).start();
	}

}
