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
		System.out.println("����ѡ������'0'");
		// ������ѭ��������
		
			System.out.println("��������Ҫѡ��Ŀγ̵Ŀκţ�");
			String scCourseNo = sc.nextLine();
			System.out.println("������ѡ��ѧ����ѧ�ţ�");
			String scStudentNo=sc.nextLine();
			System.out.println("�������꼶��");
			String scGrade=sc.nextLine();
			SCBiz scbiz=new SCBiz();
			scbiz.newSC(scCourseNo, scStudentNo, scGrade);
			
			// if(==0)break;
	

	}
}
