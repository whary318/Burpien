package Application.modules;

public class User {
	private String userName;
	private int userId;
	private Privilage privilage;

	public User(String userName, int userId, Privilage privilage) {
		this.privilage = privilage;
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public int getUserId() {
		return userId;
	}

	public Privilage getPrivilage() {
		return privilage;
	}

}
