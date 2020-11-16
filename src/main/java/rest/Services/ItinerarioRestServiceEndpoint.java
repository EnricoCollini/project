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

import controller.ItinerarioController;
import controller.StrutturaRicettivaController;
import model.AreaNaturale;
import model.Itinerario;
import model.StrutturaRicettiva;


@Path("/itinerario")
public class ItinerarioRestServiceEndpoint {
	@Inject
	private ItinerarioController itinerariocontroller;
	

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String sayHello() {
		return "Hello World";
	}
			
    @GET
    @Path("/get/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAreaNaturale(@PathParam("id") long id) {
        Itinerario itinerario = itinerariocontroller.getItinerario(id);
        return Response.ok(itinerario).build();
    }
	    
	@GET
	@Path("/itinerari")
	@Produces({MediaType.APPLICATION_JSON})
	 	public Response getItineari() {
		return Response.ok(itinerariocontroller.getAllItinerari()).build();
	}
	  	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Itinerario itinerario) {
		itinerariocontroller.createItinerario(itinerario);
	    return Response.ok().build();
	   }
	  	
	
	@PUT
	@Path("/update/id/{id}")
	public Response update(@PathParam("id") long id, Itinerario itinerario) {
		itinerariocontroller.updateItinerario(id, itinerario);
		return Response.ok().build();
	}
	  	
		    
	@GET
	@Path("/delete/id/{id}")
	public Response delete(@PathParam("id") long id) {
		itinerariocontroller.deleteItinerario(id);
	    return Response.ok().build();
	}
	
	@GET
 	@Path("/associaArea/{idIti}/{idArea}")
 	public Response associaArea(@PathParam("idIti") long idIti, @PathParam("idArea") long idArea) {
 		itinerariocontroller.associaArea(idIti, idArea);
 		
        String date = idIti + "/" + idArea;

        return Response.status(200)
         .entity("associa is called, idIti/idArea : " + date)
         .build();
 	}
	
	@GET
	@Path("/areeAssociate/{idIti}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response areeAssociate(@PathParam("idIti") long idIti) {
		List<Long> ids = itinerariocontroller.getAreeAssociate(idIti);
		
		return Response.ok(ids).build();
	}
	
	@GET
	@Path("/ristoriAssociati/{idIti}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response ristoriAssociati(@PathParam("idIti") long idIti) {
		List<Long> ids = itinerariocontroller.getRistoriAssociati(idIti);
		
		return Response.ok(ids).build();
	}
	
	@GET
	@Path("/struttureAssociate/{idIti}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response struttureAssociate(@PathParam("idIti") long idIti) {
		List<Long> ids = itinerariocontroller.getStruttureAssociate(idIti);
		
		return Response.ok(ids).build();
	}
	
	@GET
	@Path("/puntiAssociati/{idIti}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response puntiiAssociati(@PathParam("idIti") long idIti) {
		List<Long> ids = itinerariocontroller.getPuntiIntAssociati(idIti);
		
		return Response.ok(ids).build();
	}
	
 	@GET
 	@Path("/associaAmministratore/{idIti}/{idAmministratore}")
 	public Response associaAmministratore(@PathParam("idIti") long idIti, @PathParam("idAmministratore") long idAmministratore) {
 		itinerariocontroller.associaAmministratore(idIti, idAmministratore);
 		
        String date = idIti + "/" + idAmministratore;

        return Response.status(200)
         .entity("associa is called, idIti/idAmministratore : " + date)
         .build();
 	}
	

	

}
