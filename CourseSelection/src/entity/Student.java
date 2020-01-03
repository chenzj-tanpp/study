	package entity;
import java.io.Serializable;
import java.util.*;
@SuppressWarnings("serial")
public class Student implements IEntity , Serializable{
	private String studentNo;
	private String studentName;
	private String studentGender;
	private int studentAge;
	private String studentDepartment;
	private String studentPassword;
	private HashMap<String,String> scMessage=new HashMap<String,String>();
	
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public String getStudentDepartment() {
		return studentDepartment;
	}
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	public  void setSCMessage(String CourseNo,String StduentNo) {

		this.scMessage.put(CourseNo, StduentNo);
		
	}
	public HashMap<String,String> getSCMessage() {
		return scMessage;
	}
}
