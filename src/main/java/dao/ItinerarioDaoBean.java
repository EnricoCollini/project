package dao;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Amministratore;
import model.AreaNaturale;
import model.Itinerario;

@Stateless
public class ItinerarioDaoBean implements ItinerarioDao {
	@PersistenceContext(unitName="project")
	protected EntityManager entitymanager;
	
	public ItinerarioDaoBean() {};
	
	@Override
	public Itinerario getItinerario(long id ) {
		return entitymanager.find(Itinerario.class, id);
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

	@Override
	public void associaArea(Itinerario itinerario, AreaNaturale areanaturale) {
		itinerario.aggiungiArea(areanaturale);
		entitymanager.persist(itinerario);
		
	}

	@Override
	public List<Long> areeAssociate(long idIti) {
		Query query2 = entitymanager.createQuery("SELECT a.id FROM AreaNaturale a JOIN a.itinerari i WHERE i.id = :idIti")
				.setParameter("idIti", idIti);
		List<Long> ress = query2.getResultList();
		return ress;
	}

	@Override
	public List<Long> ristoriAssociati(long idIti) {
		Query query3 = entitymanager.createQuery("SELECT r.id FROM Ristoro r JOIN r.itinerari i WHERE i.id = :idIti")
				.setParameter("idIti", idIti);
		List<Long> ress = query3.getResultList();
		return ress;
	}

	@Override
	public List<Long> struttureAssociate(long idIti) {
		Query query4 = entitymanager.createQuery("SELECT s.id FROM StrutturaRicettiva s JOIN s.itinerari i WHERE i.id = :idIti")
				.setParameter("idIti", idIti);
		List<Long> ress = query4.getResultList();
		return ress;
	}

	@Override
	public List<Long> puntiAssociati(long idIti) {
		Query query5 = entitymanager.createQuery("SELECT p.id FROM PuntoInteresseGenerico p JOIN p.itinerari i WHERE i.id = :idIti")
				.setParameter("idIti", idIti);
		List<Long> ress = query5.getResultList();
		return ress;
	}

	@Override
	public void associaAmministratore(Itinerario itinerario, Amministratore amministratore) {
		itinerario.setAmministratore(amministratore);
		entitymanager.persist(itinerario);
		
	}
	
}
