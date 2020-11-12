package dao;

import model.Amministratore;

public interface AmministratoreDao {
	public Amministratore getAmministratore(long id);
	public void createAmministratore(Amministratore admin);
	public void deleteAmministratore(Amministratore admin);	
}
