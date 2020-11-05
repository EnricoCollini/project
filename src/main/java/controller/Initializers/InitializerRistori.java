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
import dao.RistoroDao;
import model.AreaNaturale;
import model.AreaNaturaleTypology;
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
public class InitializerRistori {
	@Inject 
	private RistoroDao ristorodao;
	private String ristori;
	
	@PostConstruct
	  public void init() throws FileNotFoundException {
		Gson g = new Gson();
	    try {
	    	ristori =  new String(Files.readAllBytes(Paths.get("/home/andrea/eclipse-workspace/project/src/main/resources/Ristori.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		JsonElement[] ristoriArrayJsonElement = g.fromJson(ristori, JsonElement[].class);
		
		for(JsonElement ristoroJsonElement : ristoriArrayJsonElement) {
			
			JsonObject ristoroJsonObject = ristoroJsonElement.getAsJsonObject();
			String name = ristoroJsonObject.get("cnome").getAsString();
	    	String city = ristoroJsonObject.get("ccomune").getAsString();
	    	String province = ristoroJsonObject.get("cprovincia").getAsString();
	    	Float latitude = ristoroJsonObject.get("clatitudine").getAsFloat();
	    	Float longitude = ristoroJsonObject.get("clongitudine").getAsFloat();
	    	String phonenumber = ristoroJsonObject.get("ctelefono").getAsString();
	    	String address = ristoroJsonObject.get("cvia").getAsString();
	    	String email = ristoroJsonObject.get("cindirizzo_posta_elettronica").getAsString();
	    	String ristoroTypology = ristoroJsonObject.get("ctipologia").getAsString();
	    	
	    	Ristoro ristoro = new Ristoro();
	    	
	    	ristoro.setName(name);
	    	ristoro.setCity(city);
	    	ristoro.setProvince(province);
	    	ristoro.setLatitude(latitude);
	    	ristoro.setLongitude(longitude);
	    	ristoro.setPhonenumber(phonenumber);
	    	ristoro.setAddress(address);
	    	ristoro.setEmail(email);
	    	ristoro.setRistorotypology(this.getRistoroTypology(ristoroTypology));
	    	

	    	ristorodao.createRistoro(ristoro);
	    	
			//System.out.println(name);
		}
	}
		
		
	public RistoroTypology getRistoroTypology(String ristoroTypeString) {
		if(ristoroTypeString == "Affitacamere") {
			return(RistoroTypology.BOTTEGA);
		}else
		if(ristoroTypeString == "Agriturismi") {
			return(RistoroTypology.RISTORANTE);
		}else{
			return(RistoroTypology.RISTORANTE);
		}
	}

	
}
