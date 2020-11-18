package controller.Initializers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import dao.AmministratoreDao;
import model.Amministratore;
import model.Ristoro;

@Startup
@Singleton
public class InitializerAmministratore {
	
	@Inject
	private AmministratoreDao amministratoredao;
	private String amministratori;
	
	@PostConstruct
	  public void init() throws FileNotFoundException {
		Gson g = new Gson();
	    try {
	    	amministratori =  new String(Files.readAllBytes(Paths.get("/home/enrico/eclipse-workspace/project/src/main/resources/Amministratori.json")));
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	    
		JsonElement[] amministratoriArrayJsonElement = g.fromJson(amministratori, JsonElement[].class);
		
		for(JsonElement amministratoreJsonElement : amministratoriArrayJsonElement) {
			
			JsonObject amministratoreJsonObject = amministratoreJsonElement.getAsJsonObject();
			String email = amministratoreJsonObject.get("email").getAsString();
			String password = amministratoreJsonObject.get("password").getAsString();
	    	
			Amministratore amministratore = new Amministratore();
	    	
			amministratore.setEmail(email);
			amministratore.setPassword(password);
	    	
			amministratoredao.createAmministratore(amministratore);

		}
	}

}
