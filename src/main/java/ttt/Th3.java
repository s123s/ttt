package ttt;

import java.io.IOException;

public class Th3 extends Thread {
	private volatile boolean mFinish = false;
	synchronized void finish () {
		mFinish = true;
	}

	@Override
	public void run() {
		while (!mFinish) {
			try {
				sleep(700);
				System.out.println(getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Th1 started");
		Th3 th = new Th3();
		th.start();
		
		byte[] b = new byte[1024];
		try {
			System.in.read(b);
			th.finish();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
