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
	public  boolean is (String courseNo)throws Exception {
		courseDao = CourseDao.getInstance();
		course=(Course)courseDao.getEntity(courseNo);
		if(course==null)
		   return false;
		else 
			return true;
		};
	

	// ɾ���γ���Ϣ,ɾ��ѡ��ÿε�ѧ����Ϣ
	public void delete(String Id) throws Exception {
		
		if(is(Id)) {
			HashMap<String,String> studentNoList = courseDao.delete(Id);
			Set keyset=studentNoList .keySet();
			Iterator it = keyset.iterator();
			while (it.hasNext()) {
				this.string = (String) it.next();
				Student student = new StudentBiz().get(this.string);
				student.getSCMessage().remove(Id);
				new StudentBiz().insert(student);
			}
		}
		

	}

	// ��ȡѡ��ÿε�����ѧ��ѧ��
	public HashMap<String,String> getAllStduent(String CourseNo) throws Exception {
		courseDao = CourseDao.getInstance();
//		course = new Course();
		course = (Course) courseDao.getEntity(CourseNo);
		if(course!=null) {
			return course.getSCMessage();
		}
		else return null;
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
