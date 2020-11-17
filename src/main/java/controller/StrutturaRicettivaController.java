package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AmministratoreDao;
import dao.AreaNaturaleDao;
import dao.ItinerarioDao;
import dao.StrutturaRicettivaDao;
import dao.StrutturaRicettivaDaoBean;
import dto.RistoroDTO;
import dto.StrutturaRicettivaDTO;
import dto.mapper.RistoroMapper;
import dto.mapper.StrutturaRicettivaMapper;
import model.Amministratore;
import model.AreaNaturale;
import model.Itinerario;
import model.Ristoro;
import model.StrutturaRicettiva;

@Stateless
public class StrutturaRicettivaController {
	
	@Inject
	private StrutturaRicettivaDao strutturaricettivadao;
	
	@Inject
	private AreaNaturaleDao areanaturaledao;
	
	@Inject
	private ItinerarioDao itinerariodao;
	
	@Inject
	private AmministratoreDao amministratoredao;
	
	@Inject
	private StrutturaRicettivaMapper strutturaMapper;
	
	public StrutturaRicettivaDTO getStrutturaRicettiva(long id ) {
		return(strutturaMapper.convertToDto(id));
	}
	public void createStrutturaRicettiva(StrutturaRicettiva strutturaricettiva) {
		strutturaricettivadao.createStrutturaRicettiva(strutturaricettiva);
	}
	public void updateStrutturaRicettiva(long id, StrutturaRicettiva strutturaricettiva) {
		StrutturaRicettiva updatestrutturaricettiva = strutturaricettivadao.getStrutturaRicettiva(id);
		
		updatestrutturaricettiva.setAddress(strutturaricettiva.getAddress());
		updatestrutturaricettiva.setCity(strutturaricettiva.getCity());
		updatestrutturaricettiva.setEmail(strutturaricettiva.getEmail());
		updatestrutturaricettiva.setLatitude(strutturaricettiva.getLatitude());
		updatestrutturaricettiva.setLongitude(strutturaricettiva.getLongitude());
		updatestrutturaricettiva.setName(strutturaricettiva.getName());
		updatestrutturaricettiva.setPhonenumber(strutturaricettiva.getPhonenumber());
		updatestrutturaricettiva.setProvince(strutturaricettiva.getProvince());
		updatestrutturaricettiva.setStrutturaricettivatipology(strutturaricettiva.getStrutturaricettivatipology());		
		strutturaricettivadao.updateStrutturaRicettiva(updatestrutturaricettiva);
	}
	
	public void deleteStrutturaRicettiva(long id) {
		StrutturaRicettiva strutturaricettiva = strutturaricettivadao.getStrutturaRicettiva(id);
		strutturaricettivadao.deleteStrutturaRicettiva(strutturaricettiva);
	}

	public List<StrutturaRicettivaDTO> getAllStruttureRicettive(){
		List<Long> strutturaId = strutturaricettivadao.getAllStruttureRicettive();
		List<StrutturaRicettivaDTO> strutture = new ArrayList<StrutturaRicettivaDTO>();
		for (long id: strutturaId) {
			strutture.add(strutturaMapper.convertToDto(id));
		}
		return strutture;
	}
	
	public void associaArea(long idStruttura, long idArea) {
		StrutturaRicettiva strutturaricettiva = strutturaricettivadao.getStrutturaRicettiva(idStruttura);
		AreaNaturale areanaturale = areanaturaledao.getAreaNaturale(idArea);
		strutturaricettivadao.associaArea(strutturaricettiva, areanaturale);
	}
	
	public void associaAmministratore(long idStruttura, long idAmministratore) {
		StrutturaRicettiva strutturaricettiva = strutturaricettivadao.getStrutturaRicettiva(idStruttura);
		Amministratore amministratore = amministratoredao.getAmministratore(idAmministratore);
		strutturaricettivadao.associaAmministratore(strutturaricettiva, amministratore);
	}
	
	public void associaIti(long idStruttura, long idIti) {
		StrutturaRicettiva strutturaricettiva = strutturaricettivadao.getStrutturaRicettiva(idStruttura);
		Itinerario itinerario = itinerariodao.getItinerario(idIti);
		strutturaricettivadao.associaIti(strutturaricettiva, itinerario);
	}
	
	public List<Long> getItiAssociati(long idStru){
		return strutturaricettivadao.itinerariAssociati(idStru);
	}
	
	
	
}
