package dao;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Amministratore;
import model.AreaNaturale;

@Stateless
public class AreaNaturaleDaoBean implements AreaNaturaleDao {
	@PersistenceContext(unitName="project")
	protected EntityManager entitymanager;

	public AreaNaturaleDaoBean() {}
	
	@Override
	public AreaNaturale getAreaNaturale(long number ) {
		AreaNaturale area = entitymanager.find(AreaNaturale.class,number);
		return area;
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
	public List<Long> getAllAreeNaturalii() {
		Query query = entitymanager.createQuery("SELECT a.id FROM AreaNaturale a");
		List<Long> ress = query.getResultList();
		System.out.println("RISULTATO: " + ress);
		return ress;
	}

	@Override
	public List<Long> itinerariAssociati(long idArea) {
		Query query2 = entitymanager.createQuery("SELECT i.id FROM Itinerario i JOIN i.areenaturali a WHERE a.id = :idArea")
				.setParameter("idArea", idArea);
		List<Long> ress = query2.getResultList();
		return ress;
	}

	@Override
	public void associaAmministratore(AreaNaturale areanaturale, Amministratore amministratore) {
		areanaturale.setAmministratore(amministratore);
		entitymanager.persist(areanaturale);
		
	}

}
