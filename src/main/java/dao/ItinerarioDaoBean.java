package dao;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Itinerario;

@Stateless
public class ItinerarioDaoBean implements ItinerarioDao {
	@PersistenceContext(unitName="project")
	protected EntityManager entitymanager;
	
	public ItinerarioDaoBean() {};
	
	@Override
	public Itinerario getItinerario(UUID uuid) {
		return entitymanager.find(Itinerario.class, uuid);
	}

	@Override
	public void createItinerario(Itinerario itinerario) {
		entitymanager.persist(itinerario);
		
	}

	@Override
	public void updateItinerario(Itinerario itinerario) {
		entitymanager.merge(itinerario);
		
	}

	@Override
	public void deleteItinerario(Itinerario itinerario) {
		entitymanager.remove(itinerario);
		
	}

	@Override
	public List<Itinerario> getAllItinerari() {
		Query query = entitymanager.createQuery("SELECT a FROM Itinerario a");
		List<Itinerario> ress = query.getResultList();
		return ress;
	}
}
