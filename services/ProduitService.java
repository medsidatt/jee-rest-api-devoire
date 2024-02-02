package mr.iscae.services;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Response;
import mr.iscae.Produit;

public class ProduitService {

	private static List<Produit> produits = new ArrayList<Produit>();
	
	  static {
		  produits.add(new Produit(1, "Produit 1", "codebare1", 100.0, 54));
	    }
	
	public List<Produit> getAllProduits () {
		return produits;
	}
	
	public Produit findProduitById (int theId) {
		for(Produit produit : produits) {
			if(produit.getId() == theId) {
				return produit;
			}
		}
		return null;
	}
	
	public Produit findProduitByCodeBare (String theCodeBare) {
		for(Produit produit : produits) {
			if(produit.getCodeBare() == theCodeBare) {
				return produit;
			}
		}
		return null;
	}
	
	public Produit findProduitByName (String name) {
		for(Produit produit : produits) {
			if(produit.getName() == name) {
				return produit;
			}
		}
		return null;
	}
	
	
	public Produit creacteProduit(Produit produit) {
		produits.add(produit);
		return produit;
	}
	
	public Response updateProduit(Produit produit, int id) {
		Produit existingProduit = (Produit) findProduitById(id);
		
		if (existingProduit != null) {
			existingProduit.setName(produit.getName());
			existingProduit.setCodeBare(produit.getCodeBare());
			existingProduit.setPrice(produit.getPrice());
			existingProduit.setQuantity(produit.getQuantity());

	        return Response.ok(existingProduit).build();
	    } else {
	    	System.out.println("null");
	        return Response.status(Response.Status.NOT_FOUND).build();
	    }
	}
	
	
	public Response removeProduitById(int produitId) {
        Produit produitToRemove = findProduitById(produitId);
        
        if (produitToRemove != null) {
        	produits.remove(produitToRemove);
            return Response.ok("Le Produit avec id: " +  produitId + " est suprime").build();
        } else {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
	
}
