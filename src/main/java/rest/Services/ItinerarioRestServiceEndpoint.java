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

import controller.ItinerarioController;
import controller.StrutturaRicettivaController;
import model.Itinerario;
import model.StrutturaRicettiva;


@Path("/itinerario")
public class ItinerarioRestServiceEndpoint {
	//@Inject
	private ItinerarioController itinerariocontroller;
	

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String sayHello() {
		return "Hello World";
	}
			
	@GET
	@Path("/uuid/{uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getItinerario(@PathParam("uuid") UUID uuid) {
		Itinerario itinerario = itinerariocontroller.getItinerario(uuid);
		return Response.ok(itinerario).build();
	}
	    
	@GET
	@Path("/itinerari")
	@Produces({MediaType.APPLICATION_JSON})
	 	public Response getItineari() {
		return Response.ok(itinerariocontroller.getAllItinerari()).build();
	}
	  	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Itinerario itinerario) {
		itinerariocontroller.createItinerario(itinerario);
	    return Response.ok().build();
	   }
	  	
		@PUT
	   @Path("/uuid/{uuid}")
	   public Response update(@PathParam("uuid") UUID uuid, Itinerario itinerario) {
			itinerariocontroller.updateItinerario(uuid, itinerario);
			return Response.ok().build();
	   }
	  	
		    
		@PUT
		@Path("/uuid/{uuid}")
		public Response delete(@PathParam("uuid") UUID uuid) {
			itinerariocontroller.deleteItinerario(uuid);
		    return Response.ok().build();
		}

}
