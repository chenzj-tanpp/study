package Main;
import car.*;
import factory.*;
public class Main {
	public static void main(String args[]) {
		Storage st = new Storage();
		st.chu();//��ʼ������
		Input input = new Input(st);
		Output output = new Output(st);
		new Thread(input).start();
		new Thread(output).start();
	}
}
