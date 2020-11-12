package rest.Services;
import java.util.List;
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
import model.Itinerario;
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
    @Path("/get/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAreaNaturale(@PathParam("id") long id) {
    	Ristoro ristoro = ristorocontroller.getRistoro(id);
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
    @Path("/update/id/{id}")
    public Response update(@PathParam("id") long id, Ristoro ristoro) {
 		ristorocontroller.updateRistoro(id,ristoro);
        return Response.ok().build();
    }
	  	
	    
 	@GET
	@Path("/delete/id/{id}")
	public Response delete(@PathParam("id") long id) {
	 	ristorocontroller.deleteRistoro(id);
	    return Response.ok().build();
	}
 	
 	@GET
 	@Path("/associaArea/{idRisto}/{idArea}")
 	public Response associaArea(@PathParam("idRisto") long idRisto, @PathParam("idArea") long idArea) {
 		ristorocontroller.associaArea(idRisto, idArea);
 		
        String date = idRisto + "/" + idArea;

        return Response.status(200)
         .entity("associa is called, idRisto/idArea : " + date)
         .build();
 	}
 	
 	@GET
 	@Path("/associaIti/{idRisto}/{idIti}")
 	public Response associaIti(@PathParam("idRisto") long idRisto, @PathParam("idIti") long idIti) {
 		ristorocontroller.associaIti(idRisto, idIti);
 		
        String date = idRisto + "/" + idIti;

        return Response.status(200)
         .entity("associa is called, idRisto/idIti : " + date)
         .build();
 	}
 	
    @GET
	@Path("/itiAssociati/{idRisto}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response itiAssociati(@PathParam("idRisto") long idRisto) {
		List<Long> ids = ristorocontroller.getItiAssociati(idRisto);
		
		return Response.ok(ids).build();
	}
 	
}
