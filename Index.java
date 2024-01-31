package mr.iscae;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/secure/index")
public class Index {

	@GET
	public String index() {
		return "<a href=\"logout\">Logout</a>";
	}
}
