package Example1;

public class Example1 {
	public static void main(String[] args) {
		MyThread myThread=new MyThread();
		myThread.run(); 
		while (true) {  
			System.out.println("Main����������");
		}
	}
}
class MyThread {
	public void run() {
		while (true) { 
			System.out.println("MyThread���run()����������");
		}
	}
}
