package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import biz.*;
import entity.*;

public class ModifyPasswdGUI {
	public static void modifyPasswd(Student student) {
		// ���� JFrame ʵ��
		JFrame frame = new JFrame("�޸�����");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		// ������
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		panel.setLayout(null);
		// ���� JLabel
		JLabel userLabel = new JLabel("ԭ����:");
		userLabel.setBounds(100, 190, 80, 25);
		panel.add(userLabel);

		JPasswordField Text1 = new JPasswordField(20);
		Text1.setBounds(190, 190, 165, 25);
		panel.add(Text1);
		JLabel passwordLabel = new JLabel("������:");
		passwordLabel.setBounds(100, 220, 80, 25);
		panel.add(passwordLabel);

		JPasswordField Text2 = new JPasswordField(20);
		Text2.setBounds(190, 220, 165, 25);
		panel.add(Text2);
		JLabel passwordLabel3 = new JLabel("ȷ������:");
		passwordLabel3.setBounds(100, 250, 80, 25);
		panel.add(passwordLabel3);

		JPasswordField Text3 = new JPasswordField(20);
		Text3.setBounds(190, 250, 165, 25);
		panel.add(Text3);
		JButton jbu = new JButton("ȷ��");
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
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				//Register.register();
				
				Begin.begin();
			}
		});
	}
}
