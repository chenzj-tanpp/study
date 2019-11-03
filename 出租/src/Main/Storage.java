package Main;

import car.car;
import factory.factory;
import xml.ReadXMLUitilcar;

class Input implements Runnable { // 输入线程类
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

	public void chu() {//初始化数组的方法
		factory carFactroy = (factory) ReadXMLUitilcar.getBrandName();

		 int i;
		for (i = 0; i < 10; i++) {
			cells[i] = carFactroy.proudctCar();
			
		}

	}

	private int inPos=0, outPos=0, count; // inPos存入时数组下标，outPos取出时数组下标,存入或者取出数据的数量

	public synchronized void put() {// 入库
		try {
		
			while (count == cells.length) {
				this.wait();
			}

			System.out.println("车辆" + inPos + "，" + cells[inPos].toString() + "入库");
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
			System.out.println("车辆" + outPos + "," + cells[outPos].toString() + " 出库。计算费率 " + cells[outPos].fei());
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