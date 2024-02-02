package mr.iscae.services;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Response;
import mr.iscae.Directeur;
import mr.iscae.User;

public class AdminService {

	private static List<Directeur> directeurs = new ArrayList<Directeur>();
	
	  static {
		  directeurs.add(new Directeur(1, "Amadou", "Amadou", "dg123"));
		  directeurs.add(new Directeur(2, "Khalid", "Gassama", "dg123"));
		  directeurs.add(new Directeur(3, "Caissier 1", "Caissier 1", "cs123"));
	    }
	
	public List<Directeur> getAllDirecteurs () {
		return directeurs;
	}
	
	public Directeur findDirecteurById (int theId) {
		for(Directeur directeur : directeurs) {
			if(directeur.getId() == theId) {
				return directeur;
			}
		}
		return null;
	}
	
	
	public Directeur creacteDirecteur(Directeur directeur) {
		directeurs.add(directeur);
		return directeur;
	}
	
	public Response updateDirecteur(Directeur directeur, int id) {
		Directeur existingDirecteur = (Directeur) findDirecteurById(id);
		
		if (existingDirecteur != null) {
			System.out.println("Not null");
			existingDirecteur.setFirstName(directeur.getFirstName());
			existingDirecteur.setLastName(directeur.getLastName());
			existingDirecteur.setPassword(directeur.getPassword());

	        return Response.ok(existingDirecteur).build();
	    } else {
	    	System.out.println("null");
	        return Response.status(Response.Status.NOT_FOUND).build();
	    }
	}
	
	
	public boolean removeDirecteurById(int userId) {
        User directeurToRemove = findDirecteurById(userId);

        if (directeurToRemove != null) {
        	directeurs.remove(directeurToRemove);
            return true;
        } else {
            return false;
        }
    }
	
	
	
	
}
