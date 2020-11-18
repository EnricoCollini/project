package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Amministratore;
import model.AreaNaturale;
import model.Itinerario;
import model.PuntoInteresseGenerico;
import model.Ristoro;

@Stateless
public class PuntoInteresseGenericoDaoBean implements PuntoInteresseGenericoDao {
	@PersistenceContext(unitName="project")
	protected EntityManager entitymanager;

	@Override
	public PuntoInteresseGenerico getPuntoInteresseGenerico(long id) {
		return entitymanager.find(PuntoInteresseGenerico.class, id);
		
	}

	@Override
	public void createPuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico) {
		entitymanager.persist(puntointeressegenerico);
	}

	@Override
	public void updatePuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico) {
		entitymanager.merge(puntointeressegenerico);
		
	}

	@Override
	public void deletePuntoInteresseGenerico(PuntoInteresseGenerico puntointeressegenerico) {
		if (!entitymanager.contains(puntointeressegenerico)) {
			puntointeressegenerico = entitymanager.merge(puntointeressegenerico);
        }
		entitymanager.remove(puntointeressegenerico);
		
	}

	@Override
	public List<Long> getPuntiInteresseGenerici() {
		Query query = entitymanager.createQuery("SELECT p.id FROM PuntoInteresseGenerico p");
		List<Long> puntiIds = query.getResultList();
		return puntiIds;
	}

	@Override
	public void associaArea(PuntoInteresseGenerico punto, AreaNaturale areanaturale) {
		punto.setAreanaturale(areanaturale);
		entitymanager.persist(punto);
		
	}

	@Override
	public void associaIti(PuntoInteresseGenerico punto, Itinerario itinerario) {
		punto.aggiungiItinerario(itinerario);
		entitymanager.persist(punto);
		
	}

	@Override
	public List<Long> itinerariAssociati(long idPunto) {
		Query query2 = entitymanager.createQuery("SELECT i.id FROM Itinerario i JOIN i.puntiinteressegenerici p WHERE p.id = :idPunto")
				.setParameter("idPunto", idPunto);
		List<Long> ress = query2.getResultList();
		return ress;
	}

	@Override
	public void associaAmministratore(PuntoInteresseGenerico punto, Amministratore amministratore) {
		punto.setAmministratore(amministratore);
		entitymanager.persist(punto);
		
	}

}
