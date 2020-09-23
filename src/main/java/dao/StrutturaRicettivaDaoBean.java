package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.StrutturaRicettiva;

public class StrutturaRicettivaDaoBean implements StrutturaRicettivaDao {
	@PersistenceContext(unitName="project")
	protected EntityManager entitymanager;
	
	public StrutturaRicettivaDaoBean() {};
	
	@Override
	public StrutturaRicettiva getStrutturaRicettiva(String uuid) {
		return entitymanager.find(StrutturaRicettiva.class, uuid);
	}

	@Override
	public void createStrutturaRicettiva(StrutturaRicettiva strutturaricettiva) {
		entitymanager.persist(strutturaricettiva);
		
	}

	@Override
	public void updateStrutturaRicettiva(StrutturaRicettiva strutturaricettiva) {
		entitymanager.merge(strutturaricettiva);
		
	}

	@Override
	public void deleteStrutturaRicettiva(StrutturaRicettiva strutturaricettiva) {
		if(!entitymanager.contains(strutturaricettiva)) {
			strutturaricettiva = entitymanager.merge(strutturaricettiva);
		}
		entitymanager.remove(strutturaricettiva);
		
	}

	@Override
	public List<StrutturaRicettiva> getAllStruttureRicettive() {
		Query query = entitymanager.createQuery("SELECT s FROM StrutturaRicettiva s");
		List<StrutturaRicettiva> strutturericettive = query.getResultList();
		return strutturericettive;
	}

}
