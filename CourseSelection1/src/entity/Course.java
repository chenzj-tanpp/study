package entity;
import java.io.Serializable;
import java.util.ArrayList;
public class Course implements IEntity ,Serializable{
	private String courseNo;
	private String courseName;
	private String courseGrade;
	private String courseTeacher;
	private ArrayList scMessage;
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher=courseTeacher;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	public  void setSCMessage(String StudentNo) {
		this.scMessage.add(StudentNo);
	}
	public ArrayList getSCMessage() {
		return scMessage;
	}
}
