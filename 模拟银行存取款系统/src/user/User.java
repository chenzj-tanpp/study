package user;

public class User {
    private String cardID;//银行卡号
    private String cardPwd;//密码
    private String userName;//账户名
    private String call;//手机号
    private int account;//余额
    public String getCardID() {
    	return cardID;
    }
    public void setCardID(String cardID) {
    	this.cardID=cardID;
    }
    public String getCardPwd() {
    	return cardPwd;
    }
    public void setCardPwd(String cardPwd) {
    	this.cardPwd=cardPwd;
    }
    public String getUserName() {
    	return userName;
    }
    public void setUserName(String userName) {
    	this.userName=userName;
    }
    public String getCall() {
    	return call;
    }
    public void setCall(String call) {
    	this.call=call;
    }
    public int getAccount() {
    	return account;
    }
    public void setAccount(int account) {
    	this.account=account;
    }
}
