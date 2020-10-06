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
import dao.StrutturaRicettivaDao;
import model.AreaNaturale;
import model.AreaNaturaleTypology;
import model.StrutturaRicettiva;
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
public class InitializerStruttureRicettive {
	@Inject 
	private StrutturaRicettivaDao strutturericettivedao;
	private String strutturericettive;
	
	@PostConstruct
	  public void init() throws FileNotFoundException {
		Gson g = new Gson();
	    try {
	    	strutturericettive =  new String(Files.readAllBytes(Paths.get("/home/enrico/eclipse-workspace/project/src/main/resources/StruttureRicettive.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    JsonElement[] strutturericettiveArrayJsonElement = g.fromJson(strutturericettive, JsonElement[].class);
	    for(JsonElement strutturaricettivaJsonElement: strutturericettiveArrayJsonElement) {
	    	JsonObject strutturaricettivaJsonObject = strutturaricettivaJsonElement.getAsJsonObject();
	    	String name = strutturaricettivaJsonObject.get("Nome").getAsString();
	    	String city = strutturaricettivaJsonObject.get("Comune").getAsString();
	    	String province = strutturaricettivaJsonObject.get("Provincia").getAsString();
	    	Float latitude = strutturaricettivaJsonObject.get("Latitudine").getAsFloat();
	    	Float longitude = strutturaricettivaJsonObject.get("Longitudine").getAsFloat();
	    	String phonenumber = strutturaricettivaJsonObject.get("Telefono").getAsString();
	    	String address = strutturaricettivaJsonObject.get("Indirizzo").getAsString();
	    	String email = strutturaricettivaJsonObject.get("Indirizzo posta elettronica").getAsString();
	    	String strutturaricettivatipology = strutturaricettivaJsonObject.get("Tipologia").getAsString();
	    	
	    	StrutturaRicettiva strutturaricettiva = new StrutturaRicettiva();
	    	strutturaricettiva.setName(name);
	    	strutturaricettiva.setCity(city);
	    	strutturaricettiva.setProvince(province);
	    	strutturaricettiva.setLatitude(latitude);
	    	strutturaricettiva.setLongitude(longitude);
	    	strutturaricettiva.setPhonenumber(phonenumber);
	    	strutturaricettiva.setAddress(address);
	    	strutturaricettiva.setEmail(email);
	    	strutturaricettiva.setStrutturaricettivatipology(this.getStrutturaTypology(strutturaricettivatipology));
	    	
	    	strutturericettivedao.createStrutturaRicettiva(strutturaricettiva);
			System.out.println(name);
	    	
	    }
	}
	
	
	public StrutturaRicettivaTypology getStrutturaTypology(String strutturaTypeString) {
		if(strutturaTypeString == "Affitacamere") {
			return(StrutturaRicettivaTypology.AFFITTACAMERE);
		}else
		if(strutturaTypeString == "Agriturismi") {
			return(StrutturaRicettivaTypology.AGRITURISMO);
		}else
		if(strutturaTypeString == "Alberghi - Hotel") {
			return(StrutturaRicettivaTypology.ALBERGOHOTEL);
		}else
		if(strutturaTypeString == "Alloggi Privati") {
			return(StrutturaRicettivaTypology.ALLOGGIOPRIVATO);
		}else {
			return(StrutturaRicettivaTypology.AGRITURISMO);
		}


	}
	

}
