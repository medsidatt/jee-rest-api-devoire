package mr.iscae.resources;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mr.iscae.Produit;
import mr.iscae.services.ProduitService;

@Path("/secure/directeur")
public class DirecteurRessource {

	private ProduitService produitService = new ProduitService();


	@GET
	@Path("/produits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getAllUsers() {
		return produitService.getAllProduits();
	}
	
	@GET
	@Path("/produits/{produitId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produit findProduitById(@PathParam("produitId") int theId) {
		return produitService.findProduitById(theId);
	}
	
	@GET
	@Path("/produits/{theCodeBare}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produit findProduitCodeBare(@PathParam("theCodeBare") String theCodeBare) {
		return produitService.findProduitByCodeBare(theCodeBare);
	}
	
	@GET
	@Path("/produits/{theName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produit findProduitByName(@PathParam("theName") String theName) {
		return produitService.findProduitByName(theName);
	}
	
	@POST
	@Path("/produits")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Produit createProduit(Produit produit) {
		return produitService.creacteProduit(produit);
    }
	
	@PUT
	@Path("/produits/{produitId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateProduit(@PathParam("produitId") int theId, Produit produit) {
		return produitService.updateProduit(produit, theId);
    }
	
	
	@DELETE
	@Path("/produits/{produitId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduit(@PathParam("produitId") int theId) {
		return produitService.removeProduitById(theId);
	}

}
