package exercise563;

public class Exercise563 {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		new Thread(t, "��ʦ1").start();
		new Thread(t, "��ʦ2").start();
		new Thread(t, "��ʦ3").start();
	}

}

class Teacher implements Runnable {
	private int notes = 80;

	public void run() {
		while (true) {
			dispatchNotes(); // ������Ʊ����
			if (notes <= 0) {
				break;
			}
		}
	}
public void dispatchNotes() {
		
			System.out.println(Thread.currentThread().getName() + "�����ıʼ�" + notes--);
		}
}