import java.util.Scanner;

import student.*;

public class Main {
	static int num = 0;
	static String a ;
	static Scanner sc = new Scanner(System.in);
	static Student[] stu = new Student[20];
	public static void main(String args[]) {
		
		Student a = new Student();
		stu[num] = a.add();	
		Modify() ;
	}

	public static int Find() {
		a= sc.next();
		for (int i = 0; i < 3; i++) {
			if (stu[i].getName().equals(a)) {
				return i;
			}
			// else System.out.println("没有该学生");
		}
		return -1; 
	}
	public static void Show(int i) {
		
		System.out.println(stu[i].getName() +"  " +stu[i].getnumber() +"  " +stu[i].getsex());
		System.out.println(";");

	}
	public static void Modify() {
		int i=Find();
	
		StringBuffer st=new StringBuffer();
		st.append(sc.next());
		stu[i].setName(st.toString());
		st.delete(0, st.length());
		stu[i].setsex(sc.nextInt());
		st.append(sc.next());
		stu[i].setnumber(st.toString());
		Show(i);
	}
	public static void Del() {
		int i=Find();
	}
	
}