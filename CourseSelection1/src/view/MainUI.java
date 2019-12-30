package view;

import java.util.Scanner;

public class MainUI {
	public static void show() throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("1-注册；2-修改密码；3-选课；4-登录；5-查看已选课程；0-退出");
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			RegisterUI.show();
			break;
		case "2":
			ModifyPasswordUI.show();
			break;
		case "3":
			CourseSelection.show();
			break;
		case "5": 
			
		case "4":
			LoginUI.show();
		}
	}
}
