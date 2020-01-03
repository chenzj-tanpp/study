package biz;

import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import gui.Begin;
import gui.CourseGUI;
import gui.StudentGUI;
import java.util.*;

public class StudentBiz {
	 StudentDao studentDao;
	private Student student;
	private HashMap<String, IEntity> students;

	// 登录
	public void login(String studentNo, String studentPassword) throws Exception {
	
		if(studentNo.equalsIgnoreCase("123456")&&studentPassword.equalsIgnoreCase("123456")) {
				CourseGUI.Course();
}
		else {
			studentDao = StudentDao.getInstance();
			student = (Student) studentDao.getEntity(studentNo);
			if (student == null) {
				Begin.notUser();
				return;
			} else if (student.getStudentPassword().equals(studentPassword)) {
				Begin.success(student);

			} else {
				Begin.passNot();
			}
		}
		

	}

	// 注册，业务逻辑实现
	public void register(Student studentd,String secondPasswd) throws Exception {
		if (studentd.getStudentNo()!=null) {
			if (studentd.getStudentPassword().equals(secondPasswd)) {
				//System.out.println(studentd.getStudentAge());
				studentDao=StudentDao.getInstance();
				studentDao.insert(studentd);
				// System.out.println("注册成功！");
			} else {

			}
		} else {
			// System.out.println("该学号已经存在");
		}

	}

	// 删除 业务逻辑
	// 未找到用处
	public void delete(String studentNo) throws Exception {
		studentDao = StudentDao.getInstance();
		studentDao.delete(studentNo);

	}
	//获取单个学生的信息
	public Student get(String StudentNo) throws Exception {
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(StudentNo);
		return student;
	}
   //打印所有学生的信息
	public String getAll() throws Exception {
		studentDao = StudentDao.getInstance();
		students = studentDao.getAllEntities();
		String string=new String ();
		StringBuffer stringbuffer=new StringBuffer();
		  Set keySet=students.keySet();
		  
		  Iterator it=keySet.iterator(); 
		  while(it.hasNext()) 
		  { Object key=it.next();
		  student=(Student)students.get(key);
		  stringbuffer.append(student.getStudentNo()+'\t'+
		  student.getStudentName()+'\t'
		  +student.getStudentGender()+'\n'); }
		
		 System.out.println(String.valueOf(stringbuffer));
		 return String.valueOf(stringbuffer);
	}
	//判断该学生是否存在
	public Boolean is(String ID) throws Exception {
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(ID);
		if (student == null)
			return true;
		else
			return false;
	}
	//修改密码
	public void modifyPassword(String studentNo, String studentPassWd, String firstPassWd, String secondPassWd)
			throws Exception {
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student.getStudentPassword().equals(studentPassWd)) {
			if (firstPassWd.equals(secondPassWd)) {
				delete(studentNo);
				student.setStudentPassword(firstPassWd);
				studentDao.insert(student);
			}
		}
	}
	//获取该学生所选课程的课号
	public  HashMap<String,String> getAllCourse( String studentNo) throws Exception {
		studentDao = StudentDao.getInstance();
		student =new Student(); 
		student =(Student) studentDao.getEntity(studentNo);		
		return student.getSCMessage();
	}
	//插入学生信息
	public void insert(Student student) throws Exception {
		studentDao = StudentDao.getInstance();
		studentDao.insert(student);
	}
}