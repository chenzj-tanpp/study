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

// ģ��ͨ����¼������
	void generateCommunicateRecord() {
		int recordNum = new Random().nextInt(10);
		for (int i = 0; i <= recordNum; i++) {
			// this.phoneNumber=getCallToPhoneNumber();// ������ɵ�i��ͨ����¼
			// ��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			// ����ʱ�俪ʼ���ʮ�����������һ-��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			this.callTo = getCallToPhoneNumber();// ���к���
			// ����ͨ����¼
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

	// ģ��ƷѰ취�����ַ�������ʽ���ر���3λС���ļƷѽ��
	private String accountFee(long timeStart, long timeEnd) {
		double feePerMinute = 0.2;
		int minutes = Math.round((timeEnd - timeStart) / 60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.3f", feeTotal);

	}

//��ӡͨ����¼
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
			System.out.println("----------ͨ����¼�ָ���----------");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			System.out.println("ͨ����ʼʱ�䣺" + da.format(Long.parseLong(recordField[1])));
			System.out.println("ͨ������ʱ�䣺" + date.format(Long.parseLong(recordField[2])));
			System.out
					.println("�Ʒѣ�" + accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2])) + "Ԫ");
		}

		/*
		 * String AllRecords; for (Object allRecords : hashcommunicationRecords) {
		 * //String[] recordField = it.next().toString().split(",");
		 * AllRecords=(String)allRecords; String[] recordField = AllRecords.split(",");
		 * System.out.println("----------ͨ����¼�ָ���----------"); System.out.println("���У�" +
		 * recordField[0]); System.out.println("���У�" + recordField[3]);
		 * System.out.println("ͨ����ʼʱ�䣺" + da.format(Long.parseLong(recordField[1])));
		 * System.out.println("ͨ������ʱ�䣺" + date.format(Long.parseLong(recordField[2])));
		 * System.out .println("�Ʒѣ�" + accountFee(Long.parseLong(recordField[1]),
		 * Long.parseLong(recordField[2])) + "Ԫ"); }
		 */
	}

}
