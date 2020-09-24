package controller;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.TestEntityDao;
import model.TestEntity;

@Stateless
public class TestEntityController {
	
	@Inject
	private TestEntityDao testentitydao;
	
	public TestEntity getTestEntity(Long  id) {
		return testentitydao.getTestEntity(id);
	}
	
	public List<TestEntity> getAllTestEntity(){
		return(testentitydao.getAllTestEntity());
	}
	
	public void create(TestEntity testentity) {
		testentitydao.createTestEntity(testentity);
	}
	
	public void update(Long id, TestEntity testentity) {
		TestEntity updatetestentity = testentitydao.getTestEntity(id);
		updatetestentity.setName(testentity.getName());
	}
	public void delete(Long id) {
		TestEntity testentity = testentitydao.getTestEntity(id);
		testentitydao.deleteTestEntity(testentity);
	}
	

}
