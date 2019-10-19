package exercise562;

public class Exercise562 {
	public static void main(String[] args) {
		new Thread(new MyRunnable()).start();
		int i;
		for (i = 1; i <=100; i++) {
			System.out.println(+i +" ´Îmain");
		}
	}

}
 class MyRunnable implements Runnable {
	public void run() {
		int i;
		for (i = 1; i <= 50; i++) {
			System.out.println( +i +" ´Înew");
		}
	}

	
}
