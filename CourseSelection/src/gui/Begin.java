package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import biz.*;
import entity.*;
import java.awt.font.*;

//��ҳ��
public class Begin {
	public static void main(String[] args) {
		begin();
	}

	public static void notUser() {
		JFrame frame = new JFrame("����");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.yellow);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		JButton bun1 = new JButton("ȷ��");
		bun1.setBounds(100, 130, 80, 30);
		panel.add(bun1);
		JLabel pass = new JLabel("�û������ڣ�");
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
		JFrame frame = new JFrame("����");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		JButton bun1 = new JButton("ȷ��");
		bun1.setBounds(100, 130, 80, 30);
		panel.add(bun1);
		JLabel pass = new JLabel("�������");
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
		JFrame frame = new JFrame("��½�ɹ�");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		JButton bun1 = new JButton("ȷ��");
		bun1.setBounds(100, 130, 80, 30);
		panel.add(bun1);
		JLabel pass = new JLabel("��½�ɹ���");
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
		// ���� JFrame ʵ��
		JFrame frame = new JFrame("��ӭʹ��ѧ������ϵͳ");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		// ������
		frame.add(panel);
		frame.setResizable(false);
		panel.setLayout(null);
		// ���� JLabel
		JLabel userLabel = new JLabel("User:");
		userLabel.setBackground(Color.blue);
		// �����λ�á�
		userLabel.setBounds(100, 190, 80, 25);
		panel.add(userLabel);

		/*
		 * �����ı��������û�����
		 */
		JTextField userText = new JTextField(20);
		userText.setBounds(190, 190, 165, 25);
		panel.add(userText);

		// ����������ı���
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBackground(Color.blue);
		passwordLabel.setBounds(100, 220, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(190, 220, 165, 25);
		panel.add(passwordText);

		// ������¼��ť
		JButton loginButton = new JButton("��¼");
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
		// ����ע�ᰴť
		JButton bun1 = new JButton("ע��");
		bun1.setBounds(210, 280, 80, 25);
		bun1.setBackground(Color.blue);
		panel.add(bun1);
		bun1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Register.register();
			}
		});
		JButton bun2 = new JButton("�˳�");
		bun2.setBounds(300, 280, 80, 25);
		panel.add(bun2);
		bun2.setBackground(Color.red);
		bun2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// �����л��û���ť
		JButton but3 = new JButton("�л��û�");
		but3.setBackground(Color.red);
		but3.setBounds(385, 50, 100, 30);
		but3.setFont(new Font("����", Font.BOLD, 15));
		panel.add(but3);
		but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				begin();
			}
		});
		//
		JButton but4 = new JButton("����Ա");
		but4.setBackground(Color.GREEN);
		but4.setBounds(300, 50, 100, 30);
		but4.setFont(new Font("����", Font.BOLD, 15));
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
