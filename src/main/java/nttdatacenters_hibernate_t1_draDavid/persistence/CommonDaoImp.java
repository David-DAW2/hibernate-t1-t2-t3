package nttdatacenters_hibernate_t1_draDavid.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;




public abstract class CommonDaoImp<T extends AbstractEntity>implements CommonDaoI<T> {
		private Class<T> entityClass;

	
	EntityManager entityManager=EntityManagerUtil.getEntityManager();

	
	
	
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	@Override
	public void insert(T obj) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			entityManager.persist(obj);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}
	@Override
	public List<T> searchAll(T obj) {
		String qlString = "FROM " + entityClass.getName();
	
		Query query = entityManager.createQuery(qlString);
		
		return query.getResultList();
	}
	@Override
	public T searchById(final Long id) {
		return entityManager.find(entityClass, id);
	}
	
	
	
	@Override
	public void delete(T obj) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			entityManager.remove(obj);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}
	
	
	
	@Override
	public void update(T obj) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			entityManager.merge(obj);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

	

}
