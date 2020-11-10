package dao;

import java.util.List;
import java.util.UUID;

import model.Itinerario;

public interface ItinerarioDao {
	public Itinerario getItinerario(long id);
	public void createItinerario(Itinerario itinerario);
	public void updateItinerario(Itinerario itinerario);
	public void deleteItinerario(Itinerario itinerario);
	public List<Itinerario> getAllItinerari();
}
