package sentcutmer;

public class Sentcutmer {
	public static void main(String[] args) {
		sent c = new sent(); 
		new Thread(c, "˾��1").start();      
		new Thread(c, "˾��2").start();      
		new Thread(c, "˾��3").start();     
		new Thread(c, "˾��4").start(); 
		new Thread(c, "˾��5").start(); 
	}

}
class sent implements Runnable {
	private int n = 100;

	public void run() {
		while (true) {
			if (n > 0) {
				Thread th = Thread.currentThread();
				String th_name = th.getName();
				System.out.println(th_name + " ���ڽӵ� " +  n-- + " λ���� ");
			}
			else break;
		}
	}
}
