package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public List<PuntoInteresseGenerico> getPuntiInteresseGenerici() {
		Query query = entitymanager.createQuery("SELECT p FROM PuntoInteresseGenerico p");
		List<PuntoInteresseGenerico> ress = query.getResultList();
		return ress;
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

}
