package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.*;
import biz.*;
import dao.*;
import entity.*;

//�γ̹���ҳ��
public class CourseGUI {
	public static void Course() {
		JFrame frame = new JFrame("�γ̹������");
		frame.setBounds(300, 300, 800, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 800, 100);
		frame.add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(Color.red);
		JLabel label = new JLabel("��ӭ ����Ա��ʦ");
		label.setBounds(0, 0, 200, 100);
		label.setFont(new Font("����", Font.BOLD, 16));
		panel1.add(label);
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 100, 800, 100);
		frame.add(panel2);
		panel2.setBackground(Color.yellow);
		// panel2.setLayout(null);
		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 300, 800, 100);
		frame.add(panel3);
		panel3.setBackground(Color.green);
//
		JButton jbu3 = new JButton("�鿴ѡ�ÿγ̵�ѧ��");
		jbu3.setBounds(350, 115, 100, 25);
		panel2.add(jbu3);
		jbu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					check();
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		JButton jbu5 = new JButton("�˳���¼");
		jbu5.setBounds(450, 115, 100, 25);
		jbu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Begin.begin();
			}
		});
		panel2.add(jbu5);
		JButton jbu4 = new JButton("ɾ���γ�");
		jbu4.setBounds(350, 400, 150, 25);
		panel3.add(jbu4);
		jbu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				delete();
			}
		});
		JButton jbu1 = new JButton("��ӿγ�");
		jbu1.setBounds(350, 310, 150, 25);
		jbu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				newCourse();

//				
			}
		});
		panel3.add(jbu1);
		JButton jbu6 = new JButton("�޸Ŀγ�");
		jbu6.setBounds(350, 460, 150, 25);
		panel3.add(jbu6);
		jbu6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				modify();
