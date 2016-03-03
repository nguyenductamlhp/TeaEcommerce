package model.data;

public class User {
	
	private int ID;
	private String UserName;
	private String PassWord;
	private String FullName;
	
	public User() {
		ID = -1;
		UserName = "";
		PassWord = "";
		FullName = "";
	}
	

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getPassWord() {
		return PassWord;
	}


	public void setPassWord(String passWord) {
		PassWord = passWord;
	}


	public String getFullName() {
		return FullName;
	}


	public void setFullName(String fullName) {
		FullName = fullName;
	}


	public boolean equals(User u) {
		if (UserName.equals(u.UserName) && PassWord.equals(u.PassWord)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
