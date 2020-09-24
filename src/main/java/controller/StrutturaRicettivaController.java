package controller;

import java.util.List;

import dao.StrutturaRicettivaDaoBean;
import model.StrutturaRicettiva;

public class StrutturaRicettivaController {
	private StrutturaRicettivaDaoBean strutturaricettivadao;
	
	public StrutturaRicettiva getStrutturaRicettiva(String uuid) {
		return(strutturaricettivadao.getStrutturaRicettiva(uuid));
	}
	public void createStrutturaRicettiva(StrutturaRicettiva strutturaricettiva) {
		strutturaricettivadao.createStrutturaRicettiva(strutturaricettiva);
	}
	public void updateStrutturaRicettiva(StrutturaRicettiva strutturaricettiva) {
		strutturaricettivadao.updateStrutturaRicettiva(strutturaricettiva);
	}
	public void deleteStrutturaRicettiva(StrutturaRicettiva strutturaricettiva) {
		strutturaricettivadao.deleteStrutturaRicettiva(strutturaricettiva);
	}
	public List<StrutturaRicettiva> getAllStruttureRicettive(){
		return(strutturaricettivadao.getAllStruttureRicettive());
	}
}
