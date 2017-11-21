package ttt;

public class Th1 extends Thread {
	
@Override
public void run() {
	while(true) {try {
		sleep(700);
		System.out.println(getName());
	} catch (InterruptedException e) {
		e.printStackTrace();
	}}
}

	public static void main(String[] args) {
		System.out.println("Th1 started");
		for (int i = 0; i < 4; i++) {
			Th1 th1 = new Th1();
			th1.start();	
		}
		
	}

}
