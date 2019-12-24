package dbutils;

import user.*;
import java.util.HashMap;
import java.io.*;

public class DBUtils implements Serializable{
	private static DBUtils instance = null;
	private HashMap<String, User> users = new HashMap<String, User>();

	private DBUtils()throws Exception {
		// 设立u1
		FileInputStream fis =new FileInputStream("example.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		users=(HashMap<String, User>)ois.readObject();
		//users.put(user.getCardID(), user);
		/*User u1 = new User();
		u1.setCardID("111");
		u1.setUserName("chen");
		u1.setCall("1541545");
		u1.setCardPwd("123");
		u1.setAccount(1500);
		users.put(u1.getCardID(), u1);
		
		// 设立u2
		User u2 = new User();
		u2.setCardID("112");
		u2.setUserName("wang");
		u2.setCall("15165");
		u2.setCardPwd("123");
		u2.setAccount(1000);
		users.put(u2.getCardID(),u2);
		// 设立u3
		User u3 = new User();
		u3.setCardID("113");
		u3.setUserName("tan");
		u3.setCall("15454445");
		u3.setCardPwd("123");
		u3.setAccount(900);
		users.put(u2.getCardID(),u3);*/
		
		
	}
	
	public static DBUtils getInstance() throws Exception {
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
	public void flash()throws Exception {
		FileOutputStream out = new FileOutputStream("example.txt");
		ObjectOutputStream bos = new ObjectOutputStream(out);
		bos.writeObject(users);
		bos.close();
		out.close();
	}
}
