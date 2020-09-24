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
import controller.AreaNaturaleController;

public class AreaNaturaleRestServiceEndpoint {
	//@Inject
	private AreaNaturaleController areanaturalecontroller;
	
	//test hello world example
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String sayHello() {
		return "Hello World";
	}
	
    @GET
    @Path("/areanaturale/uuid/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAreaNaturale(@PathParam("uuid") UUID uuid) {
        AreaNaturale areanaturale = areanaturalecontroller.getAreaNaturale(uuid);
        return Response.ok(areanaturale).build();
    }
    
  	@GET
  	@Path("/areanaturale/areenaturali")
  	@Produces({MediaType.APPLICATION_JSON})
  	public Response getAreeNaturali() {
  		return Response.ok(areanaturalecontroller.getAllAreeNaturalii()).build();
  	}
  	
  	@POST
  	@Path("/areanaturale/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(AreaNaturale areanaturale) {
    	areanaturalecontroller.createAreaNaturale(areanaturale);
        return Response.ok().build();
    }
  	
  	@PUT
    @Path("/areanaturale/uuid/{uuid}")
    public Response update(@PathParam("uuid") UUID uuid, AreaNaturale areanaturale) {
    	areanaturalecontroller.updateAreaNaturale(uuid ,areanaturale);
        return Response.ok().build();
    }
  	
    
    @PUT
    @Path("/areanaturale/uuid/{uuid}")
    public Response delete(@PathParam("uuid") UUID uuid) {
    	areanaturalecontroller.deleteAreaNaturale(uuid);
        return Response.ok().build();
    }
}
