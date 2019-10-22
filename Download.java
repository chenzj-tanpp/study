package download;

public class Download {
	static int[] a = new int[100];
	int[] c = new int[100];
static int i;
	public static void chuang() {
		int i;
		for (i = 0; i < 100; i++) {
			a[i] = i + 1;
		}

	}

	static synchronized void xiazai() {
		Download.chuang();
			Thread th = Thread.currentThread();
			String th_name = th.getName();
			System.out.println(th_name + " 下载 " + a[i++]);
		}

	public static void main(String[] args) {
		Down c = new Down();
		new Thread(c).start();
		new Thread(c).start();
		new Thread(c).start();
		new Thread(c).start();
		new Thread(c).start();
	}
}

class Down implements Runnable {
	private int n = 100;
	public void run() {
		while (true) {
			if (n >0) {
				try {
					Thread.sleep(10);// 经过的线程休眠10毫秒
					Download.xiazai();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
		}
	}
}