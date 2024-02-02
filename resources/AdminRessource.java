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
import mr.iscae.User;
import mr.iscae.services.AdminService;
import mr.iscae.services.ProduitService;

@Path("secure/admin")
public class AdminRessource {

	private AdminService adminService = new AdminService();
	private ProduitService produitService = new ProduitService();
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		List<User> directeurs = adminService.getAllUsers();
		return directeurs;
	}
	
	@GET
	@Path("/users/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User findUserById(@PathParam("userId") int theId) {
		User user = adminService.findUserById(theId);
		return user;
	}
	
	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        return adminService.creacteUser(user);
    }
	
	@PUT
	@Path("/users/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userId") int theId, User user) {
        return adminService.updateUser(user, theId);
    }
	
	
	@DELETE
	@Path("/users/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("userId") int theId) {
	    boolean userRemoved = adminService.removeUserById(theId);

	    if (userRemoved) {
	        return Response.ok("L'utilisateur avec id: " +  theId + " est suprime").build();
	    } else {
	        return Response.status(Response.Status.NOT_FOUND).build();
	    }
	}
	
	
	/*
	
		///////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////////////////////////
	*/
	
	@GET
	@Path("/produits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getAllProduits() {
		return produitService.getAllProduits();
	}
	
	@GET
	@Path("/produits/{produitId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produit findProduitById(@PathParam("produitId") int theId) {
		return produitService.findProduitById(theId);
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
