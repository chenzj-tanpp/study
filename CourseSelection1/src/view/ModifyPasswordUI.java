package view;
import java.util.*;
import biz.*;
public class ModifyPasswordUI {
	public static void show() {	
		Scanner sc=new Scanner(System.in);
		System.out.println("������ѧ�ţ�");
		String studentNo=sc.nextLine();
		StudentBiz studentBiz=new StudentBiz();
		System.out.println("������ԭ���룺");
		String studentPassWd=sc.nextLine();
		System.out.println("�����������룺");
		String firstPasswd=sc.nextLine();
		System.out.println("���ٴ��������룺");
		String secondPassWd=sc.nextLine();
		
	}
}
