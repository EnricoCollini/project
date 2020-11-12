package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
