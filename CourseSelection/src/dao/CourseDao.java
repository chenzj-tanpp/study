package dao;

import entity.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class CourseDao implements IDao {

	private static CourseDao instance;
	private HashMap<String, Course> courses = new HashMap<String, Course>();
	private Course course;

	private CourseDao() throws Exception {
		/*
		 * course = new Course(); course.setCourseNo("10001");
		 * course.setCourseName("高数"); course.setCourseTeacher("李");
		 * course.setCourseGrade("一年级"); courses.put(course.getCourseNo(), course);
		 * insert(course);
		 */

		FileInputStream fis = new FileInputStream("course.txt");
		ObjectInputStream oos = new ObjectInputStream(fis);
		courses = (HashMap<String, Course>) oos.readObject();
		oos.close();
		fis.close();

	}

	// 插入课程
	public void insert(IEntity entity) throws Exception {
		// TODO Auto-generated method stub
		Course ce = (Course) entity;
		courses.put(ce.getCourseNo(), ce);
		update();
	}

	// 删除课程信息
	@Override
	public HashMap<String,String> delete(String courseNo) throws Exception {
		HashMap<String,String> al=courses.get(courseNo).getSCMessage();
		courses.remove(courseNo);
		update();
		return al;
	}

	public static CourseDao getInstance() throws Exception {
		if (instance == null) {
			synchronized (CourseDao.class) {
				if (instance == null) {
					instance = new CourseDao();
					return instance;
				}
			}
		}
		return instance;
	}

	// 更新文件中的课程数据
	public void update() throws Exception {
		// TODO Auto-generated method stub
		FileOutputStream fis = new FileOutputStream("course.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		oos.writeObject(courses);
		oos.close();
		fis.close();
	}

	@Override
	public HashMap<String, entity.IEntity> getAllEntities() {
		HashMap<String, IEntity> temp = new HashMap<String, IEntity>();
		temp.putAll(courses);
		return temp;
	}

	// 返回所要查询的课程数据
	public IEntity getEntity(String Id) {
		course = new Course();
		course = (Course) courses.get(Id);
		
		return course;
	}

	// 添加选课

	public void add(String StudentNo, String CourseNo) throws Exception {
		course = (Course) courses.get(CourseNo);
		course.setSCMessage(StudentNo,CourseNo);
		update();
	}
}
