package rest.Services;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.AreaNaturaleController;
import controller.RistoroController;
import controller.StrutturaRicettivaController;
import dto.StrutturaRicettivaDTO;
import model.Ristoro;
import model.StrutturaRicettiva;
import rest.Secured;

@Path("strutturaricettiva")
public class StrutturaRicettivaRestServiceEndpoint {
	@Inject
	private StrutturaRicettivaController strutturaricettivacontroller;

	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String sayHello() {
		return "Hello World";
	}
		
	@GET
	@Path("/get/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStrutturaRicettiva(@PathParam("id") long id) {
		StrutturaRicettivaDTO strutturaDto = strutturaricettivacontroller.getStrutturaRicettiva(id);
	    return Response.ok(strutturaDto).build();
	}
	    
	@GET
	@Path("/strutturericettive")
	@Produces({MediaType.APPLICATION_JSON})
  	public Response getStruttureRicettive() {
		return Response.ok(strutturaricettivacontroller.getAllStruttureRicettive()).build();
	}
	  	
	@POST
	@Secured
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(StrutturaRicettiva strutturaricettiva) {
		strutturaricettivacontroller.createStrutturaRicettiva(strutturaricettiva);
	    return Response.ok().build();
    }
	  	
 	@PUT
 	@Secured
    @Path("/update/id/{id}")
    public Response update(@PathParam("id") long id, StrutturaRicettiva strutturaricettiva) {
 		strutturaricettivacontroller.updateStrutturaRicettiva(id,strutturaricettiva);
        return Response.ok().build();
    }
	  	
	    
 	@GET
 	@Secured
	@Path("/delete/id/{id}")
	public Response delete(@PathParam("id") long id) {
		strutturaricettivacontroller.deleteStrutturaRicettiva(id);
	    return Response.ok().build();
	}
 	
 	@GET
 	@Path("/associaArea/{idStru}/{idArea}")
 	public Response associaArea(@PathParam("idStru") long idStru, @PathParam("idArea") long idArea) {
 		strutturaricettivacontroller.associaArea(idStru, idArea);
 		
        String date = idStru + "/" + idArea;

        return Response.status(200)
         .entity("associa is called, idStru/idArea : " + date)
         .build();
 	}
 	
 	@GET
 	@Secured
 	@Path("/associaIti/{idStru}/{idIti}")
 	public Response associaIti(@PathParam("idStru") long idStru, @PathParam("idIti") long idIti) {
 		strutturaricettivacontroller.associaIti(idStru, idIti);
 		
        String date = idStru + "/" + idIti;

        return Response.status(200)
         .entity("associa is called, idStru/idIti : " + date)
         .build();
 	}
 	
    @GET
	@Path("/itiAssociati/{idStru}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response itiAssociati(@PathParam("idStru") long idStru) {
		List<Long> ids = strutturaricettivacontroller.getItiAssociati(idStru);
		
		return Response.ok(ids).build();
	}
    
 	@GET
 	@Secured
 	@Path("/associaAmministratore/{idStru}/{idAmministratore}")
 	public Response associaAmministratore(@PathParam("idStru") long idStru, @PathParam("idAmministratore") long idAmministratore) {
 		strutturaricettivacontroller.associaAmministratore(idStru, idAmministratore);
 		
        String date = idStru + "/" + idAmministratore;

        return Response.status(200)
         .entity("associa is called, idStru/idAmministratore : " + date)
         .build();
 	}
 	

}
