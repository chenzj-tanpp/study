package gui;
import javax.swing.*;
import entity.*;
import biz.*;
//�γ���Ϣ����
public class SCGUI {
	public static void sC(Student student) throws Exception {
		JFrame frame = new JFrame("�γ���Ϣ");
		frame.setBounds(300, 300, 800, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
	}
	
}
