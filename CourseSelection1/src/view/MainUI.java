package view;

import java.util.Scanner;

public class MainUI {
	public static void show() throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("1-ע�᣻2-�޸����룻3-ѡ�Σ�4-��¼��5-�鿴��ѡ�γ̣�0-�˳�");
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
