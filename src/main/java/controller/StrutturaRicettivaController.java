package controller;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AreaNaturaleDao;
import dao.StrutturaRicettivaDao;
import dao.StrutturaRicettivaDaoBean;
import model.AreaNaturale;
import model.Ristoro;
import model.StrutturaRicettiva;

@Stateless
public class StrutturaRicettivaController {
	
	@Inject
	private StrutturaRicettivaDao strutturaricettivadao;
	
	@Inject
	private AreaNaturaleDao areanaturaledao;
	
	public StrutturaRicettiva getStrutturaRicettiva(long id ) {
		return(strutturaricettivadao.getStrutturaRicettiva(id));
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
	public List<StrutturaRicettiva> getAllStruttureRicettive(){
		return(strutturaricettivadao.getAllStruttureRicettive());
	}
	
	public void associaArea(long idStruttura, long idArea) {
		StrutturaRicettiva strutturaricettiva = strutturaricettivadao.getStrutturaRicettiva(idStruttura);
		AreaNaturale areanaturale = areanaturaledao.getAreaNaturale(idArea);
		strutturaricettivadao.associaArea(strutturaricettiva, areanaturale);
	}
	
}
