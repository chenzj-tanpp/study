import java.util.*;
import java.text.*;

public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private StringBuffer communicatiaoRecords;
	private ArrayList ArrayListcommunicationRecords;
	private LinkedList LinkedcommunicationRecords;
	private TreeSet TreecommuntionRecords;
	private HashSet hashcommunicationRecords;
	private Vector vcommunicationRecords;
	 public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicatiaoRecords = new StringBuffer();
		this.ArrayListcommunicationRecords = new ArrayList();
		this.LinkedcommunicationRecords = new LinkedList();
		this.TreecommuntionRecords = new TreeSet();
		this.hashcommunicationRecords = new HashSet();
		this.vcommunicationRecords=new Vector();
	}

// 模拟通话记录的生成
	void generateCommunicateRecord() {
		int recordNum = new Random().nextInt(10);
		for (int i = 0; i <= recordNum; i++) {
			// this.phoneNumber=getCallToPhoneNumber();// 随机生成第i条通话记录
			// 开始时间，当前时间之前的某个随机时间
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			// 结束时间开始后的十分钟内随机的一-个时间，至少一分钟
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			this.callTo = getCallToPhoneNumber();// 被叫号码
			// 插入通话记录
			// this.communicatiaoRecords.append(this.phoneNumber + "," + timeStart + "," +
			// timeEnd + "," + this.callTo + ";");
			// this.ArrayListcommunicationRecords.add(this.phoneNumber+","+timeStart+","+timeEnd+","+this.callTo);
			// this.TreecommuntionRecords.add(this.phoneNumber + "," + timeStart + ","
			// +timeEnd + "," + this.callTo);
			// this.LinkedcommunicationRecords.add(this.phoneNumber + "," + timeStart + ","
			// + timeEnd + "," + this.callTo);
			//this.hashcommunicationRecords.add(this.phoneNumber + "," + timeStart + "," + timeEnd + "," + this.callTo);
		this.vcommunicationRecords.add(this.phoneNumber + "," + timeStart + "," + timeEnd + "," + this.callTo);
		}

	}

	private String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10))
				+ String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10));
	}

	// 模拟计费办法，以字符串的形式返回保留3位小数的计费结果
	private String accountFee(long timeStart, long timeEnd) {
		double feePerMinute = 0.2;
		int minutes = Math.round((timeEnd - timeStart) / 60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.3f", feeTotal);

	}

//打印通话记录
	void printDetails() {
		int ArrayListSize = ArrayListcommunicationRecords.size();

		/*
		 * String allRecords = this.communicatiaoRecords.toString(); String[] AllRecords
		 * = allRecords.split(";");
		 */
		// Iterator it = TreecommuntionRecords.iterator();
		// Iterator it = LinkedcommunicationRecords.iterator();
		//Iterator it = hashcommunicationRecords.iterator();
		Enumeration en=vcommunicationRecords.elements();
		DateFormat date = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		SimpleDateFormat da = new SimpleDateFormat("E yyyy - MM - dd  HH:mm:ss ");
		// for (int i = 0; i < ArrayListSize; i++) {
		// for (int i = 0; i < allRecords.length(); i++) {
		//while (it.hasNext()) {
		while (en.hasMoreElements()) {
			/*
			 * String[] recordField =
			 * ArrayListcommunicationRecords.get(i).toString().split(",");
			 */
			// String[] recordField = AllRecords[i].split(",");
			//String[] recordField = it.next().toString().split(",");
			String[] recordField = en.nextElement().toString().split(",");
			System.out.println("----------通话记录分割线----------");
			System.out.println("主叫：" + recordField[0]);
			System.out.println("被叫：" + recordField[3]);
			System.out.println("通话开始时间：" + da.format(Long.parseLong(recordField[1])));
			System.out.println("通话结束时间：" + date.format(Long.parseLong(recordField[2])));
			System.out
					.println("计费：" + accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2])) + "元");
		}

		/*
		 * String AllRecords; for (Object allRecords : hashcommunicationRecords) {
		 * //String[] recordField = it.next().toString().split(",");
		 * AllRecords=(String)allRecords; String[] recordField = AllRecords.split(",");
		 * System.out.println("----------通话记录分割线----------"); System.out.println("主叫：" +
		 * recordField[0]); System.out.println("被叫：" + recordField[3]);
		 * System.out.println("通话开始时间：" + da.format(Long.parseLong(recordField[1])));
		 * System.out.println("通话结束时间：" + date.format(Long.parseLong(recordField[2])));
		 * System.out .println("计费：" + accountFee(Long.parseLong(recordField[1]),
		 * Long.parseLong(recordField[2])) + "元"); }
		 */
	}

}
