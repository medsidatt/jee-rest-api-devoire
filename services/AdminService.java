package mr.iscae.services;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Response;
import mr.iscae.User;

public class AdminService {

	private static List<User> users = new ArrayList<User>();
	
	  static {
		  users.add(new User(1, "Amadou", "dg123", "directeur"));
		  users.add(new User(2, "Khalid", "dg123", "directeur"));
	    }
	
	public List<User> getAllUsers () {
		return users;
	}
	
	public User findUserById (int theId) {
		for(User user : users) {
			if(user.getId() == theId) {
				return user;
			}
		}
		return null;
	}
	
	
	public User creacteUser(User user) {
		users.add(user);
		return user;
	}
	
	public Response updateUser(User user, int id) {
		User existingUser = (User) findUserById(id);
		
		if (existingUser != null) {
			System.out.println("Not null");
			existingUser.setUserName(user.getUserName());
			existingUser.setPassword(user.getPassword());

	        return Response.ok(existingUser).build();
	    } else {
	    	System.out.println("null");
	        return Response.status(Response.Status.NOT_FOUND).build();
	    }
	}
	
	
	public boolean removeUserById(int userId) {
        User userToRemove = findUserById(userId);

        if (userToRemove != null) {
        	users.remove(userToRemove);
            return true;
        } else {
            return false;
        }
    }
	
	
	
	
}
