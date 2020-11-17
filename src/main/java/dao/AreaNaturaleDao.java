package dao;
import java.util.List;
import java.util.UUID;

import model.Amministratore;
import model.AreaNaturale;

public interface AreaNaturaleDao {
	public AreaNaturale getAreaNaturale(long id);
	public void createAreaNaturale(AreaNaturale areanaturale);
	public void updateAreaNaturale(AreaNaturale areanaturale);
	public void deleteAreaNaturale(AreaNaturale areanaturale);
	public List<Long> getAllAreeNaturalii();
	public List<Long> itinerariAssociati(long idArea);
	public void associaAmministratore(AreaNaturale areanaturale, Amministratore amministratore);
}
