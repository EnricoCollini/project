package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AmministratoreDao;

@Stateless
public class AmministratoreController {

	@Inject
	private AmministratoreDao amministratoredao;
		
	public List<Long> getItiAssociati(long idAmministratore){
		return amministratoredao.itinerariAssociati(idAmministratore);
	}
	
	public List<Long> getRistoAssociati(long idAmministratore){
		return amministratoredao.ristoriAssociati(idAmministratore);
	}
	
	public List<Long> getPuntiInteresseAssociati(long idAmministratore){
		return amministratoredao.puntiInteresseAssociati(idAmministratore);
	}
	
	public List<Long> getStruttureAssociate(long idAmministratore){
		return amministratoredao.struttureAssociate(idAmministratore);
	}
	
	public List<Long> getAreeAssociate(long idAmministratore){
		return amministratoredao.areeAssociate(idAmministratore);
	}
	
	public long getIdAmministratore(String emailAdmin) {
		return amministratoredao.getIdAmministratore(emailAdmin);
	}
	
	
}
