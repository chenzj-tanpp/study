package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import biz.*;
import dao.CourseDao;
import entity.*;
//ѧ���������

public class StudentGUI {
	public static void student(Student student) {
		JFrame frame = new JFrame("ѧ������");
		frame.setBounds(300, 300, 800, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 800, 100);
		frame.add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(Color.red);
		JLabel label = new JLabel("��ӭ " + student.getStudentName() + " ͬѧ");
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

		JButton jbu2 = new JButton("�޸�����");
		jbu2.setBounds(250, 115, 100, 25);
		panel2.add(jbu2);
		jbu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ModifyPasswdGUI.modifyPasswd(student);

			}
		});
		JButton jbu3 = new JButton("�鿴��ѡ�γ�");
		jbu3.setBounds(350, 115, 100, 25);
		panel2.add(jbu3);
		jbu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					chakan(student);
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
//				
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
		JButton jbu4 = new JButton("��ѡ");
		jbu4.setBounds(350, 400, 150, 25);
		panel3.add(jbu4);
		jbu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					tuixuan(student);
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
//				
			}
		});
		JButton jbu1 = new JButton("ѡ��");
		jbu1.setBounds(350, 310, 150, 25);
		jbu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					takeclass(student);
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
//				
			}
		});
		panel3.add(jbu1);
		JButton jbu6 = new JButton("�޸ĸ�����Ϣ");
		jbu6.setBounds(350, 460, 150, 25);
		panel3.add(jbu6);
		jbu6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				modfiy(student);
				
