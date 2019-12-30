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

	// ���ѧ���γ���Ϣ
	public void newSC(String scCourseNo, String scStudentNo, String scGrade) throws Exception {
		Student student = new StudentBiz().get(scStudentNo);
		student.setSCMessage(scCourseNo);
		new StudentBiz().insert(student);
		Course course = new CourseBiz().getCourse(scCourseNo);
		course.setSCMessage(scStudentNo);
		new CourseBiz().insert(course);
	}

	// ѧ���˿�
	public void studentDelete(Student student, String CourseNo) throws Exception {
		student.getSCMessage().remove(CourseNo);
		new StudentBiz().insert(student);
		Course course = new CourseBiz().getCourse(CourseNo);
		course.getSCMessage().remove(student.getStudentNo());
		new CourseBiz().insert(course);
	}

	// ��ӡ�ÿγ̵�����ѧ����Ϣ
	public String messageStudent(String CourseNo) throws Exception {
		ArrayList studentNoList = (ArrayList) new CourseBiz().getAllStduent(CourseNo);
		/*
		 * ��ѡ����Ϣ�л�ȡѡ��ÿγ̵�ѧ�� ѭ����ӱ�ǩ���ѧ����Ϣ �����˳���ť
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

	// ��ӡ��ѧ�������пγ���Ϣ
	public String messageCourse(String studentNo) throws Exception {
		ArrayList courseNoList = (ArrayList) new CourseBiz().getAllStduent(studentNo);
		/*
		 * ��ѡ����Ϣ�л�ȡ��ѧ����ѡ�γ� ѭ����ӱ�ǩ����γ���Ϣ �����˳���ť
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
