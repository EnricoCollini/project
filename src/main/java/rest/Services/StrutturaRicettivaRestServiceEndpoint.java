package rest.Services;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.RistoroController;
import controller.StrutturaRicettivaController;
import model.Ristoro;
import model.StrutturaRicettiva;

public class StrutturaRicettivaRestServiceEndpoint {
	//@Inject
	private StrutturaRicettivaController strutturaricettivacontroller;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String sayHello() {
		return "Hello World";
	}
		
	@GET
	@Path("/uuid/{uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getStrutturaRicettiva(@PathParam("uuid") UUID uuid) {
		StrutturaRicettiva strutturaricettiva = strutturaricettivacontroller.getStrutturaRicettiva(uuid);
	    return Response.ok(strutturaricettiva).build();
	}
	    
	@GET
	@Path("/strutturericettive")
	@Produces({MediaType.APPLICATION_JSON})
  	public Response getStruttureRicettive() {
		return Response.ok(strutturaricettivacontroller.getAllStruttureRicettive()).build();
	}
	  	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(StrutturaRicettiva strutturaricettiva) {
		strutturaricettivacontroller.createStrutturaRicettiva(strutturaricettiva);
	    return Response.ok().build();
    }
	  	
 	@PUT
    @Path("/uuid/{uuid}")
    public Response update(@PathParam("uuid") UUID uuid, StrutturaRicettiva strutturaricettiva) {
 		strutturaricettivacontroller.updateStrutturaRicettiva(uuid,strutturaricettiva);
        return Response.ok().build();
    }
	  	
	    
	@PUT
	@Path("/uuid/{uuid}")
	public Response delete(@PathParam("uuid") UUID uuid) {
		strutturaricettivacontroller.deleteStrutturaRicettiva(uuid);
	    return Response.ok().build();
	}

}