//				
			}
		});
		panel3.setLayout(null);
		//
	}

	public static void modfiy(Student student) {
		JFrame frame = new JFrame("�޸���Ϣ");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
		panel.setLayout(null);
		JLabel user1 = new JLabel("������");
		user1.setBounds(100, 30, 80, 25);
		panel.add(user1);
		JTextField Text1 = new JTextField(20);
		Text1.setBounds(180, 30, 165, 25);
		panel.add(Text1);
		JLabel user2 = new JLabel("���䣺");
		user2.setBounds(100, 60, 80, 25);
		panel.add(user2);
		JTextField Text2 = new JTextField(20);
		Text2.setBounds(180, 60, 165, 25);
		panel.add(Text2);
		JLabel user3 = new JLabel("Ժϵ��");
		user3.setBounds(100, 90, 80, 25);
		panel.add(user3);
		JTextField Text3 = new JTextField(20);
		Text3.setBounds(180, 90, 165, 25);
		panel.add(Text3);
		JButton bun1 = new JButton("ȷ��");
		bun1.setBounds(160, 120, 100, 35);
		panel.add(bun1);
		bun1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				student.setStudentName(Text1.getText());
				student.setStudentAge(Integer.valueOf(Text2.getText()));
				student.setStudentDepartment(Text3.getText());
				StudentBiz studentBiz = new StudentBiz();
				try {
					studentBiz.register(student, student.getStudentPassword());

				} catch (Exception e1) {
					e1.printStackTrace();

				}
				frame.setVisible(false);
				StudentGUI.student(student);

			}

		});
		JButton bun2 = new JButton("�˳�");
		bun2.setBounds(240, 120, 100, 35);
		panel.add(bun2);
		bun2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				StudentGUI.student(student);
			}
		});
	}

	public static void takeclass(Student student) throws Exception {
		JFrame frame = new JFrame("ѡ�ν���");
		frame.setBounds(300, 300, 800, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 800, 100);
		frame.add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(Color.red);
		JLabel label1 = new JLabel("��ӭ " + student.getStudentName() + " ͬѧ");
		label1.setBounds(0, 0, 200, 100);
		label1.setFont(new Font("����", Font.BOLD, 16));
		panel1.add(label1);
		JScrollPane jsc = new JScrollPane();
		jsc.setBounds(0, 101, 800, 300);
		jsc.setBackground(Color.white);
		jsc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.add(jsc);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(790, 300));
		panel.setLayout(null);
		jsc.setViewportView(panel);
		int y = 0;
		CourseDao courseDao = CourseDao.getInstance();
		HashMap<String, IEntity> courses = courseDao.getAllEntities();
		Set keySet = courses.keySet();
		Iterator it = keySet.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Course course = (Course) courses.get(key);
			JLabel label = new JLabel("�κţ� " + course.getCourseNo() + " �γ����ƣ� " + course.getCourseName() + "  �����꼶 �� "
					+ course.getCourseGrade() + " �ον�ʦ �� " + course.getCourseTeacher());
			label.setBounds(0, y, 800, 25);
			y += 30;
			panel.add(label);
		}

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 401, 800, 100);
		panel2.setBorder(null);
		panel2.setBackground(Color.green);
		JButton jbu3 = new JButton("�˳�ѡ��");
		jbu3.setBounds(700, 450, 80, 25);
		jbu3.setBackground(Color.red);
		jbu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentGUI.student(student);
				frame.setVisible(false);
			}
		});
		panel2.add(jbu3);
		JLabel userLabel = new JLabel("������Ҫѡ��Ŀκţ�");
		userLabel.setBackground(Color.blue);
		userLabel.setBounds(50, 450, 80, 25);
		panel2.add(userLabel);
		// �����ı��������û�����
		JTextField text = new JTextField(20);
		text.setBounds(150, 450, 165, 25);
		panel2.add(text);
		JButton jbu4 = new JButton("�ύѡ��");
		jbu4.setBounds(600, 450, 80, 25);
		jbu4.setBackground(Color.red);
		jbu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseNo = text.getText();
				if (courseNo.equals("")) {
					StudentGUI.student(student);
					frame.setVisible(false);
				} else {
					try {
						String studentNo = student.getStudentNo();
						SCBiz.newSC(courseNo, studentNo);
						frame.setVisible(false);
						/**/ takeclass(student);
					} catch (Exception e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}
			}
		});
		panel2.add(jbu4);
		frame.add(panel2);
		JScrollPane jsc2 = new JScrollPane();
		jsc2.setBounds(0, 501, 800, 300);
		jsc2.setBackground(Color.white);
		jsc2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsc2 = placeCourseJSc(jsc2, student.getStudentNo());
		frame.add(jsc2);
	}

	public static JScrollPane placeCourseJSc(JScrollPane jsc, String studentNo) throws Exception {

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(790, 300));
		panel.setLayout(null);
		jsc.setViewportView(panel);
		int y = 0;
		CourseDao courseDao = CourseDao.getInstance();
		HashMap<String, IEntity> courses = courseDao.getAllEntities();
		ArrayList courseNoList = (ArrayList) new SCBiz().messageCourse(studentNo);

		if (courseNoList != null) {
			Iterator it = courseNoList.iterator();
			while (it.hasNext()) {
				String courseNo = (String) it.next();
				Course course = (Course) courses.get(courseNo);
				JLabel label = new JLabel("�κţ� " + course.getCourseNo() + " �γ����ƣ� " + course.getCourseName()
						+ "  �����꼶 �� " + course.getCourseGrade() + " �ον�ʦ �� " + course.getCourseTeacher());

				label.setBounds(0, y, 800, 25);
				y += 30;
				panel.add(label);
			}
		}

		return jsc;
	}

	public static void tuixuan(Student student) throws Exception {
		JFrame frame = new JFrame("�˿ν���");
		frame.setBounds(300, 300, 800, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane jsc = new JScrollPane();
		jsc.setBounds(0, 101, 800, 300);
		jsc.setBackground(Color.white);
		jsc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsc = placeCourseJSc(jsc, student.getStudentNo());
		frame.add(jsc);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 100);
		JLabel uLabel = new JLabel("��ѡ�γ�");
		uLabel.setBackground(Color.blue);
		uLabel.setBounds(350, 50, 80, 25);
		panel.add(uLabel);
		frame.add(panel);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 401, 800, 100);

		JButton jbu = new JButton("�˳�");
		jbu.setBounds(720, 450, 80, 25);
		jbu.setBackground(Color.green);
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentGUI.student(student);
				frame.setVisible(false);
			}
		});
		panel1.add(jbu);
		JLabel Label = new JLabel("�˳��Ŀγ̵Ŀκ�");
		Label.setBackground(Color.blue);
		Label.setBounds(0, 450, 80, 25);
		panel1.add(Label);
		JTextField text = new JTextField(20);
		text.setBounds(100, 450, 165, 25);
		panel1.add(text);

		JButton jbu1 = new JButton("�ύ");
		jbu1.setBounds(600, 450, 80, 25);
		jbu1.setBackground(Color.green);
		jbu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				String courseNo = text.getText();
				if (courseNo.equals("")) {
					StudentGUI.student(student);
				} else {
					try {
						SCBiz scbiz = new SCBiz();
						scbiz.studentDelete(student, courseNo);
						StudentGUI.tuixuan(student);

					} catch (Exception e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}
			}
		});
		panel1.add(jbu1);
		frame.add(panel1);

	}

	public static void chakan(Student student) throws Exception {
		JFrame frame = new JFrame("�鿴��ѡ�γ̽���");
		frame.setBounds(300, 300, 500, 400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 100);
		JLabel userLabel = new JLabel("��ѡ�γ�");
		userLabel.setBackground(Color.blue);
		userLabel.setBounds(350, 50, 80, 25);
		panel.add(userLabel);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane jsc = new JScrollPane();
		jsc.setBounds(0, 101, 500, 300);
		jsc.setBackground(Color.white);
		jsc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsc = placeCourseJSc(jsc, student.getStudentNo());
		frame.add(jsc);
		JButton jbu = new JButton("�˳�");
		jbu.setBounds(350, 80, 80, 25);
		jbu.setBackground(Color.red);
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentGUI.student(student);
				frame.setVisible(false);
			}
		});
		panel.add(jbu);
	}

	/*public static void studentmessage(Student student) throws Exception {
		JFrame studentmessageframe = new JFrame();
		studentmessageframe.setVisible(true);
		studentmessageframe.setBounds(300, 500, 500, 400);
		// studentmessageframe.add(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 300);
		studentmessageframe.add(panel);
		
		JTextArea textArea = new JTextArea("        ѧ�ţ�" + student.getStudentNo() + '\n' + "        ������"
				+ student.getStudentName() + '\n' + "        ���䣺" + student.getStudentAge() + '\n' + "����Ժϵ��"
				+ student.getStudentDepartment() + '\n');
		panel.add(textArea);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 300, 500, 100);
		JButton jbu = new JButton("�˳�");
		jbu.setBounds(220, 450, 80, 50);
		panel1.add(jbu);
		studentmessageframe.add(panel1);
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentGUI.student(student);
				studentmessageframe.setVisible(false);
			}
		});
	}*/
}
