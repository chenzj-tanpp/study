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

	// ��¼
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

	// ע�ᣬҵ���߼�ʵ��
	public void register(Student studentd,String secondPasswd) throws Exception {
		if (studentd.getStudentNo()!=null) {
			if (studentd.getStudentPassword().equals(secondPasswd)) {
				//System.out.println(studentd.getStudentAge());
				studentDao=StudentDao.getInstance();
				studentDao.insert(studentd);
				// System.out.println("ע��ɹ���");
			} else {

			}
		} else {
			// System.out.println("��ѧ���Ѿ�����");
		}

	}

	// ɾ�� ҵ���߼�
	// δ�ҵ��ô�
	public void delete(String studentNo) throws Exception {
		studentDao = StudentDao.getInstance();
		studentDao.delete(studentNo);

	}
	//��ȡ����ѧ������Ϣ
	public Student get(String StudentNo) throws Exception {
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(StudentNo);
		return student;
	}
   //��ӡ����ѧ������Ϣ
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
	//�жϸ�ѧ���Ƿ����
	public Boolean is(String ID) throws Exception {
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(ID);
		if (student == null)
			return true;
		else
			return false;
	}
	//�޸�����
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
	//��ȡ��ѧ����ѡ�γ̵Ŀκ�
	public  HashMap<String,String> getAllCourse( String studentNo) throws Exception {
		studentDao = StudentDao.getInstance();
		student =new Student(); 
		student =(Student) studentDao.getEntity(studentNo);		
		return student.getSCMessage();
	}
	//����ѧ����Ϣ
	public void insert(Student student) throws Exception {
		studentDao = StudentDao.getInstance();
		studentDao.insert(student);
	}
}