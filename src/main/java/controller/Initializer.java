package controller;

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

import java.io.*;
import java.util.*;
//import com.google.gson.JsonParser;

//import org.json.simple.parser.JSONParser;

//import org.json.*;
import java.io.*;
import java.util.*;

import com.google.gson.*;


@Startup
@Singleton
public class Initializer {
	@Inject
	private AreaNaturaleDao areanaturaledao;
	private String areenaturali;
	
	@PostConstruct
	  public void init() throws FileNotFoundException {
		Gson g = new Gson();
	    try {
			areenaturali =  new String(Files.readAllBytes(Paths.get("/home/enrico/eclipse-workspace/project/src/main/resources/AreeNaturali.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    String jsonString = "{ \"name\": \"Baeldung\", \"java\": true }";

	    
		JsonElement[] areenaturaliArrayJsonElement = g.fromJson(areenaturali, JsonElement[].class);
		for(JsonElement areanaturaleJsonElement : areenaturaliArrayJsonElement) {
			JsonObject areanaturaleJsonObject = areanaturaleJsonElement.getAsJsonObject();
			String nome = areanaturaleJsonObject.get("name").getAsString();
			System.out.println(nome);
		}

	    
	    
	    
	  }
	
	
	
	
	
	
	

}
