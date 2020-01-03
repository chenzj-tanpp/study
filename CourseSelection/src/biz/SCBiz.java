package biz;

import dao.*;
import entity.*;
import java.util.*;

public class SCBiz {
	CourseDao courseDao;
	StudentDao studentDao;
	Course course;
	static Student student;

	// 添加学生课程信息
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

	// 学生退课
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

	// 打印该课程的所有学生信息
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
		 * 从选课信息中获取选择该课程的学生 循环添加标签输出学生信息 设置退出按钮
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

	// 打印该学生的所有课程信息
	public static ArrayList messageCourse(String studentNo) throws Exception {
		HashMap<String,String> courseNo = (HashMap<String,String>) new StudentBiz().getAllCourse(studentNo);
		if(courseNo.keySet()==null) {
			return null;
		}
		/*
		 * 从选课信息中获取该学生所选课程 循环添加标签输出课程信息 设置退出按钮
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
