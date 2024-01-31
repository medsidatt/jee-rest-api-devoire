package mr.iscae;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty
	private int id;
	@JsonProperty
	private String firstName;
	@JsonProperty
	private String lastName;
	@JsonProperty
	private String password;
	
	public User(int id, String firstName, String lastName, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public User() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	
}
