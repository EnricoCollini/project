package dao;

import java.util.List;
import java.util.UUID;

import model.TestEntity;

public interface TestEntityDao {
	public TestEntity getTestEntity(Long id);
	public void createTestEntity(TestEntity testentity);
	public void updateTestEntity(TestEntity testentity);
	public void deleteTestEntity(TestEntity testentity);
	public List<TestEntity> getAllTestEntity();
}
