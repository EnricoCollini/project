package rest.Services;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.AreaNaturale;
import model.Ristoro;
import controller.AreaNaturaleController;
import controller.RistoroController;

@Path("/ristoro")
public class RistoroRestServiceEndpoint {
	@Inject
	private RistoroController ristorocontroller;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String sayHello() {
		return "Hello World";
	}
		
	@GET
	@Path("/uuid/{uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getRistoro(@PathParam("uuid") UUID uuid) {
	    Ristoro ristoro = ristorocontroller.getRistoro(uuid);
	    return Response.ok(ristoro).build();
	}
	    
	@GET
	@Path("/ristori")
	@Produces({MediaType.APPLICATION_JSON})
  	public Response getRistori() {
		return Response.ok(ristorocontroller.getAllRistori()).build();
	}
	  	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Ristoro	ristoro) {
		ristorocontroller.createRistoro(ristoro);
	    return Response.ok().build();
    }
	  	
 	@PUT
    @Path("/uuid/{uuid}")
    public Response update(@PathParam("uuid") UUID uuid, Ristoro ristoro) {
 		ristorocontroller.updateRistoro(uuid,ristoro);
        return Response.ok().build();
    }
	  	
	    
	@PUT
	@Path("/uuid/{uuid}")
	public Response delete(@PathParam("uuid") UUID uuid) {
	 	ristorocontroller.deleteRistoro(uuid);
	    return Response.ok().build();
	}
}
