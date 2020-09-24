package controller;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ItinerarioDao;
import dao.ItinerarioDaoBean;
import model.Itinerario;
import model.StrutturaRicettiva;

@Stateless
public class ItinerarioController {
	@Inject
	private ItinerarioDao itinerariodao;
	
	public Itinerario getItinerario(UUID uuid) {
		return(itinerariodao.getItinerario(uuid));
	}
	public void createItinerario(Itinerario itinerario) {
		itinerariodao.createItinerario(itinerario);
	}
	public void updateItinerario(UUID uuid, Itinerario itinerario) {
		Itinerario updateitinerario = itinerariodao.getItinerario(uuid);
		updateitinerario.setDescription(itinerario.getDescription());
		updateitinerario.setEndcity(itinerario.getEndcity());
		updateitinerario.setEndlatitude(itinerario.getEndlatitude());
		updateitinerario.setEndlongitude(itinerario.getEndlongitude());
		updateitinerario.setEndprovince(itinerario.getEndprovince());
		updateitinerario.setImage(itinerario.getImage());
		updateitinerario.setName(itinerario.getName());
		updateitinerario.setStartcity(itinerario.getStartcity());
		updateitinerario.setStartlatitude(itinerario.getStartlatitude());
		updateitinerario.setStartlongitude(itinerario.getStartlongitude());
		updateitinerario.setStartprovince(itinerario.getStartprovince());
		itinerariodao.updateItinerario(updateitinerario);
	}
	public void deleteItinerario(UUID uuid) {
		Itinerario itinerario = itinerariodao.getItinerario(uuid);
		itinerariodao.deleteItinerario(itinerario);
	}
	public List<Itinerario> getAllItinerari(){
		return(itinerariodao.getAllItinerari());
	}
}
