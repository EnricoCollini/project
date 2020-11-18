package dao;

import java.util.List;
import java.util.UUID;

import model.Amministratore;
import model.AreaNaturale;
import model.Itinerario;

public interface ItinerarioDao {
	public Itinerario getItinerario(long id);
	public void createItinerario(Itinerario itinerario);
	public void updateItinerario(Itinerario itinerario);
	public void deleteItinerario(Itinerario itinerario);
	public List<Long> getAllItinerari();
	public void associaArea(Itinerario itinerario, AreaNaturale areanaturale);
	public List<Long> areeAssociate(long idIti);
	public List<Long> ristoriAssociati(long idIti);
	public List<Long> struttureAssociate(long idIti);
	public List<Long> puntiAssociati(long idIti);
	public void associaAmministratore(Itinerario itinerario, Amministratore amministratore);
	
}
