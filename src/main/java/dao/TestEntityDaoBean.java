package dao;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.TestEntity;

@Stateless
public class TestEntityDaoBean implements TestEntityDao {
	@PersistenceContext(unitName="project")
	protected EntityManager entitymanager;
	
	public TestEntityDaoBean() {}

	@Override
	public TestEntity getTestEntity(Long id) {
		entitymanager.find(TestEntity.class, id);
		return null;
	}

	@Override
	public void createTestEntity(TestEntity testentity) {
		entitymanager.persist(testentity);
	}

	@Override
	public void updateTestEntity(TestEntity testentity) {
		entitymanager.merge(testentity);
		
	}

	@Override
	public void deleteTestEntity(TestEntity testentity) {
		// TODO Auto-generated method stub
		if (!entitymanager.contains(testentity)) {
			testentity = entitymanager.merge(testentity);
        }
		entitymanager.remove(testentity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestEntity> getAllTestEntity() {
		Query query = entitymanager.createQuery("SELECT a FROM TestEntity a");
		List<TestEntity> ress = query.getResultList();
		return ress;
	}

}
