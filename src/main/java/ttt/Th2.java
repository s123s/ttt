package ttt;

public class Th2 extends Thread {

	@Override
	public void run() {
		int i = 0;
		while (i++ < 5) {
			try {
				sleep(700);
				System.out.println(getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Th2 prevTh = null;

		System.out.println("Th1 started");
		for (int i = 0; i < 4; i++) {

			Th2 th = new Th2();
			if (prevTh != null)
				try {
					prevTh.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			th.start();

			prevTh = th;
		}

	}

}
