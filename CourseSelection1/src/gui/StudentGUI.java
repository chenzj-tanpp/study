package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import biz.CourseBiz;
import biz.StudentBiz;
import entity.*;
//学生服务界面

public class StudentGUI {
	public static void student(Student student) {
		JFrame frame = new JFrame("学生界面");
		frame.setBounds(300, 300, 800, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 800, 100);
		frame.add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(Color.red);
		JLabel label = new JLabel("欢迎 " + student.getStudentName() + " 同学");
		label.setBounds(0, 0, 200, 100);
		label.setFont(new Font("楷体", Font.BOLD, 16));
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

		JButton jbu2 = new JButton("修改密码");
		jbu2.setBounds(250, 115, 100, 25);
		panel2.add(jbu2);
		jbu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ModifyPasswdGUI.modifyPasswd(student);

			}
		});
		JButton jbu3 = new JButton("查看所选课程");
		jbu3.setBounds(350, 115, 100, 25);
		panel2.add(jbu3);
		jbu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				
			}
		});
		JButton jbu5 = new JButton("退出登录");
		jbu5.setBounds(450, 115, 100, 25);
		jbu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Begin.begin();
			}
		});
		panel2.add(jbu5);
		JButton jbu4 = new JButton("退选");
		jbu4.setBounds(350, 400, 150, 25);
		panel3.add(jbu4);
		jbu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				
			}
		});
		JButton jbu1 = new JButton("选课");
		jbu1.setBounds(350, 310, 150, 25);
		jbu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					takeclass(student);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
//				
			}
		});
		panel3.add(jbu1);
		JButton jbu6 = new JButton("修改个人信息");
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
		JFrame frame = new JFrame("修改信息");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
		panel.setLayout(null);
		JLabel user1 = new JLabel("姓名：");
		user1.setBounds(100, 30, 80, 25);
		panel.add(user1);
		JTextField Text1 = new JTextField(20);
		Text1.setBounds(180, 30, 165, 25);
		panel.add(Text1);
		JLabel user2 = new JLabel("年龄：");
		user2.setBounds(100, 60, 80, 25);
		panel.add(user2);
		JTextField Text2 = new JTextField(20);
		Text2.setBounds(180, 60, 165, 25);
		panel.add(Text2);
		JLabel user3 = new JLabel("院系：");
		user3.setBounds(100, 90, 80, 25);
		panel.add(user3);
		JTextField Text3 = new JTextField(20);
		Text3.setBounds(180, 90, 165, 25);
		panel.add(Text3);
		JButton bun1 = new JButton("确认");
		bun1.setBounds(200, 120, 100, 35);
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
				Begin.begin();

			}

		});

	}
public static void takeclass(Student student) throws Exception {
	JFrame frame = new JFrame("选课界面");
	frame.setBounds(300, 300, 800, 800);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel panel1 = new JPanel();
	panel1.setBounds(0, 0, 800, 100);
	frame.add(panel1);
	panel1.setLayout(null);
	panel1.setBackground(Color.red);
	JLabel label1 = new JLabel("欢迎 " + student.getStudentName() + " 同学");
	label1.setBounds(0, 0, 200, 100);
	label1.setFont(new Font("楷体", Font.BOLD, 16));
	panel1.add(label1);
	CourseBiz cb=new CourseBiz();
	String content=cb.getAll();
	
}
}
