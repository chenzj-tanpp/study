import user.*;

import java.util.Scanner;

import accountSystem.*;
import utility.XMLUtility;

public class Main {
	public static void main(String args[]) {
		User user;
		final Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫ��ѯ�绰�굥�ĺ��룺");
		String phonenumber=sc.next();
		AccountSystem accountSystem = (AccountSystem)XMLUtility.getAccountSystem();
		user=accountSystem.produce(phonenumber);
		user.generateCommunicateRecord();
		user.printDetails();
		System.exit(0);
	}
      
}

