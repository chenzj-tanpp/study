package test;

import student.*;
import java.util.Scanner;

public class Test {
	static Student[] stu = new Student[100];
	static int number = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = 0;
		while (true) {
			System.out.println("��ӭʹ��ѧ������ϵͳ��");
			System.out.println("1.���ѧ����Ϣ��");
			System.out.println("2.�鿴ѧ����Ϣ��");
			System.out.println("3.ɾ��ѧ����Ϣ��");
			System.out.println("4.�޸�ѧ����Ϣ��");
			System.out.println("5.����exit�˳�ѧ��ϵͳ");
			System.out.println("�����������");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Add();
				break;// ���ѧ����Ϣ
			case 2:
				Show();
				break;// ��ѯѧ����Ϣ
			case 3:
				Delete();
				break;// ɾ��ѧ����Ϣ
			case 4:
				Change();
				break;// �޸�ѧ����Ϣ
			case 5:
				Exit();
				break;
			case 6:
				Print();
				break;
			default:
				break;
			}

		}

	}

	private static void Add() {
		System.out.println("������ѧ��������Ϣ");
		stu[number] = new Student();
		System.out.println("������ѧ��ID");
		stu[number].setId(sc.next());
		System.out.println("������ѧ��NAME");
		stu[number].setName(sc.next());
		System.out.println("������ѧ��sex");
		stu[number].setsex(sc.next());
		number++;
		System.out.println("��ӳɹ�");
	}

	private static void Delete() {
		System.out.println("������Ҫɾ��ѧ����Ϣ��ID");
		String a = sc.next();

		int z = Find(a);
		if (z == -1) {
			System.out.println("�޴�����Ϣ��");
		} else {
			for (int j = z; j < number; j++) {
				stu[j] = stu[z + 1];

			}
			number--;

		}

	}

	private static void Change() {

		System.out.println("������Ҫ�޸�ѧ����Ϣ��ID");
		String t = sc.next();
		int i = Find(t);
// Scanner sc1=new Scanner(System.in);
		if (i > -1) {
			System.out.println("ѧ��ԭ��ϢΪ" + stu[i].getId() + "  " + stu[i].getName() + "  " + stu[i].getsex());
			System.out.println("�������޸ĺ��id��");
			Scanner a = new Scanner(System.in);
			stu[i].setId(a.next());
			System.out.println("�������޸ĺ��name��");
			Scanner b = new Scanner(System.in);
			stu[i].setName(b.next());
			System.out.println("�������޸ĺ���Ա�");
			Scanner c = new Scanner(System.in);
			stu[i].setsex(c.next());
		} else {
			System.out.println("�޴�����Ϣ��");

		}
	}

	private static void Exit() {
		System.out.println("��л����ʹ�ã�");
		System.gc();
		System.exit(0);
	}

	public static int Find(String a) {

		for (int i = 0; i < number; i++) {
			if (a.equalsIgnoreCase(stu[i].getId())) {
				return i;
			}

		}
		return -1;
	}

	public static void Show() {
		System.out.println("������Ҫ��ѯѧ����Ϣ��ID");
		String t = sc.next();
		int d = Find(t);
		if (d > -1)
			System.out.println("ѧ����ϢΪ" + stu[d].getId() + "   " + stu[d].getName() + "  " + stu[d].getsex());
		else
			System.out.println("�޴���Ϣ");
	}

	public static void Print() {
		for (int d = 0; d < number; d++) {
			System.out.println("ѧ����ϢΪ" + stu[d].getId() + "   " + stu[d].getName() + "  " + stu[d].getsex());
		}

	}
}
