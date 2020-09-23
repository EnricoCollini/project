package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Ristoro;

public class RistoroDaoBean implements RistoroDao {
	@PersistenceContext(unitName="project")
	protected EntityManager entitymanager;
	
	public RistoroDaoBean() {};
	
	@Override
	public Ristoro getRistoro(String uuid) {
		return entitymanager.find(Ristoro.class, uuid);
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

}
