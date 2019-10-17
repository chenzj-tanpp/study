package Example5;

public class Example5 {
	public static void main(String[] args) {
		TicketWindow tw = new TicketWindow(); 
		new Thread(tw, "窗口1").start();      
		new Thread(tw, "窗口2").start();      
		new Thread(tw, "窗口3").start();     
		new Thread(tw, "窗口4").start();  
	}
}
class TicketWindow implements Runnable {
	private int tickets = 100;

	public void run() {
		while (true) {
			if (tickets > 0) {
				Thread th = Thread.currentThread(); // 获取当前线程
				String th_name = th.getName(); // 获取当前线程的名字
				System.out.println(th_name + " 正在发售第 " + tickets-- + " 张票 ");
			}
			else break;
		}
	}
}
