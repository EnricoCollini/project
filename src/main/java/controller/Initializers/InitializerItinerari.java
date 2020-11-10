package controller.Initializers;
import javax.inject.Inject;
import javax.json.JsonReader;

import org.json.JSONArray;
import java.nio.file.Files;
import java.nio.file.Paths;



import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import javax.ejb.Stateless;
import dao.AreaNaturaleDao;
import dao.ItinerarioDao;
import dao.RistoroDao;
import model.AreaNaturale;
import model.AreaNaturaleTypology;
import model.Itinerario;
import model.Ristoro;
import model.RistoroTypology;
import model.StrutturaRicettivaTypology;

import java.io.*;
import java.util.*;
//import com.google.gson.JsonParser;

//import org.json.simple.parser.JSONParser;

//import org.json.*;
import java.io.*;
import java.util.*;

import com.google.gson.*;
import com.mysql.cj.jdbc.Clob;

@Startup
@Singleton
public class InitializerItinerari {
	@Inject
	private ItinerarioDao itinerariodao;
	private String itinerari;
	
	@PostConstruct
	  public void init() throws FileNotFoundException {
		
		Gson g = new Gson();
	    try {
	    	itinerari =  new String(Files.readAllBytes(Paths.get("/home/andrea/eclipse-workspace/project/src/main/resources/Itinerari.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		JsonElement[] itinerariArrayJsonElement = g.fromJson(itinerari, JsonElement[].class);
		
		for(JsonElement itinerarioJsonElement : itinerariArrayJsonElement) {
			
			JsonObject itinerarioJsonObject = itinerarioJsonElement.getAsJsonObject();
			String name = itinerarioJsonObject.get("name").getAsString();
	    	String description = itinerarioJsonObject.get("description").getAsString();
	    	
	    	String startcity = itinerarioJsonObject.get("startcity").getAsString();
	    	String startprovince = itinerarioJsonObject.get("startprovince").getAsString();
	    	String endcity = itinerarioJsonObject.get("endcity").getAsString();
	    	String endprovince = itinerarioJsonObject.get("endprovince").getAsString();
	    	
	    	Float startlatitude = itinerarioJsonObject.get("startlatitude").getAsFloat();
	    	Float startlongitude = itinerarioJsonObject.get("startlongitude").getAsFloat();
	    	Float endlatitude = itinerarioJsonObject.get("endlatitude").getAsFloat();
	    	Float endlongitude = itinerarioJsonObject.get("endlongitude").getAsFloat();

	    	String track = itinerarioJsonObject.get("track").getAsString();
	    	
	    	Itinerario itinerario = new Itinerario();
	    	
	    	itinerario.setName(name);
	    	itinerario.setDescription(description);
	    	itinerario.setStartcity(startcity);
	    	itinerario.setStartprovince(startprovince);
	    	itinerario.setEndcity(endcity);
	    	itinerario.setEndprovince(endprovince);
	    	itinerario.setStartlatitude(startlatitude);
	    	itinerario.setStartlongitude(startlongitude);
	    	itinerario.setEndlatitude(endlatitude);
	    	itinerario.setEndlongitude(endlongitude);
	    	itinerario.setTrack(track);
	    	
	    	
	    	itinerariodao.createItinerario(itinerario);

	    	
			System.out.println(name);
		}
	}
	
	
	
	
	
	

}
