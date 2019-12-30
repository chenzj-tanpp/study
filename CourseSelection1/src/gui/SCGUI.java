package gui;
import javax.swing.*;
import entity.*;
import biz.*;
//课程信息界面
public class SCGUI {
	public static void sC(Student student) throws Exception {
		JFrame frame = new JFrame("课程信息");
		frame.setBounds(300, 300, 800, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
	}
	
}
