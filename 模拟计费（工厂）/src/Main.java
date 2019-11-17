import user.*;

import java.util.Scanner;

import accountSystem.*;
import utility.XMLUtility;

public class Main {
	public static void main(String args[]) {
		User user;
		final Scanner sc = new Scanner(System.in);
		System.out.println("请输入要查询电话详单的号码：");
		String phonenumber=sc.next();
		AccountSystem accountSystem = (AccountSystem)XMLUtility.getAccountSystem();
		user=accountSystem.produce(phonenumber);
		user.generateCommunicateRecord();
		user.printDetails();
		System.exit(0);
	}
      
}

