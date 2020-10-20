package rest.Services;

import java.io.Console;
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

import org.json.JSONObject;

import model.AreaNaturale;
import controller.AreaNaturaleController;

@Path("/areanaturale")
public class AreaNaturaleRestServiceEndpoint {
	
	@Inject
	private AreaNaturaleController areanaturalecontroller;
	
	
	//test hello world example
	@GET
	@Path("/create")
	@Produces({MediaType.TEXT_PLAIN})
	public UUID sayHello() {
		UUID test = UUID.randomUUID();
		return(test);
	}
	
	
    @GET
    @Path("/get/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAreaNaturale(@PathParam("id") long id) {
        AreaNaturale areanaturale = areanaturalecontroller.getAreaNaturale(id);
        return Response.ok(areanaturale).build();
    }
    
  	@GET
  	@Path("/areenaturali")
  	@Produces({MediaType.APPLICATION_JSON})
  	public Response getAreeNaturali() {
  		return Response.ok(areanaturalecontroller.getAllAreeNaturalii()).build();
  	}
  	
  	@POST
  	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(AreaNaturale areanaturale) {
    	areanaturalecontroller.createAreaNaturale(areanaturale);
        return Response.ok().build();
    }
  	
  	@PUT
    @Path("/update/id/{id}")
    public Response update(@PathParam("id") long id, AreaNaturale areanaturale) {
    	areanaturalecontroller.updateAreaNaturale(id ,areanaturale);
        return Response.ok().build();
    }
  	
    
    @GET
    @Path("/delete/id/{id}")
    public Response delete(@PathParam("id") long id) {
    	areanaturalecontroller.deleteAreaNaturale(id);
        return Response.ok().build();
    }
}
