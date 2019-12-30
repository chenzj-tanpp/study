package biz;

import java.util.*;

import dao.*;
import entity.*;

public class CourseBiz {
	CourseDao courseDao;
	private Course course;
	private HashMap<String, IEntity> courses;
	String string;

	// 新建课程
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

	// 打印课程信息
	public void Print(String Id) throws Exception {
		courseDao = CourseDao.getInstance();
		course = new Course();
		course = (Course) courseDao.getEntity(Id);
		if (course == null) {
			System.out.println("该课程不存在");
		} else {
			System.out.println(course.getCourseNo() + '\t' + course.getCourseName() + '\t' + course.getCourseTeacher()
					+ '\t' + course.getCourseGrade());
		}

	}

	// 获取所有课程信息
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

	// 删除课程信息,删除选择该课的学生信息
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

	// 获取选择该课的所有学生学号
	public ArrayList getAllStduent(String CourseNo) throws Exception {
		courseDao = CourseDao.getInstance();
		course = new Course();
		course = (Course) courseDao.getEntity(CourseNo);

		return course.getSCMessage();
	}
	//获取单个课程的信息
	public Course getCourse(String courseNo) throws Exception {
		courseDao = CourseDao.getInstance();
		course = (Course) courseDao.getEntity(courseNo);
		return course;
	}
	//插入课程信息
	public void insert(Course course) throws Exception {
		courseDao = CourseDao.getInstance();
		courseDao.insert(course);
	}
}
