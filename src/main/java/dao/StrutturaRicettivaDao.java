package dao;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;

import model.StrutturaRicettiva;

public interface StrutturaRicettivaDao {
	public StrutturaRicettiva getStrutturaRicettiva(UUID uuid);
	public void createStrutturaRicettiva(StrutturaRicettiva strutturaricettiva);
	public void updateStrutturaRicettiva(StrutturaRicettiva strutturaricettiva);
	public void deleteStrutturaRicettiva(StrutturaRicettiva strutturaricettiva);
	public List<StrutturaRicettiva> getAllStruttureRicettive();
}
