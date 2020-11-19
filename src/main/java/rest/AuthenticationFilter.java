package rest;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.NameBinding;
import javax.ws.rs.Priorities;
import rest.Secured;

import controller.AmministratoreController;


@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter{

	@Inject
	AmministratoreController amministratorecontroller;
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		String jwtSent =authorizationHeader.split(" ")[1];
		if(amministratorecontroller.checkIfAuth(jwtSent)) {
            System.out.println("ok");
        }
        else {
        	 requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
	}

}
