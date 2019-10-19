package exercise563;

public class Exercise563 {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		new Thread(t, "老师1").start();
		new Thread(t, "老师2").start();
		new Thread(t, "老师3").start();
	}

}

class Teacher implements Runnable {
	private int notes = 80;

	public void run() {
		while (true) {
			dispatchNotes(); // 调用售票方法
			if (notes <= 0) {
				break;
			}
		}
	}
public void dispatchNotes() {
		
			System.out.println(Thread.currentThread().getName() + "发出的笔记" + notes--);
		}
}