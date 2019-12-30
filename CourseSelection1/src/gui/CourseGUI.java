package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import biz.CourseBiz;
import entity.*;

//课程管理页面
public class CourseGUI {
	public static void Course() {
		JFrame frame = new JFrame("课程管理界面");
		frame.setBounds(300, 300, 800, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 800, 100);
		frame.add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(Color.red);
		JLabel label = new JLabel("欢迎 管理员老师");
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
//
		JButton jbu3 = new JButton("查看选该课程的学生");
		jbu3.setBounds(350, 115, 100, 25);
		panel2.add(jbu3);
		jbu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
//				
			}
		});
		JButton jbu5 = new JButton("退出登录");
		jbu5.setBounds(450, 115, 100, 25);
		jbu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Begin.begin();
			}
		});
		panel2.add(jbu5);
		JButton jbu4 = new JButton("删除课程");
		jbu4.setBounds(350, 400, 150, 25);
		panel3.add(jbu4);
		jbu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				delete();
			}
		});
		JButton jbu1 = new JButton("添加课程");
		jbu1.setBounds(350, 310, 150, 25);
		jbu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				newCourse();

//				
			}
		});
		panel3.add(jbu1);
		JButton jbu6 = new JButton("修改课程");
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
		JFrame frame = new JFrame("新建课程");
		frame.setBackground(Color.green);
		frame.setBounds(500, 500, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		JLabel jl1 = new JLabel("课程号：");
		jl1.setBounds(200, 180, 80, 25);
		panel.add(jl1);
		JTextField text1 = new JTextField();
		text1.setBounds(300, 180, 100, 25);
		panel.add(text1);
		JLabel jl2 = new JLabel("课程名称：");
		jl2.setBounds(200, 210, 80, 25);
		panel.add(jl2);
		JTextField text2 = new JTextField();
		text2.setBounds(300, 210, 100, 25);
		panel.add(text2);
		JLabel jl3 = new JLabel("任课教师：");
		jl3.setBounds(200, 240, 80, 25);
		panel.add(jl3);
		JTextField text3 = new JTextField();
		text3.setBounds(300, 240, 100, 25);
		panel.add(text3);
		JLabel jl4 = new JLabel("适用年级：");
		jl4.setBounds(200, 270, 80, 25);
		panel.add(jl4);
		JTextField text4 = new JTextField();
		text4.setBounds(300, 270, 100, 25);
		panel.add(text4);
		JButton jbu = new JButton("新建");
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
					cb.newCourse(courseNo, courseName, 
							courseTeacher, courseGrade);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.setVisible(false);
				Course();
			}
		});
	}

	public static void delete() {
		JFrame frame = new JFrame("删除课程");
		frame.setBackground(Color.green);
		frame.setBounds(500, 500, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		JLabel jl1 = new JLabel("课程号：");
		jl1.setBounds(180, 150, 80, 25);
		panel.add(jl1);
		JTextField text1 = new JTextField();
		text1.setBounds(260, 150, 100, 25);
		panel.add(text1);
		JButton jbu = new JButton("删除");
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
		JFrame frame = new JFrame("修改课程");
		frame.setBackground(Color.green);
		frame.setBounds(500, 500, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		JLabel jl1 = new JLabel("课程号：");
		jl1.setBounds(200, 180, 80, 25);
		panel.add(jl1);
		JTextField text1 = new JTextField();
		text1.setBounds(300, 180, 100, 25);
		panel.add(text1);
		JLabel jl2 = new JLabel("课程名称：");
		jl2.setBounds(200, 210, 80, 25);
		panel.add(jl2);
		JTextField text2 = new JTextField();
		text2.setBounds(300, 210, 100, 25);
		panel.add(text2);
		JLabel jl3 = new JLabel("任课教师：");
		jl3.setBounds(200, 240, 80, 25);
		panel.add(jl3);
		JTextField text3 = new JTextField();
		text3.setBounds(300, 240, 100, 25);
		panel.add(text3);
		JLabel jl4 = new JLabel("适用年级：");
		jl4.setBounds(200, 270, 80, 25);
		panel.add(jl4);
		JTextField text4 = new JTextField();
		text4.setBounds(300, 270, 100, 25);
		panel.add(text4);
		JButton jbu = new JButton("修改");
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
					cb.newCourse(courseNo, courseName, 
							courseTeacher, courseGrade);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.setVisible(false);
				Course();
			}
		});
	}
	public static void check() {
		JFrame frame = new JFrame("查看选课学生");
		frame.setBounds(300, 300, 800, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 800, 100);
		frame.add(panel1);
		panel1.setLayout(null);
	}
}
