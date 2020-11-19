package dao;

import java.util.List;

import model.Amministratore;

public interface AmministratoreDao {
	public Amministratore getAmministratore(long id);
	public long getIdAmministratore(String emailAdmin);
	public void createAmministratore(Amministratore admin);
	public void deleteAmministratore(Amministratore admin);
	public List<Long> itinerariAssociati(long idAmministratore);
	public List<Long> ristoriAssociati(long idAmministratore);
	public List<Long> puntiInteresseAssociati(long idAmministratore);
	public List<Long> struttureAssociate(long idAmministratore);
	public List<Long> areeAssociate(long idAmministratore);
	public List<String> getJwtTokens();
	
}
