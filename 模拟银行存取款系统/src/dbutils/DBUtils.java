package dbutils;

import user.*;
import java.util.HashMap;

public class DBUtils {
	private static DBUtils instance = null;
	private HashMap<String, User> users = new HashMap<String, User>();

	private DBUtils() {
		// 设立u1
		User u1 = new User();
		u1.setCardID("111");
		u1.setUserName("chen");
		u1.setCall("1541545");
		u1.setCardPwd("123");
		u1.setAccount(1500);
		users.put(u1.getCardID(), u1);
		// 设立u2
		User u2 = new User();
		u1.setCardID("112");
		u1.setUserName("wang");
		u1.setCall("15165");
		u1.setCardPwd("123");
		u1.setAccount(1000);
		// 设立u3
		User u3 = new User();
		u1.setCardID("113");
		u1.setUserName("tan");
		u1.setCall("15454445");
		u1.setCardPwd("123");
		u1.setAccount(900);
	}

	public static DBUtils getInstance() {
		if (instance == null) {
			synchronized (DBUtils.class) {
				if (instance == null) {
					instance = new DBUtils();
				}
			}
		}
		return instance;
	}

	public User getUser(String cardID) {
		User user = (User) users.get(cardID);
		return user;
	}

	public HashMap<String, User> getUsers() {
		return users;
	}
}
