package controller;

import java.util.List;

import dao.ItinerarioDaoBean;
import model.Itinerario;

public class ItinerarioController {
	private ItinerarioDaoBean itinerariodao;
	
	public Itinerario getItinerario(String uuid) {
		return(itinerariodao.getItinerario(uuid));
	}
	public void createItinerario(Itinerario itinerario) {
		itinerariodao.createItinerario(itinerario);
	}
	public void updateItinerario(Itinerario itinerario) {
		itinerariodao.updateItinerario(itinerario);
	}
	public void deleteItinerario(Itinerario itinerario) {
		itinerariodao.deleteItinerario(itinerario);
	}
	public List<Itinerario> getAllItinerari(){
		return(itinerariodao.getAllItinerari());
	}
}
