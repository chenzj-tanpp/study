package view;

import java.util.*;
import biz.*;
import entity.*;

public class NewCourseUI {
	static Scanner sc = new Scanner(System.in);

	public static void show() throws Exception {

		System.out.println("�������½��Ŀγ̵Ŀκţ�");
		String courseNo = sc.nextLine();
		System.out.println("�������½��Ŀγ����ƣ�");
		String courseName = sc.nextLine();
		System.out.println("�������½��Ŀγ��ν̽�ʦ��");
		String courseTeacher = sc.nextLine();
		System.out.println("�������½��γ������꼶��");
		String courseGrade = sc.nextLine();
		CourseBiz cb = new CourseBiz();
		cb.newCourse(courseNo, courseName, courseTeacher, courseGrade);
	}

	public static void get() throws Exception {
		System.out.println("������Ҫ��ѯ�γ���Ϣ�Ŀκţ�");
		String sourseNo = sc.nextLine();
		CourseBiz cb = new CourseBiz();
		cb.Print(sourseNo);

	}
	public static void delete() throws Exception {
		System.out.println("������Ҫɾ���γ̵Ŀγ̺ţ�");
		String Id =sc.nextLine();
		CourseBiz cb=new CourseBiz();	
		cb.delete(Id);
	}
	public static void getAll() throws Exception {
		CourseBiz cb = new CourseBiz();
		cb.getAll();
	}
}
