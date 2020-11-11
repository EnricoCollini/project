package dao;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;

import model.AreaNaturale;
import model.Itinerario;
import model.Ristoro;
import model.StrutturaRicettiva;

public interface StrutturaRicettivaDao {
	public StrutturaRicettiva getStrutturaRicettiva(long id);
	public void createStrutturaRicettiva(StrutturaRicettiva strutturaricettiva);
	public void updateStrutturaRicettiva(StrutturaRicettiva strutturaricettiva);
	public void deleteStrutturaRicettiva(StrutturaRicettiva strutturaricettiva);
	public List<StrutturaRicettiva> getAllStruttureRicettive();
	public void associaArea(StrutturaRicettiva strutturaricettiva, AreaNaturale areanaturale);
	public void associaIti(StrutturaRicettiva strutturaricettiva, Itinerario itinerario);
}
