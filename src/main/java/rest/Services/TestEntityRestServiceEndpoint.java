package rest.Services;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


import controller.TestEntityController;
import dao.TestEntityDao;
import model.TestEntity;

@Path("/test")
public class TestEntityRestServiceEndpoint {

	@Inject
	private TestEntityController testentitycontroller;
	
	
	//test hello world example
	@GET
	@Path("/uuid")
	@Produces({MediaType.TEXT_PLAIN})
	public UUID sayHello() {
		UUID test = UUID.randomUUID();
		return(test);
	}
	
	@GET
	@Path("/ciao")
	@Produces({MediaType.APPLICATION_JSON})
	public String sayHello2() {
		return "Hello World";
	}
	
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(TestEntity testentity) {
    	testentitycontroller.create(testentity);
    	//testentitydao.createTestEntity(testentity);
        return Response.ok().build();
    }
    
    @GET
    @Path("/alltestentity")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTestEntity() {
    	return Response.ok(testentitycontroller.getAllTestEntity()).build();
    }
	
	
	
	
		
}
