package view;

import java.util.*;
import biz.*;
import entity.*;

public class NewCourseUI {
	static Scanner sc = new Scanner(System.in);

	public static void show() throws Exception {

		System.out.println("请输入新建的课程的课号：");
		String courseNo = sc.nextLine();
		System.out.println("请输入新建的课程名称：");
		String courseName = sc.nextLine();
		System.out.println("请输入新建的课程任教教师：");
		String courseTeacher = sc.nextLine();
		System.out.println("请输入新建课程适用年级：");
		String courseGrade = sc.nextLine();
		CourseBiz cb = new CourseBiz();
		cb.newCourse(courseNo, courseName, courseTeacher, courseGrade);
	}

	public static void get() throws Exception {
		System.out.println("请输入要查询课程信息的课号：");
		String sourseNo = sc.nextLine();
		CourseBiz cb = new CourseBiz();
		cb.Print(sourseNo);

	}
	public static void delete() throws Exception {
		System.out.println("请输入要删除课程的课程号：");
		String Id =sc.nextLine();
		CourseBiz cb=new CourseBiz();	
		cb.delete(Id);
	}
	public static void getAll() throws Exception {
		CourseBiz cb = new CourseBiz();
		cb.getAll();
	}
}
