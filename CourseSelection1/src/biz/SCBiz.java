package biz;

import dao.*;
import entity.*;
import java.util.*;

public class SCBiz {
	SCDao scDao;
	CourseDao courseDao;
	StudentDao studentDao;
	Course course;
	Student student;
	private SC sc;

	// 添加学生课程信息
	public void newSC(String scCourseNo, String scStudentNo, String scGrade) throws Exception {
		Student student = new StudentBiz().get(scStudentNo);
		student.setSCMessage(scCourseNo);
		new StudentBiz().insert(student);
		Course course = new CourseBiz().getCourse(scCourseNo);
		course.setSCMessage(scStudentNo);
		new CourseBiz().insert(course);
	}

	// 学生退课
	public void studentDelete(Student student, String CourseNo) throws Exception {
		student.getSCMessage().remove(CourseNo);
		new StudentBiz().insert(student);
		Course course = new CourseBiz().getCourse(CourseNo);
		course.getSCMessage().remove(student.getStudentNo());
		new CourseBiz().insert(course);
	}

	// 打印该课程的所有学生信息
	public String messageStudent(String CourseNo) throws Exception {
		ArrayList studentNoList = (ArrayList) new CourseBiz().getAllStduent(CourseNo);
		/*
		 * 从选课信息中获取选择该课程的学生 循环添加标签输出学生信息 设置退出按钮
		 */
		StringBuffer stringBuffer = new StringBuffer();
		Iterator it = studentNoList.iterator();
		while (it.hasNext()) {
			String studentNo = (String) it.next();
			student = new StudentBiz().get(studentNo);
			stringBuffer.append(student.getStudentNo() + '\t' + student.getStudentName() + '\t'
					+ student.getStudentDepartment() + '\t' + student.getStudentGender() + '\n');
		}
		return String.valueOf(stringBuffer);
	}

	// 打印该学生的所有课程信息
	public String messageCourse(String studentNo) throws Exception {
		ArrayList courseNoList = (ArrayList) new CourseBiz().getAllStduent(studentNo);
		/*
		 * 从选课信息中获取该学生所选课程 循环添加标签输出课程信息 设置退出按钮
		 */
		StringBuffer stringBuffer = new StringBuffer();
		Iterator it = courseNoList.iterator();
		while (it.hasNext()) {
			String courseNo = (String) it.next();
			course = new CourseBiz().getCourse(courseNo);
			stringBuffer.append(
					course.getCourseNo() + '\t' + course.getCourseName() + 
					'\t' + course.getCourseGrade() + '\n');
		}
		return String.valueOf(stringBuffer);
	}
}
