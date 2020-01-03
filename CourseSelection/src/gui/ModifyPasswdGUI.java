package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import biz.*;
import entity.*;

public class ModifyPasswdGUI {
	public static void modifyPasswd(Student student) {
		// 创建 JFrame 实例
		JFrame frame = new JFrame("修改密码");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		// 添加面板
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		panel.setLayout(null);
		// 创建 JLabel
		JLabel userLabel = new JLabel("原密码:");
		userLabel.setBounds(100, 190, 80, 25);
		panel.add(userLabel);

		JPasswordField Text1 = new JPasswordField(20);
		Text1.setBounds(190, 190, 165, 25);
		panel.add(Text1);
		JLabel passwordLabel = new JLabel("新密码:");
		passwordLabel.setBounds(100, 220, 80, 25);
		panel.add(passwordLabel);

		JPasswordField Text2 = new JPasswordField(20);
		Text2.setBounds(190, 220, 165, 25);
		panel.add(Text2);
		JLabel passwordLabel3 = new JLabel("确认密码:");
		passwordLabel3.setBounds(100, 250, 80, 25);
		panel.add(passwordLabel3);

		JPasswordField Text3 = new JPasswordField(20);
		Text3.setBounds(190, 250, 165, 25);
		panel.add(Text3);
		JButton jbu = new JButton("确认");
		jbu.setBounds(180, 280, 80, 25);
		jbu.setBackground(Color.red);
		panel.add(jbu);
		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentNo=student.getStudentNo();
				String studentPassWd=String.valueOf(Text1.getPassword());
				String firstPassWd=String.valueOf(Text2.getPassword());
				String secondPassWd=String.valueOf(Text3.getPassword());
				
				frame.setVisible(false);
				StudentBiz stb=new StudentBiz();
				try {
					stb.modifyPassword(studentNo, 
							studentPassWd, 
							firstPassWd, 
							secondPassWd);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				//Register.register();
				
				Begin.begin();
			}
		});
	}
}
