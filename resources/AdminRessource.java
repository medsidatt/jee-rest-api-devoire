package mr.iscae.resources;

import java.util.ArrayList;
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
import mr.iscae.User;
import mr.iscae.services.AdminService;

@Path("/admin")
public class AdminRessource {

	private static AdminService adminService = new AdminService();
	
	
	@GET
	@Path("/directeurs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Directeur> getAllUsers() {
		List<Directeur> directeurs = adminService.getAllDirecteurs();
		return directeurs;
	}
	
	@GET
	@Path("/directeurs/{directeurId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Directeur findUserById(@PathParam("directeurId") int theId) {
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
	public Response deleteUser(@PathParam("directeurId") int theId) {
	    boolean directeurRemoved = adminService.removeUserById(theId);

	    if (directeurRemoved) {
	        return Response.ok("Le Direteur avec id: " +  theId + " est suprime").build();
	    } else {
	        return Response.status(Response.Status.NOT_FOUND).build();
	    }
	}
	
}
