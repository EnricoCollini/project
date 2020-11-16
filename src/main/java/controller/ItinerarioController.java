package controller;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AmministratoreDao;
import dao.AreaNaturaleDao;
import dao.ItinerarioDao;
import dao.ItinerarioDaoBean;
import model.Amministratore;
import model.AreaNaturale;
import model.Itinerario;
import model.StrutturaRicettiva;

@Stateless
public class ItinerarioController {
	@Inject
	private ItinerarioDao itinerariodao;
	
	@Inject
	private AreaNaturaleDao areanaturaledao;
	
	@Inject
	private AmministratoreDao amministratoredao;
	
	public Itinerario getItinerario(long id ) {
		return(itinerariodao.getItinerario(id));
	}
	public void createItinerario(Itinerario itinerario) {
		itinerariodao.createItinerario(itinerario);
	}
	public void updateItinerario(long id , Itinerario itinerario) {
		Itinerario updateitinerario = itinerariodao.getItinerario(id);
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
		updateitinerario.setTrack(itinerario.getTrack());
		itinerariodao.updateItinerario(updateitinerario);
	}
	public void deleteItinerario(long id) {
		Itinerario itinerario = itinerariodao.getItinerario(id);
		itinerariodao.deleteItinerario(itinerario);
	}
	public List<Itinerario> getAllItinerari(){
		return(itinerariodao.getAllItinerari());
	}
	
	public void associaArea(long idItinerario, long idArea) {
		Itinerario itinerario = itinerariodao.getItinerario(idItinerario);
		AreaNaturale areanaturale = areanaturaledao.getAreaNaturale(idArea);
		itinerariodao.associaArea(itinerario, areanaturale);
	}
	
	public void associaAmministratore(long idItinerario, long idAmministratore) {
		Itinerario itinerario = itinerariodao.getItinerario(idItinerario);
		Amministratore amministratore = amministratoredao.getAmministratore(idAmministratore);
		itinerariodao.associaAmministratore(itinerario, amministratore);
	}
	
	public List<Long> getAreeAssociate(long idIti){
		return itinerariodao.areeAssociate(idIti);
	}
	public List<Long> getRistoriAssociati(long idIti){
		return itinerariodao.ristoriAssociati(idIti);
	}
	
	public List<Long> getStruttureAssociate(long idIti){
		return itinerariodao.struttureAssociate(idIti);
	}
	
	public List<Long> getPuntiIntAssociati(long idIti){
		return itinerariodao.puntiAssociati(idIti);
	}
}
