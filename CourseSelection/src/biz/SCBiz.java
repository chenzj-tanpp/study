package biz;

import dao.*;
import entity.*;
import java.util.*;

public class SCBiz {
	CourseDao courseDao;
	StudentDao studentDao;
	Course course;
	static Student student;

	// ���ѧ���γ���Ϣ
	public static void newSC(String scCourseNo, String scStudentNo) throws Exception {
		Student student = new StudentBiz().get(scStudentNo);
		student.setSCMessage(scCourseNo,scStudentNo);		
		new StudentBiz().insert(student);
		CourseBiz courseBiz=new CourseBiz();
		
		Course course = courseBiz.getCourse(scCourseNo);
		if(course!=null) {
			course.setSCMessage(scStudentNo,scCourseNo);
			courseBiz.insert(course);
		}
		
	}

	// ѧ���˿�
	public static void studentDelete(Student student, String CourseNo) throws Exception {
		student.getSCMessage().remove(CourseNo);
		new StudentBiz().insert(student);
		 CourseBiz courseBiz=new CourseBiz();
		Course course = courseBiz.getCourse(CourseNo);
		HashMap<String,String> al=new HashMap<String,String>();
		if(course!=null) {
			al=course.getSCMessage();
			String string=student.getStudentNo();
			al.remove(string);
			courseBiz.insert(course);
		}
		
	}

	// ��ӡ�ÿγ̵�����ѧ����Ϣ
	public static ArrayList messageStudent(String CourseNo) throws Exception {
		
		HashMap<String,String> studentNos = (HashMap<String,String>) new CourseBiz().getAllStduent(CourseNo);
		if(studentNos!=null) {
			ArrayList al=new ArrayList ();
			Set keyset=studentNos.keySet();
			Iterator it = keyset.iterator();
			while (it.hasNext()) {
				String courseNo = (String) it.next();
				al.add(courseNo);
			}
			return al;
		}
		else 
			{
			return null;
			}
		/*
		 * ��ѡ����Ϣ�л�ȡѡ��ÿγ̵�ѧ�� ѭ����ӱ�ǩ���ѧ����Ϣ �����˳���ť
		 */
		/*StringBuffer stringBuffer = new StringBuffer();
		Iterator it = studentNoList.iterator();
		while (it.hasNext()) {
			String studentNo = (String) it.next();
			student = new StudentBiz().get(studentNo);
			stringBuffer.append(student.getStudentNo() + '\t' + student.getStudentName() + '\t'
					+ student.getStudentDepartment() + '\t' + student.getStudentGender() + '\n');
		}
		return String.valueOf(stringBuffer);*/
	}

	// ��ӡ��ѧ�������пγ���Ϣ
	public static ArrayList messageCourse(String studentNo) throws Exception {
		HashMap<String,String> courseNo = (HashMap<String,String>) new StudentBiz().getAllCourse(studentNo);
		if(courseNo.keySet()==null) {
			return null;
		}
		/*
		 * ��ѡ����Ϣ�л�ȡ��ѧ����ѡ�γ� ѭ����ӱ�ǩ����γ���Ϣ �����˳���ť
		 */					
		else {
			ArrayList al=new ArrayList ();
			Set keyset=courseNo.keySet();
			Iterator it = keyset.iterator();
			while (it.hasNext()) {
				String studentNos = (String) it.next();
				al.add(studentNos);
			}
			return al;
		}
		
	}
}
