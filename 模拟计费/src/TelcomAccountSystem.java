public class TelcomAccountSystem {
	public static void main(String[] args) {
		// ʵ����-�������û���TelcomUser
		MapTelcomUser telcomUser = new MapTelcomUser("13800138000");
		// ����ͨ����¼
		telcomUser.generateCommunicateRecord();
		// ��ӡͨ���굥
		telcomUser.printDetails();
	}
}