package view;

import java.util.*;
import biz.*;
import entity.*;
import dao.*;

public class CourseSelection {
	static CourseDao courseDao;
	static Course course;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 //NewCourseUI.show();
		//NewCourseUI.get();
		// NewCourseUI.getAll();
		// NewCourseUI.delete();
		show();
		//Student.getAll();
		//MainUI.show();
		//Student.delete();
		 //RegisterUI.show();
		 //LoginUI.show();
	}

	public static void show() throws Exception {
		Scanner sc = new Scanner(System.in);
		NewCourseUI.getAll();
		System.out.println("结束选课输入'0'");
		// 无跳出循环的条件
		
			System.out.println("请输入你要选择的课程的课号：");
			String scCourseNo = sc.nextLine();
			System.out.println("请输入选课学生的学号：");
			String scStudentNo=sc.nextLine();
			System.out.println("请输入年级：");
			String scGrade=sc.nextLine();
			SCBiz scbiz=new SCBiz();
			scbiz.newSC(scCourseNo, scStudentNo, scGrade);
			
			// if(==0)break;
	

	}
}
