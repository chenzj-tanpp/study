package bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import user.*;
import dbutils.*;

public class Bank {
	int account;
	private static User user;

	public static void main(String[] args) throws Exception {

		Bank bank = new Bank();
		bank.login();
		bank.operate();
	}

	// 金额存入、取出、查询
	public void operate() throws Exception {
		Bank bank = new Bank();
		int n;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请选择你要进行的操作：");
			System.out.println("1: 存入\t 2:取出\t 3:查询\t0:退出");
			n = sc.nextInt();
			if (n == 1 || n == 2) {

				int num = 0;
				try {
					System.out.println("请输入您的存取款数：");
					num = sc.nextInt();
				} catch (Exception e) {
					System.out.println("输入金额错误");
					continue;
				}

				switch (n) {
				case 1:
					bank.income(num);
					break;
				case 2:
					bank.takeout(num);
					break;
				default:
					break;
				}
			} else if (n == 3) {
				show();
			} else if (n == 0) {
				DBUtils dt = DBUtils.getInstance();
				dt.flash();
				// System.exit(0);
				break;
			} else {
				System.out.println("请输入0~3之间的数字选择操作");
			}

		}
	}

	public void login() throws Exception {
		DBUtils dt = DBUtils.getInstance();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入您的卡号：");
			String cardID = sc.nextLine();
			System.out.println("请输入密码：");
			String cardPwd = sc.nextLine();
			user = dt.getUser(cardID);
			if (dt.getUsers().containsKey(cardID) && user.getCardPwd().equals(cardPwd)) {
				System.out.println("登陆成功");// 登陆成功
				break;
			} else {
				System.out.println("密码或账号错误，请重新输入！");// 失败
				continue;
			}

		}
	}

	public void income(int num) {
		account = user.getAccount() + num;
		user.setAccount(account);
		System.out.println("已成功存入，请继续您的操作。");// 存入成功
	}

	public void takeout(int num) {
		if (user.getAccount() >= num) {
			account = user.getAccount() - num;

			user.setAccount(account);
			System.out.println("已取出");// 成功
		} else {
			System.out.println("您的余额不足：请重新选择您的操作");// 失败
		}
	}

	public void show() {
		account = user.getAccount();
		System.out.println("您的余额为" + account + "元");// 输出
	}
}