//				
			}
		});
		panel3.setLayout(null);
		//
	}

	public static void newCourse() {
		JFrame frame = new JFrame("�½��γ�");
		frame.setBackground(Color.green);
		frame.setBounds(500, 500, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		JLabel jl1 = new JLabel("�γ̺ţ�");
		jl1.setBounds(200, 180, 80, 25);
		panel.add(jl1);
		JTextField text1 = new JTextField();
		text1.setBounds(300, 180, 100, 25);
		panel.add(text1);
		JLabel jl2 = new JLabel("�γ����ƣ�");
		jl2.setBounds(200, 210, 80, 25);
		panel.add(jl2);
		JTextField text2 = new JTextField();
		text2.setBounds(300, 210, 100, 25);
		panel.add(text2);
		JLabel jl3 = new JLabel("�ον�ʦ��");
		jl3.setBounds(200, 240, 80, 25);
		panel.add(jl3);
		JTextField text3 = new JTextField();
		text3.setBounds(300, 240, 100, 25);
		panel.add(text3);
		JLabel jl4 = new JLabel("�����꼶��");
		jl4.setBounds(200, 270, 80, 25);
		panel.add(jl4);
		JTextField text4 = new JTextField();
		text4.setBounds(300, 270, 100, 25);
		panel.add(text4);
		JButton jbu = new JButton("�½�");
		jbu.setBackground(Color.green);
		jbu.setBounds(280, 300, 100, 30);
		panel.add(jbu);
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseNo = text1.getText();
				String courseName = text2.getText();
				String courseTeacher = text3.getText();
				String courseGrade = text4.getText();
				CourseBiz cb = new CourseBiz();
				try {
					cb.newCourse(courseNo, courseName, courseTeacher, courseGrade);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.setVisible(false);
				CourseGUI.Course();
			}
		});
	}

	public static void delete() {
		JFrame frame = new JFrame("ɾ���γ�");
		frame.setBackground(Color.green);
		frame.setBounds(500, 500, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		JLabel jl1 = new JLabel("�γ̺ţ�");
		jl1.setBounds(180, 150, 80, 25);
		panel.add(jl1);
		JTextField text1 = new JTextField();
		text1.setBounds(260, 150, 100, 25);
		panel.add(text1);
		JButton jbu = new JButton("ɾ��");
		jbu.setBackground(Color.green);
		jbu.setBounds(250, 180, 100, 30);
		panel.add(jbu);
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseNo = text1.getText();

				CourseBiz cb = new CourseBiz();
				try {
					cb.delete(courseNo);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.setVisible(false);
				Course();
			}
		});
	}

	public static void modify() {
		JFrame frame = new JFrame("�޸Ŀγ�");
		frame.setBackground(Color.green);
		frame.setBounds(500, 500, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		JLabel jl1 = new JLabel("�γ̺ţ�");
		jl1.setBounds(200, 180, 80, 25);
		panel.add(jl1);
		JTextField text1 = new JTextField();
		text1.setBounds(300, 180, 100, 25);
		panel.add(text1);
		JLabel jl2 = new JLabel("�γ����ƣ�");
		jl2.setBounds(200, 210, 80, 25);
		panel.add(jl2);
		JTextField text2 = new JTextField();
		text2.setBounds(300, 210, 100, 25);
		panel.add(text2);
		JLabel jl3 = new JLabel("�ον�ʦ��");
		jl3.setBounds(200, 240, 80, 25);
		panel.add(jl3);
		JTextField text3 = new JTextField();
		text3.setBounds(300, 240, 100, 25);
		panel.add(text3);
		JLabel jl4 = new JLabel("�����꼶��");
		jl4.setBounds(200, 270, 80, 25);
		panel.add(jl4);
		JTextField text4 = new JTextField();
		text4.setBounds(300, 270, 100, 25);
		panel.add(text4);
		JButton jbu = new JButton("�޸�");
		jbu.setBackground(Color.green);
		jbu.setBounds(280, 300, 100, 30);
		panel.add(jbu);
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseNo = text1.getText();
				String courseName = text2.getText();
				String courseTeacher = text3.getText();
				String courseGrade = text4.getText();
				CourseBiz cb = new CourseBiz();
				try {
					cb.newCourse(courseNo, courseName, courseTeacher, courseGrade);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.setVisible(false);
				Course();
			}
		});
	}

	public static void check() throws Exception {
		JFrame frame1 = new JFrame("�鿴ѡ��ѧ��");
		frame1.setBounds(300, 300, 800, 800);
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 100);
		frame1.add(panel);
		panel.setLayout(null);
		JLabel userLabel = new JLabel("������Ҫ�鿴�Ŀκţ�");
		userLabel.setBackground(Color.blue);
		userLabel.setBounds(100, 190, 150, 25);
		panel.add(userLabel);
		// �����ı��������û�����
		JTextField text = new JTextField(20);
		text.setBounds(260, 190, 165, 25);
		panel.add(text);
		JButton jbu = new JButton("�鿴");
		jbu.setBounds(450, 190, 80, 25);
		jbu.setBackground(Color.green);
		panel.add(jbu);
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseNo = text.getText();
				if (courseNo.equals("")) {
					CourseGUI.Course();
					frame1.setVisible(false);
				} else {
					try {
						new StudentMessageGUI(courseNo);
						frame1.setVisible(false);
					} catch (Exception e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}
			}
		});
		JButton jbu1 = new JButton("�˳�");
		jbu1.setBounds(550, 190, 80, 25);
		jbu1.setBackground(Color.green);
		panel.add(jbu1);
		jbu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseGUI.Course();
				frame1.setVisible(false);
			}
		});
	}

	public static JScrollPane placeStudentJSc(JScrollPane jsc, String courseNo) throws Exception {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(790, 300));
		panel.setLayout(null);
		jsc.setViewportView(panel);
		int y = 0;
		StudentDao studentDao = StudentDao.getInstance();
		HashMap<String, IEntity> students = studentDao.getAllEntities();
		ArrayList courseNoList = new ArrayList();
		courseNoList = new SCBiz().messageStudent(courseNo);
		if (courseNoList != null && courseNoList.size() != 0) {
			Iterator it = courseNoList.iterator();
			while (it.hasNext()) {
				String studentNo = (String) it.next();
				Student student = (Student) students.get(studentNo);
				JLabel label = new JLabel("ѧ�ţ� " + student.getStudentNo() + " ������ " + student.getStudentName()
						+ "  Ժϵ �� " + student.getStudentDepartment());
				label.setBounds(0, y, 800, 25);
				y += 30;
				panel.add(label);
			}
		}

		return jsc;
	}

}

class StudentMessageGUI {
	//weizhi
	public StudentMessageGUI(String courseNo) throws Exception {
		JFrame frameStudent = new JFrame();
		frameStudent.setBounds(0, 0, 500, 400);
		JScrollPane jsc = new JScrollPane();
		jsc.setBounds(0, 0, 500, 300);
		jsc.setBackground(Color.white);
		jsc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			jsc = CourseGUI.placeStudentJSc(jsc, courseNo);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
//		JPanel panelJsc=new JPanel();
//		panelJsc.add(jsc);
//		panelJsc.setBounds(0, 101, 500, 300);
		frameStudent.add(jsc);
		frameStudent.setVisible(true);
		JButton jbu=new JButton("�˳��鿴");
		JPanel panel=new JPanel();
		jbu.setBounds(220, 350, 80, 30);
		panel.setBounds(0, 301, 500, 100);
		
		frameStudent.add(panel);		
		panel.add(jbu);
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CourseGUI.check();
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				frameStudent.setVisible(false);
			}
		});
		
	}
}