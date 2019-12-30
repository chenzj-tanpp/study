package view;
import java.util.*;
import biz.*;
public class ModifyPasswordUI {
	public static void show() {	
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入学号：");
		String studentNo=sc.nextLine();
		StudentBiz studentBiz=new StudentBiz();
		System.out.println("请输入原密码：");
		String studentPassWd=sc.nextLine();
		System.out.println("请输入新密码：");
		String firstPasswd=sc.nextLine();
		System.out.println("请再次输入密码：");
		String secondPassWd=sc.nextLine();
		
	}
}
