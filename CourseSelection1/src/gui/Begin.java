package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import biz.*;
import entity.*;
import java.awt.font.*;

//主页面
public class Begin {
	public static void main(String[] args) {
		begin();
	}

	public static void notUser() {
		JFrame frame = new JFrame("错误");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.yellow);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		JButton bun1 = new JButton("确定");
		bun1.setBounds(100, 130, 80, 30);
		panel.add(bun1);
		JLabel pass = new JLabel("用户不存在！");
		pass.setBackground(Color.white);
		pass.setBounds(100, 100, 80, 30);
		;
		panel.add(pass);
		frame.setVisible(true);
		bun1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				begin();
			}
		});

	}

	public static void passNot() {
		JFrame frame = new JFrame("错误");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		JButton bun1 = new JButton("确定");
		bun1.setBounds(100, 130, 80, 30);
		panel.add(bun1);
		JLabel pass = new JLabel("密码错误！");
		pass.setBackground(Color.white);
		pass.setBounds(100, 100, 80, 30);
		;
		panel.add(pass);
		frame.setVisible(true);
		bun1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
	}

	public static void success(Student student) {
		JFrame frame = new JFrame("登陆成功");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		JButton bun1 = new JButton("确定");
		bun1.setBounds(100, 130, 80, 30);
		panel.add(bun1);
		JLabel pass = new JLabel("登陆成功！");
		pass.setBackground(Color.white);
		pass.setBounds(100, 100, 80, 30);
		;
		panel.add(pass);
		frame.setVisible(true);
		bun1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				StudentGUI.student(student);
			}
		});
	}

	public static void begin() {
		// 创建 JFrame 实例
		JFrame frame = new JFrame("欢迎使用学生管理系统");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		// 添加面板
		frame.add(panel);
		frame.setResizable(false);
		panel.setLayout(null);
		// 创建 JLabel
		JLabel userLabel = new JLabel("User:");
		userLabel.setBackground(Color.blue);
		// 组件的位置。
		userLabel.setBounds(100, 190, 80, 25);
		panel.add(userLabel);

		/*
		 * 创建文本域用于用户输入
		 */
		JTextField userText = new JTextField(20);
		userText.setBounds(190, 190, 165, 25);
		panel.add(userText);

		// 输入密码的文本域
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBackground(Color.blue);
		passwordLabel.setBounds(100, 220, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(190, 220, 165, 25);
		panel.add(passwordText);

		// 创建登录按钮
		JButton loginButton = new JButton("登录");
		loginButton.setBackground(Color.green);
		loginButton.setBounds(120, 280, 80, 25);
		panel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentNo = userText.getText();
				String studentPassWd = String.valueOf(passwordText.getPassword());

				StudentBiz studentBiz = new StudentBiz();
				try {
					frame.setVisible(false);
					studentBiz.login(studentNo, studentPassWd);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// 创建注册按钮
		JButton bun1 = new JButton("注册");
		bun1.setBounds(210, 280, 80, 25);
		bun1.setBackground(Color.blue);
		panel.add(bun1);
		bun1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Register.register();
			}
		});
		JButton bun2 = new JButton("退出");
		bun2.setBounds(300, 280, 80, 25);
		panel.add(bun2);
		bun2.setBackground(Color.red);
		bun2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// 创建切换用户按钮
		JButton but3 = new JButton("切换用户");
		but3.setBackground(Color.red);
		but3.setBounds(385, 50, 100, 30);
		but3.setFont(new Font("楷体", Font.BOLD, 15));
		panel.add(but3);
		but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				begin();
			}
		});
		//
		JButton but4 = new JButton("管理员");
		but4.setBackground(Color.GREEN);
		but4.setBounds(300, 50, 100, 30);
		but4.setFont(new Font("楷体", Font.BOLD, 15));
		panel.add(but4);
		but4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				begin();
			}
		});
		frame.setVisible(true);
	}
}
