package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Amministratore;
import model.AreaNaturale;

@Stateless
public class AmministratoreDaoBean implements AmministratoreDao {
	
	@PersistenceContext(unitName="project")
	protected EntityManager entitymanager;

	public AmministratoreDaoBean() {}

	@Override
	public Amministratore getAmministratore(long id) {
		return entitymanager.find(Amministratore.class,id);
	}

	@Override
	public void createAmministratore(Amministratore admin) {
		entitymanager.persist(admin);
		
	}

	@Override
	public void deleteAmministratore(Amministratore admin) {
		if (!entitymanager.contains(admin)) {
			admin = entitymanager.merge(admin);
        }
		entitymanager.remove(admin);
	}

	@Override
	public List<Long> itinerariAssociati(long idAmministratore) {
		Query query2 = entitymanager.createQuery("SELECT i.id FROM Itinerario i JOIN i.amministratore a WHERE a.id = :idAmministratore")
				.setParameter("idAmministratore", idAmministratore);
		List<Long> ress = query2.getResultList();
		return ress;
	}

	@Override
	public List<Long> ristoriAssociati(long idAmministratore) {
		Query query2 = entitymanager.createQuery("SELECT r.id FROM Ristoro r JOIN r.amministratore a WHERE a.id = :idAmministratore")
				.setParameter("idAmministratore", idAmministratore);
		List<Long> ress = query2.getResultList();
		return ress;
	}

	@Override
	public List<Long> puntiInteresseAssociati(long idAmministratore) {
		Query query2 = entitymanager.createQuery("SELECT p.id FROM PuntoInteresseGenerico p JOIN p.amministratore a WHERE a.id = :idAmministratore")
				.setParameter("idAmministratore", idAmministratore);
		List<Long> ress = query2.getResultList();
		return ress;
	}

	@Override
	public List<Long> struttureAssociate(long idAmministratore) {
		Query query2 = entitymanager.createQuery("SELECT s.id FROM StrutturaRicettiva s JOIN s.amministratore a WHERE a.id = :idAmministratore")
				.setParameter("idAmministratore", idAmministratore);
		List<Long> ress = query2.getResultList();
		return ress;
	}

	@Override
	public List<Long> areeAssociate(long idAmministratore) {
		Query query2 = entitymanager.createQuery("SELECT n.id FROM AreaNaturale n JOIN n.amministratore a WHERE a.id = :idAmministratore")
				.setParameter("idAmministratore", idAmministratore);
		List<Long> ress = query2.getResultList();
		return ress;
	}

}
