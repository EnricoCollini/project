package rest.Services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.AmministratoreController;

@Path("/amministratore")
public class AmministratoreRestServicesEndpoint {
	
	@Inject
	private AmministratoreController amministratorecontroller;
	
	@GET
	@Path("/itiAssociati/{idAmministratore}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response itiAssociati(@PathParam("idAmministratore") long idAmministratore) {
		List<Long> ids = amministratorecontroller.getItiAssociati(idAmministratore);
		
		return Response.ok(ids).build();
	}
    
    @GET
   	@Path("/ristoAssociati/{idAmministratore}")
   	@Produces({MediaType.APPLICATION_JSON})
   	public Response ristoAssociati(@PathParam("idAmministratore") long idAmministratore) {
   		List<Long> ids = amministratorecontroller.getRistoAssociati(idAmministratore);
   		
   		return Response.ok(ids).build();
   	}
    
    @GET
   	@Path("/puntiAssociati/{idAmministratore}")
   	@Produces({MediaType.APPLICATION_JSON})
   	public Response puntiAssociati(@PathParam("idAmministratore") long idAmministratore) {
   		List<Long> ids = amministratorecontroller.getPuntiInteresseAssociati(idAmministratore);
   		
   		return Response.ok(ids).build();
   	}
    
    @GET
   	@Path("/struttureAssociati/{idAmministratore}")
   	@Produces({MediaType.APPLICATION_JSON})
   	public Response struttureAssociati(@PathParam("idAmministratore") long idAmministratore) {
   		List<Long> ids = amministratorecontroller.getStruttureAssociate(idAmministratore);
   		
   		return Response.ok(ids).build();
   	}
    
    @GET
   	@Path("/areeAssociate/{idAmministratore}")
   	@Produces({MediaType.APPLICATION_JSON})
   	public Response areeAssociate(@PathParam("idAmministratore") long idAmministratore) {
   		List<Long> ids = amministratorecontroller.getAreeAssociate(idAmministratore);
   		
   		return Response.ok(ids).build();
   	}

}
