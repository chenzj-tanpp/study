package sentcutmer;

public class Sentcutmer {
	public static void main(String[] args) {
		sent c = new sent(); 
		new Thread(c, "司机1").start();      
		new Thread(c, "司机2").start();      
		new Thread(c, "司机3").start();     
		new Thread(c, "司机4").start(); 
		new Thread(c, "司机5").start(); 
	}

}
class sent implements Runnable {
	private int n = 100;

	public void run() {
		while (true) {
			if (n > 0) {
				Thread th = Thread.currentThread();
				String th_name = th.getName();
				System.out.println(th_name + " 正在接第 " +  n-- + " 位客人 ");
			}
			else break;
		}
	}
}
