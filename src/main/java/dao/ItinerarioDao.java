package dao;

import java.util.List;

import model.Itinerario;

public interface ItinerarioDao {
	public Itinerario getItinerario(String uuid);
	public void createItinerario(Itinerario itinerario);
	public void updateItinerario(Itinerario itinerario);
	public void deleteItinerario(Itinerario itinerario);
	public List<Itinerario> getAllItinerari();
}
