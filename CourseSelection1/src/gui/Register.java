package gui;
import java.awt.*;
import javax.swing.*;
import biz.*;
import java.awt.event.*;
import entity.*;
//注册页面
public class Register {
    public static void register() {
    	JFrame frame =new JFrame("注册");   
    	frame.setSize(500, 500);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        panel.setLayout(null);
        JLabel user1 = new JLabel("学号：");
        user1.setBounds(100, 30, 80, 25);
        panel.add(user1);
        JTextField Text1 = new JTextField(20);
		Text1.setBounds(180,30, 165, 25);
		panel.add(Text1);
        JLabel user2 = new JLabel("姓名：");
        user2.setBounds(100, 60, 80, 25);
        panel.add(user2);
        JTextField Text2 = new JTextField(20);
		Text2.setBounds(180,60, 165, 25);
		panel.add(Text2);
        JLabel user3 = new JLabel("性别：");
        user3.setBounds(100, 90, 80, 25);
        panel.add(user3);
        JTextField Text3 = new JTextField(20);
		Text3.setBounds(180,90, 165, 25);
		panel.add(Text3);
        JLabel user4 = new JLabel("年龄：");
        user4.setBounds(100, 120, 80, 25);       
        panel.add(user4);
        JTextField Text4 = new JTextField(20);
		Text4.setBounds(180,120, 165, 25);
		panel.add(Text4);
        JLabel user5 = new JLabel("院系：");
        user5.setBounds(100, 150, 80, 25);
        panel.add(user5);
        JTextField Text5 = new JTextField(20);
		Text5.setBounds(180,150, 165, 25);
		panel.add(Text5);
        JLabel user6 = new JLabel("密码：");
        user6.setBounds(100, 180, 80, 25);
        panel.add(user6);
        JPasswordField passwdText1 = new JPasswordField(20);
        passwdText1.setBounds(180, 180, 165, 25);
		panel.add(passwdText1);
        JLabel user7 = new JLabel("确认密码：");
        user7.setBounds(100, 210, 80, 25);
        panel.add(user7);
        JPasswordField passwdText2 = new JPasswordField(20);
        passwdText2.setBounds(180, 210, 165, 25);
		panel.add(passwdText2);
		JButton bun1=new JButton("注册");
		bun1.setBounds(200, 250, 100, 35);
		panel.add(bun1);
		bun1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student=new Student();
				student.setStudentNo(Text1.getText());
				student.setStudentName(Text2.getText());
				student.setStudentGender(Text3.getText());
				student.setStudentAge(Integer.valueOf(Text4.getText()));
				student.setStudentDepartment(Text5.getText());
				student.setStudentPassword(String.valueOf(passwdText1.getPassword()));				
				String secondPass=String.valueOf(passwdText2.getPassword());
				StudentBiz studentBiz= new StudentBiz();
				try {

					studentBiz.register(student,secondPass);					
					
				} catch (Exception e1) {
					e1.printStackTrace();

				}
				frame.setVisible(false);
				Begin.begin();
				
			}
			
		});
		
    }
}
