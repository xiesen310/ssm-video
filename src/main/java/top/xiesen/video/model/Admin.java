package top.xiesen.video.model;

public class Admin {

	private int id;
	private String loginName;
	private String loginPwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", loginName=" + loginName + ", loginPwd=" + loginPwd + "]";
	}
	
	
}
