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
import model.AreaNaturale;
import model.AreaNaturaleTypology;

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
public class InitializerAreeNaturali {
	@Inject
	private AreaNaturaleDao areanaturaledao;
	private String areenaturali;
	
	@PostConstruct
	  public void init() throws FileNotFoundException {
		//System.out.println("name");
		Gson g = new Gson();
	    try {
			areenaturali =  new String(Files.readAllBytes(Paths.get("/home/enrico/eclipse-workspace/project/src/main/resources/AreeNaturali.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonElement[] areenaturaliArrayJsonElement = g.fromJson(areenaturali, JsonElement[].class);
		for(JsonElement areanaturaleJsonElement : areenaturaliArrayJsonElement) {
			JsonObject areanaturaleJsonObject = areanaturaleJsonElement.getAsJsonObject();
			String name = areanaturaleJsonObject.get("name").getAsString();
			String description = areanaturaleJsonObject.get("description").getAsString();
			String city = areanaturaleJsonObject.get("city").getAsString();
			String province = areanaturaleJsonObject.get("province").getAsString();
			Float latitude = areanaturaleJsonObject.get("latitude").getAsFloat();
			Float longitude = areanaturaleJsonObject.get("longitude").getAsFloat();
			String areanaturaletypology = areanaturaleJsonObject.get("areanaturaletypology").getAsString();
			AreaNaturale areanaturale = new AreaNaturale();
			areanaturale.setName(name);
			areanaturale.setDescription(description);
			areanaturale.setCity(city);
			areanaturale.setProvince(province);
			areanaturale.setLatitude(latitude);
			areanaturale.setLongitude(longitude);
			areanaturale.setAreanaturaletypology(this.getAreaTypology(areanaturaletypology));
			areanaturaledao.createAreaNaturale(areanaturale);
			//System.out.println(name);
		}

	    
	    
	    
	  }
	
	public AreaNaturaleTypology getAreaTypology(String areaTypoString) {
		if(areaTypoString == "PARCONAZIONALE") {
			return(AreaNaturaleTypology.PARCONAZIONALE);
		}else
		if(areaTypoString == "PARCOREGIONALE") {
			return(AreaNaturaleTypology.PARCONAZIONALE);
		}else
		if(areaTypoString == "PARCOPROVINCIALE") {
			return(AreaNaturaleTypology.PARCONAZIONALE);
		}else
		if(areaTypoString == "RISERVANATURALESTATALE") {
			return(AreaNaturaleTypology.PARCONAZIONALE);
		}else
		if(areaTypoString == "RISERVANATURALEPROVINCIALE") {
			return(AreaNaturaleTypology.PARCONAZIONALE);
		}else
		if(areaTypoString == "AREANATURALEPROTETTADIINTERESSELOCALE") {
			return(AreaNaturaleTypology.PARCONAZIONALE);
		}else {
			return(AreaNaturaleTypology.PARCONAZIONALE);
		}

	}

}
