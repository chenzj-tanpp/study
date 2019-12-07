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

// ģ��ͨ����¼������
	void generateCommunicateRecord() {
		int recordNum = new Random().nextInt(10);
		for (int i = 0; i <= recordNum; i++) {
			this.singleRecord = new LinkedHashMap();
			// ��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			// ����ʱ�俪ʼ���ʮ�����������һ-��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			this.callTo = getCallToPhoneNumber();// ���к���
			// ����ͨ����¼
			this.singleRecord.put("����", this.phoneNumber);
			this.singleRecord.put("��ʼʱ��", new Date(timeStart));
			this.singleRecord.put("����ʱ��", new Date(timeEnd));
			this.singleRecord.put("���к���", this.callTo);
			this.singleRecord.put("�Ʒ�", this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(singleRecord);

		}

	}

	private String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10))
				+ String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10));
	}

	// ģ��ƷѰ취�����ַ�������ʽ���ر���3λС���ļƷѽ��
	private String accountFee(long timeStart, long timeEnd) {
		double feePerMinute = 0.2;
		int minutes = Math.round((timeEnd - timeStart) / 60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.3f", feeTotal);

	}

//��ӡͨ����¼
	void printDetails() {

		Iterator it = this.communicationRecords.iterator();
		while (it.hasNext()) {
			System.out.println("----------ͨ����¼�ָ���----------");
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