package dao;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.AreaNaturale;
import model.Itinerario;
import model.Ristoro;

@Stateless
public class RistoroDaoBean implements RistoroDao {
	@PersistenceContext(unitName="project")
	protected EntityManager entitymanager;
	
	public RistoroDaoBean() {};
	
	@Override
	public Ristoro getRistoro(long id) {
		return entitymanager.find(Ristoro.class, id);
	}

	@Override
	public void createRistoro(Ristoro ristoro) {
		entitymanager.persist(ristoro);
	}

	@Override
	public void updateRistoro(Ristoro ristoro) {
		entitymanager.merge(ristoro);
	}

	@Override
	public void deleteRistoro(Ristoro ristoro) {
		if (!entitymanager.contains(ristoro)) {
			ristoro = entitymanager.merge(ristoro);
        }
		entitymanager.remove(ristoro);
	}

	@Override
	public List<Ristoro> getAllRistori() {
		Query query = entitymanager.createQuery("SELECT r From Ristoro r");
		List<Ristoro> ristori = query.getResultList();
		return ristori;
	}

	@Override
	public void associaArea(Ristoro ristoro, AreaNaturale areanaturale) {
		ristoro.setAreanaturale(areanaturale);
		entitymanager.persist(ristoro);
		
	}

	@Override
	public void associaIti(Ristoro ristoro, Itinerario itinerario) {
		ristoro.aggiungiItinerario(itinerario);
		entitymanager.persist(ristoro);
		
	}

	@Override
	public List<Long> itinerariAssociati(long idRisto) {
		Query query2 = entitymanager.createQuery("SELECT i.id FROM Itinerario i JOIN i.ristori r WHERE r.id = :idRisto")
				.setParameter("idRisto", idRisto);
		List<Long> ress = query2.getResultList();
		return ress;
	}

}
