package Main;

import car.car;
import factory.factory;
import xml.ReadXMLUitilcar;

class Input implements Runnable { // �����߳���
	private Storage st;
	Input(Storage st) { 
		this.st = st;
	}

	public void run() {
		while (true) {
			st.put();

		}
	}
}

class Output implements Runnable { 
	private Storage st;
	Output(Storage st) {
		this.st = st;
	}

	public void run() {
		while (true) {
			st.get();

		}
	}

}

class Storage {
	private car[] cells = new car[10];

	public void chu() {//��ʼ������ķ���
		factory carFactroy = (factory) ReadXMLUitilcar.getBrandName();

		 int i;
		for (i = 0; i < 10; i++) {
			cells[i] = carFactroy.proudctCar();
			
		}

	}

	private int inPos=0, outPos=0, count; // inPos����ʱ�����±꣬outPosȡ��ʱ�����±�,�������ȡ�����ݵ�����

	public synchronized void put() {// ���
		try {
		
			while (count == cells.length) {
				this.wait();
			}

			System.out.println("����" + inPos + "��" + cells[inPos].toString() + "���");
			inPos++;
			if (inPos == cells.length) 
				inPos = 0;
			count++; 
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void get() {
		try {
			while (count == 0) { 
				this.wait();
			}
			System.out.println("����" + outPos + "," + cells[outPos].toString() + " ���⡣������� " + cells[outPos].fei());
			outPos += 1; 
			if (outPos == cells.length) 
				outPos = 0;
			count--; 
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}