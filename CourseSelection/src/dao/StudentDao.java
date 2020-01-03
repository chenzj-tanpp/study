package dao;

import entity.Course;
import entity.IEntity;
import entity.Student;
import java.util.*;
import java.io.*;

public class StudentDao implements IDao {

	private static StudentDao instance;
	private HashMap<String, Student> students = new HashMap<String, Student>();
	private Student student;

	private StudentDao() throws Exception {
		
		FileInputStream fis = new FileInputStream("student.txt");
		ObjectInputStream oos = new ObjectInputStream(fis);
		students = (HashMap<String, Student>) oos.readObject();
		oos.close();
		fis.close();
	}

	public static StudentDao getInstance() throws Exception {
		if (instance == null) {
			synchronized (StudentDao.class) {
				if (instance == null) {
					instance = new StudentDao();
					return instance;
				}
			}
		}
		return instance;
	}

	@Override
	public void insert(IEntity entity) throws Exception {
		Student st = (Student) entity;
		students.put(st.getStudentNo(), st);
		update();
	}

	@Override
	public HashMap<String,String> delete(String studentNo) throws Exception {
		student = students.get(studentNo);
		HashMap<String,String> al=student.getSCMessage();
		students.remove(studentNo);
		update();
		return al;
	}

	@Override
	public void update() throws Exception {
		FileOutputStream fis = new FileOutputStream("student.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		oos.writeObject(students);
		oos.close();
		fis.close();
	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		HashMap<String ,IEntity> temp= new HashMap<String ,IEntity>();
		temp.putAll(students);
		 return temp;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return (IEntity)students.get(Id);
	}
	public void add(String StudentNo,String CourseNo) throws Exception {
		student = (Student) students.get(StudentNo);
		student.setSCMessage(CourseNo,StudentNo);
		update();
	}
}
