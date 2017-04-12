package com.elior.coupons.threds;


public class DailyCouponsExpirationTask implements Runnable{	


	public void run() {
						
		while (true) {
			try {
				Thread workThread = new Thread(new WorkThread());
				workThread.start();
				
				Thread.sleep(1000 * 60 * 60 * 24);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


	}
}
