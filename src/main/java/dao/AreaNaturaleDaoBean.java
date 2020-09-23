package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import model.AreaNaturale;

public class AreaNaturaleDaoBean implements AreaNaturaleDao {
	@PersistenceContext(unitName="project")
	protected EntityManager entitymanager;
	
	public AreaNaturaleDaoBean() {}
	
	@Override
	public AreaNaturale getAreaNaturale(String uuid) {
		return entitymanager.find(AreaNaturale.class,uuid);
	}

	@Override
	public void createAreaNaturale(AreaNaturale areanaturale) {
		entitymanager.persist(areanaturale);
		
	}

	@Override
	public void updateAreaNaturale(AreaNaturale areanaturale) {
		entitymanager.merge(areanaturale);
		
	}

	@Override
	public void deleteAreaNaturale(AreaNaturale areanaturale) {
		if (!entitymanager.contains(areanaturale)) {
			areanaturale = entitymanager.merge(areanaturale);
        }
		entitymanager.remove(areanaturale);
	}

	@Override
	public List<AreaNaturale> getAllAreeNaturalii() {
		Query query = entitymanager.createQuery("SELECT a FROM AreaNaturale a");
		List<AreaNaturale> ress = query.getResultList();
		return ress;
	}

}
