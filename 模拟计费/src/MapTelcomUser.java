import java.util.*;
import java.text.*;

public class MapTelcomUser {

	private String phoneNumber;
	private String callTo;
	private HashMap singleRecord;
	private ArrayList communicationRecords;

	public MapTelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new ArrayList();

	}

// 模拟通话记录的生成
	void generateCommunicateRecord() {
		int recordNum = new Random().nextInt(10);
		for (int i = 0; i <= recordNum; i++) {
			this.singleRecord = new LinkedHashMap();
			// 开始时间，当前时间之前的某个随机时间
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			// 结束时间开始后的十分钟内随机的一-个时间，至少一分钟
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			this.callTo = getCallToPhoneNumber();// 被叫号码
			// 插入通话记录
			this.singleRecord.put("主叫", this.phoneNumber);
			this.singleRecord.put("开始时间", new Date(timeStart));
			this.singleRecord.put("结束时间", new Date(timeEnd));
			this.singleRecord.put("被叫号码", this.callTo);
			this.singleRecord.put("计费", this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(singleRecord);

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

		Iterator it = this.communicationRecords.iterator();
		while (it.hasNext()) {
			System.out.println("----------通话记录分割线----------");
			this.singleRecord=((LinkedHashMap)it.next());
			
			/*Iterator ite=this.singleRecord.entrySet().iterator();
			while (ite.hasNext()) {
			Map.Entry entry=(Map.Entry) it.next();
				System.out.println(entry.getKey()+":"+entry.getValue());
			}*/
			Set keySet=this.singleRecord.keySet();
			Iterator ite=keySet.iterator();
			while (ite.hasNext()) {
				Object key= ite.next();
				Object value=this.singleRecord.get(key);
				System.out.println(key+":"+value);
			}


	}

	}
}