package javabasic.jdbc;

public class UserInfo {
	
	private String username;
	private int identifier;
	private String firstName;
	private String lastName;


	public UserInfo() {
		// TODO Auto-generated constructor stub
	}


	
	
	public String getUsername() {
		return username;
	}




	public UserInfo(String username, int identifier, String firstName, String lastName) {
		super();
		this.username = username;
		this.identifier = identifier;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public void setUsername(String username) {
		this.username = username;
	}




	public int getIdentifier() {
		return identifier;
	}




	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", identifier=" + identifier + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	
}
