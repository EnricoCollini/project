package dao;

import java.util.List;

import model.StrutturaRicettiva;

public interface StrutturaRicettivaDao {
	public StrutturaRicettiva getStrutturaRicettiva(String uuid);
	public void createStrutturaRicettiva(StrutturaRicettiva strutturaricettiva);
	public void updateStrutturaRicettiva(StrutturaRicettiva strutturaricettiva);
	public void deleteStrutturaRicettiva(StrutturaRicettiva strutturaricettiva);
	public List<StrutturaRicettiva> getAllStruttureRicettive();
}
