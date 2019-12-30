package biz;

import java.util.*;

import dao.*;
import entity.*;

public class CourseBiz {
	CourseDao courseDao;
	private Course course;
	private HashMap<String, IEntity> courses;
	String string;

	// �½��γ�
	public void newCourse(String courseNo, String courseName, String courseTeacher, String courseGrade)
			throws Exception {
		course = new Course();
		course.setCourseNo(courseNo);
		course.setCourseName(courseName);
		course.setCourseTeacher(courseTeacher);
		course.setCourseGrade(courseGrade);
		courseDao = CourseDao.getInstance();
		courseDao.insert(course);

	}

	// ��ӡ�γ���Ϣ
	public void Print(String Id) throws Exception {
		courseDao = CourseDao.getInstance();
		course = new Course();
		course = (Course) courseDao.getEntity(Id);
		if (course == null) {
			System.out.println("�ÿγ̲�����");
		} else {
			System.out.println(course.getCourseNo() + '\t' + course.getCourseName() + '\t' + course.getCourseTeacher()
					+ '\t' + course.getCourseGrade());
		}

	}

	// ��ȡ���пγ���Ϣ
	public String getAll() throws Exception {
		courseDao = CourseDao.getInstance();
		courses = courseDao.getAllEntities();
		StringBuffer stb = new StringBuffer();
		Set keySet = courses.keySet();
		Iterator it = keySet.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			course = (Course) courses.get(key);
			stb.append(course.getCourseNo() + '\t' + course.getCourseName() + '\t' + course.getCourseTeacher() + '\t'
					+ course.getCourseGrade() + '\n');

		}
		return String.valueOf(stb);
	}

	// ɾ���γ���Ϣ,ɾ��ѡ��ÿε�ѧ����Ϣ
	public void delete(String Id) throws Exception {
		courseDao = CourseDao.getInstance();
		ArrayList studentNoList = courseDao.delete(Id);
		Iterator it = studentNoList.iterator();
		while (it.hasNext()) {
			this.string = (String) it.next();
			Student student = new StudentBiz().get(this.string);
			student.getSCMessage().remove(Id);
			new StudentBiz().insert(student);
		}

	}

	// ��ȡѡ��ÿε�����ѧ��ѧ��
	public ArrayList getAllStduent(String CourseNo) throws Exception {
		courseDao = CourseDao.getInstance();
		course = new Course();
		course = (Course) courseDao.getEntity(CourseNo);

		return course.getSCMessage();
	}
	//��ȡ�����γ̵���Ϣ
	public Course getCourse(String courseNo) throws Exception {
		courseDao = CourseDao.getInstance();
		course = (Course) courseDao.getEntity(courseNo);
		return course;
	}
	//����γ���Ϣ
	public void insert(Course course) throws Exception {
		courseDao = CourseDao.getInstance();
		courseDao.insert(course);
	}
}
