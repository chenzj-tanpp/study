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
			System.out.println("欢迎使用学生管理系统！");
			System.out.println("1.添加学生信息：");
			System.out.println("2.查看学生信息：");
			System.out.println("3.删除学生信息：");
			System.out.println("4.修改学生信息：");
			System.out.println("5.输入exit退出学生系统");
			System.out.println("请输入操作：");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Add();
				break;// 添加学生信息
			case 2:
				Show();
				break;// 查询学生信息
			case 3:
				Delete();
				break;// 删除学生信息
			case 4:
				Change();
				break;// 修改学生信息
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
		System.out.println("请输入学生基本信息");
		stu[number] = new Student();
		System.out.println("请输入学生ID");
		stu[number].setId(sc.next());
		System.out.println("请输入学生NAME");
		stu[number].setName(sc.next());
		System.out.println("请输入学生sex");
		stu[number].setsex(sc.next());
		number++;
		System.out.println("添加成功");
	}

	private static void Delete() {
		System.out.println("请输入要删除学生信息的ID");
		String a = sc.next();

		int z = Find(a);
		if (z == -1) {
			System.out.println("无此人信息！");
		} else {
			for (int j = z; j < number; j++) {
				stu[j] = stu[z + 1];

			}
			number--;

		}

	}

	private static void Change() {

		System.out.println("请输入要修改学生信息的ID");
		String t = sc.next();
		int i = Find(t);
// Scanner sc1=new Scanner(System.in);
		if (i > -1) {
			System.out.println("学生原信息为" + stu[i].getId() + "  " + stu[i].getName() + "  " + stu[i].getsex());
			System.out.println("请输入修改后的id：");
			Scanner a = new Scanner(System.in);
			stu[i].setId(a.next());
			System.out.println("请输入修改后的name：");
			Scanner b = new Scanner(System.in);
			stu[i].setName(b.next());
			System.out.println("请输入修改后的性别：");
			Scanner c = new Scanner(System.in);
			stu[i].setsex(c.next());
		} else {
			System.out.println("无此人信息！");

		}
	}

	private static void Exit() {
		System.out.println("感谢您的使用！");
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
		System.out.println("请输入要查询学生信息的ID");
		String t = sc.next();
		int d = Find(t);
		if (d > -1)
			System.out.println("学生信息为" + stu[d].getId() + "   " + stu[d].getName() + "  " + stu[d].getsex());
		else
			System.out.println("无此信息");
	}

	public static void Print() {
		for (int d = 0; d < number; d++) {
			System.out.println("学生信息为" + stu[d].getId() + "   " + stu[d].getName() + "  " + stu[d].getsex());
		}

	}
}
