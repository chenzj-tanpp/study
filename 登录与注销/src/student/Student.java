package student;

import java.util.Scanner;//��ȡ�û�����

public class Student {
	int sex;// 1 �� ��2 Ů
	String number;// ѧ��
	String name;// ����
	Scanner sc = new Scanner(System.in);

	public int getsex() {
		return sex;
	}

	public void setsex(int sex) {
		this.sex = sex;
	}

	public String getnumber() {
		return number;
	}

	public void setnumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student add() {

		Student a = new Student();
		String b=sc.nextLine();
		
		return a;
	}
	
/*class fangfa {
	int num = 1;

	public void guanli() {

	}*/

}
