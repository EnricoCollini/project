package rest.Services;

import java.io.Console;
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

import org.json.JSONObject;

import model.AreaNaturale;
import rest.Secured;
import controller.AreaNaturaleController;
import dto.AreaNaturaleDTO;

@Path("/areanaturale")
public class AreaNaturaleRestServiceEndpoint {
	
	@Inject
	private AreaNaturaleController areanaturalecontroller;
	
	
	//test hello world example
	@GET
	@Secured
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
        AreaNaturaleDTO areaDto = areanaturalecontroller.getAreaNaturale(id);
        return Response.ok(areaDto).build();
    }
    
  	@GET
  	@Path("/areenaturali")
  	@Produces({MediaType.APPLICATION_JSON})
  	public Response getAreeNaturali() {
  		return Response.ok(areanaturalecontroller.getAllAreeNaturalii()).build();
  	}
  	
  	@POST
  	@Secured
  	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(AreaNaturale areanaturale) {
    	areanaturalecontroller.createAreaNaturale(areanaturale);
        return Response.ok().build();
    }
  	
  	@PUT
  	@Secured
    @Path("/update/id/{id}")
    public Response update(@PathParam("id") long id, AreaNaturale areanaturale) {
    	areanaturalecontroller.updateAreaNaturale(id ,areanaturale);
        return Response.ok().build();
    }
  	
    
    @GET
    @Secured
    @Path("/delete/id/{id}")
    public Response delete(@PathParam("id") long id) {
    	areanaturalecontroller.deleteAreaNaturale(id);
        return Response.ok().build();
    }
    
    @GET
	@Path("/itiAssociati/{idArea}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response itiAssociati(@PathParam("idArea") long idArea) {
		List<Long> ids = areanaturalecontroller.getItiAssociati(idArea);
		
		return Response.ok(ids).build();
	}
    
    @GET
   	@Path("/ristoAssociati/{idArea}")
   	@Produces({MediaType.APPLICATION_JSON})
   	public Response ristoAssociati(@PathParam("idArea") long idArea) {
   		List<Long> ids = areanaturalecontroller.getRistoAssociati(idArea);
   		
   		return Response.ok(ids).build();
   	}
    
    @GET
   	@Path("/puntiAssociati/{idArea}")
   	@Produces({MediaType.APPLICATION_JSON})
   	public Response puntiAssociati(@PathParam("idArea") long idArea) {
   		List<Long> ids = areanaturalecontroller.getPuntiInteresseAssociati(idArea);
   		
   		return Response.ok(ids).build();
   	}
    
    @GET
   	@Path("/struttureAssociati/{idArea}")
   	@Produces({MediaType.APPLICATION_JSON})
   	public Response struttureAssociati(@PathParam("idArea") long idArea) {
   		List<Long> ids = areanaturalecontroller.getStruttureAssociate(idArea);
   		
   		return Response.ok(ids).build();
   	}
    
    
    
 	@GET
 	@Secured
 	@Path("/associaAmministratore/{idArea}/{idAmministratore}")
 	public Response associaAmministratore(@PathParam("idArea") long idArea, @PathParam("idAmministratore") long idAmministratore) {
 		areanaturalecontroller.associaAmministratore(idArea, idAmministratore);
 		
        String date = idArea + "/" + idAmministratore;

        return Response.status(200)
         .entity("associa is called, idArea/idAmministratore : " + date)
         .build();
 	}
}
