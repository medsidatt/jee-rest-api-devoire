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
import mr.iscae.Directeur;
import mr.iscae.Produit;
import mr.iscae.services.AdminService;
import mr.iscae.services.ProduitService;

@Path("/admin")
public class AdminRessource {

	private static AdminService adminService = new AdminService();
	private static ProduitService produitService = new ProduitService();
	private static ProduitRessource produitRessource = new ProduitRessource();
	
	
	@GET
	@Path("/directeurs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Directeur> getAllDirecteurs() {
		List<Directeur> directeurs = adminService.getAllDirecteurs();
		return directeurs;
	}
	
	@GET
	@Path("/directeurs/{directeurId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Directeur findDirecteurById(@PathParam("directeurId") int theId) {
		Directeur directeur = adminService.findDirecteurById(theId);
		return directeur;
	}
	
	@POST
	@Path("/directeurs")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Directeur createDirecteur(Directeur directeur) {
        return adminService.creacteDirecteur(directeur);
    }
	
	@PUT
	@Path("/directeurs/{directeurId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateDirecteur(@PathParam("directeurId") int theId, Directeur directeur) {
        return adminService.updateDirecteur(directeur, theId);
    }
	
	
	@DELETE
	@Path("/directeurs/{directeurId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteDirecteur(@PathParam("directeurId") int theId) {
	    boolean directeurRemoved = adminService.removeDirecteurById(theId);

	    if (directeurRemoved) {
	        return Response.ok("Le Direteur avec id: " +  theId + " est suprime").build();
	    } else {
	        return Response.status(Response.Status.NOT_FOUND).build();
	    }
	}
	
	
	
	
	///////////////////////////////////////
   ///////////////////////////////////////
	
	@GET
	@Path("/produits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getAllUsers() {
		return produitRessource.getAllProduits();
	}
	
	@GET
	@Path("/produits/{produitId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produit findProduitById(@PathParam("produitId") int theId) {
		return produitRessource.findProduitById(theId);
	}
	
	@POST
	@Path("/produits")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Produit createProduit(Produit produit) {
        return produitRessource.createProduit(produit);
    }
	
	@PUT
	@Path("/produits/{produitId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateProduit(@PathParam("produitId") int theId, Produit produit) {
        return produitRessource.updateProduit(theId, produit);
    }
	
	
	@DELETE
	@Path("/produits/{produitId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduit(@PathParam("produitId") int theId) {
	   return produitRessource.removeProduitById(theId);
	}
	
}
