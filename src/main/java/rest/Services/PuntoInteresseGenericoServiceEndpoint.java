package rest.Services;

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
	
	
	
	

}
