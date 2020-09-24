package controller;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.StrutturaRicettivaDao;
import dao.StrutturaRicettivaDaoBean;
import model.Ristoro;
import model.StrutturaRicettiva;

@Stateless
public class StrutturaRicettivaController {
	
	@Inject
	private StrutturaRicettivaDao strutturaricettivadao;
	
	public StrutturaRicettiva getStrutturaRicettiva(UUID uuid) {
		return(strutturaricettivadao.getStrutturaRicettiva(uuid));
	}
	public void createStrutturaRicettiva(StrutturaRicettiva strutturaricettiva) {
		strutturaricettivadao.createStrutturaRicettiva(strutturaricettiva);
	}
	public void updateStrutturaRicettiva(UUID uuid, StrutturaRicettiva strutturaricettiva) {
		StrutturaRicettiva updatestrutturaricettiva = strutturaricettivadao.getStrutturaRicettiva(uuid);
		
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
	
	public void deleteStrutturaRicettiva(UUID uuid) {
		StrutturaRicettiva strutturaricettiva = strutturaricettivadao.getStrutturaRicettiva(uuid);
		strutturaricettivadao.deleteStrutturaRicettiva(strutturaricettiva);
	}
	public List<StrutturaRicettiva> getAllStruttureRicettive(){
		return(strutturaricettivadao.getAllStruttureRicettive());
	}
}
