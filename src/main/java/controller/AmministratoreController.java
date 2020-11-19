package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AmministratoreDao;
import model.Amministratore;

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
	
	public boolean checkIfAuth(String jwt) {
		System.out.println(jwt);
		List<String> listaJWT = amministratoredao.getJwtTokens();
		if(listaJWT.contains(jwt)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validate(Amministratore amministratore) {
		Long index = amministratoredao.getIdAmministratore(amministratore.getEmail());
		if(index>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setToken(long id, String jwt) {
		Amministratore amministratore = amministratoredao.getAmministratore(id);
		amministratore.setJwt(jwt);
	}
	
}
