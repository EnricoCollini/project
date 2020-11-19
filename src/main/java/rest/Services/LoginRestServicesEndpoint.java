package rest.Services;

import java.util.Date;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import controller.AmministratoreController;
import dao.AmministratoreDao;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.Amministratore;
import rest.Secured;

@Path("/auth")
public class LoginRestServicesEndpoint {

	@Inject
	AmministratoreController amministratorecontroller;
	

	@Secured
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String sayHello() {
		return "Hello World";
	}
	
//
//    @GET
//    @Path("/test")
//    public Response test(@Context HttpHeaders headers) {
//        String jwtSent = headers.getRequestHeader("authorization").get(0).split(" ")[1];
//        if(amministratorecontroller.checkIfAuth(jwtSent)) {
//            return Response.status(200)
//                    .entity("The user can do the request"+ jwtSent)
//                    .build();
//        }
//        else {
//        	 return Response.status(Status.UNAUTHORIZED)
//                     .entity("The user is not authorized"+ jwtSent)
//                     .build();
//        }
//    }
//	
	
	@POST
	@Path("/genTokenForUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response genTokenForUser(Amministratore amministratore) {
		long tempo = System.currentTimeMillis();
		boolean status = amministratorecontroller.validate(amministratore);
		if(status) {
			String KEY = "my_key";
			String jwt = Jwts.builder()
					.signWith(SignatureAlgorithm.HS256, KEY)
					.setSubject("bene")
					.setIssuedAt(new Date(tempo))
					.setExpiration(new Date(tempo + 90000000))
					.compact();
			amministratorecontroller.setToken(amministratorecontroller.getIdAmministratore(amministratore.getEmail()), jwt);
			JsonObject  json = Json.createObjectBuilder()
					.add("JWT", jwt).build();
			return Response.status(Status.CREATED).entity(json).build();
		}
		else {
			return Response.status(Status.UNAUTHORIZED).build();
		}
	}

}
