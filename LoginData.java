package mr.iscae;

import java.util.ArrayList;
import java.util.List;

public class LoginData {

	public static List<User> users = new ArrayList<User>();
	
	public LoginData() {
		
	}
	
	static {
		  users.add(new User(1, "admin", "admin", "admin"));
		  users.add(new User(2, "directeur", "directeur", "directeur"));
	    }
	
	public List<User> getUsers() {
		return users;
	}
	
	public User getUserByUserNameAndPassword(String username, String password) {
		for(User user : users) {
			if(username.equals(user.getUserName())) {
				return user;
			}
		}
		return null;
	}
}
