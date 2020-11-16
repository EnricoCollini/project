package rest.Services;

import java.util.List;

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

import controller.PuntoInteresseGenericoController;
import model.PuntoInteresseGenerico;

@Path("/puntointeressegenerico")
public class PuntoInteresseGenericoServiceEndpoint {
	
	@Inject
	private PuntoInteresseGenericoController puntointeressecontroller;
	
	//GetAll
	@GET
	@Path("/puntiinteressegenerici")
	@Produces({MediaType.APPLICATION_JSON})
  	public Response getPuntiInteresseGenerico() {
  		return Response.ok(puntointeressecontroller.getAllPuntiInteresseGenerici()).build();
	}
	
	//GetID
	@GET
	@Path("/get/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntoInteresseGenerico(@PathParam("id") long id) {
        PuntoInteresseGenerico puntointeressegenerico = puntointeressecontroller.getPuntoInteresseGenrico(id);
        return Response.ok(puntointeressegenerico).build();
    }
	
	//Create
	@POST
  	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(PuntoInteresseGenerico puntointeressegenerico) {
		puntointeressecontroller.createPuntoInteresseGenerico(puntointeressegenerico);
        return Response.ok().build();
    }
	
	//Update
	@PUT
    @Path("/update/id/{id}")
    public Response update(@PathParam("id") long id, PuntoInteresseGenerico puntointeressegenerico) {
		puntointeressecontroller.updatePuntoInteresseGenerico(id, puntointeressegenerico);
        return Response.ok().build();
    }
  	
    //Delete
    @GET
    @Path("/delete/id/{id}")
    public Response delete(@PathParam("id") long id) {
    	puntointeressecontroller.deletePuntoInteresseGenerico(id);
        return Response.ok().build();
    }
    
    @GET
 	@Path("/associaArea/{idPunto}/{idArea}")
 	public Response associaArea(@PathParam("idPunto") long idPunto, @PathParam("idArea") long idArea) {
 		puntointeressecontroller.associaArea(idPunto, idArea);
 		
        String date = idPunto + "/" + idArea;

        return Response.status(200)
         .entity("associa is called, idPunto/idArea : " + date)
         .build();
 	}
    
    @GET
 	@Path("/associaIti/{idPunto}/{idIti}")
 	public Response associaIti(@PathParam("idPunto") long idPunto, @PathParam("idIti") long idIti) {
 		puntointeressecontroller.associaIti(idPunto, idIti);
 		
        String date = idPunto + "/" + idIti;

        return Response.status(200)
         .entity("associa is called, idPunto/idIti : " + date)
         .build();
 	}
    
    @GET
	@Path("/itiAssociati/{idPunto}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response itiAssociati(@PathParam("idPunto") long idPunto) {
		List<Long> ids = puntointeressecontroller.getItiAssociati(idPunto);
		
		return Response.ok(ids).build();
	}
    
 	@GET
 	@Path("/associaAmministratore/{idPunto}/{idAmministratore}")
 	public Response associaAmministratore(@PathParam("idPunto") long idPunto, @PathParam("idAmministratore") long idAmministratore) {
 		puntointeressecontroller.associaAmministratore(idPunto, idAmministratore);
 		
        String date = idPunto + "/" + idAmministratore;

        return Response.status(200)
         .entity("associa is called, idPunto/idAmministratore : " + date)
         .build();
 	}
	
	
	
	

}
