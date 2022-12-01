package nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import nttdatacenters_hibernate_t1_draDavid.persistence.AbstractEntity;
import nttdatacenters_hibernate_t1_draDavid.persistence.EntityManagerUtil;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.CommonDaoI;

public abstract class CommonDaoImp<T extends AbstractEntity> implements CommonDaoI<T> {
	
	/**
	 * Clase genérica
	 */
	private Class<T> entityClass;
	EntityManager entityManager = EntityManagerUtil.getEntityManager();

	/**
	 * Método para setear la clase genérica al objeto usado
	 * @param entityClass
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void insert(T obj) {
		
		//Intanciamos la clase EntityTransaction
		EntityTransaction tx = entityManager.getTransaction();
		try {
		//Llamar a los metodos para iniciar, insertar el objeto pasado por parámetro y hacer commit
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
		
		//Creación de la query
		String qlString = "FROM " + entityClass.getName();
		
		//Ejecución la query con entityManager
		Query query = entityManager.createQuery(qlString);
		
		//Retorno de la lista de objetos
		return query.getResultList();
	}

	@Override
	public T searchById(final Long id) {
		//Retorno de valores encontrados con el método find
		return entityManager.find(entityClass, id);
	}

	@Override
	public void delete(T obj) {
		//Intanciamos la clase EntityTransaction
		EntityTransaction tx = entityManager.getTransaction();
		try {
			
			//Llamar a los metodos para iniciar, borrar el objeto pasado por parámetro y hacer commit
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
		//Intanciamos la clase EntityTransaction
		EntityTransaction tx = entityManager.getTransaction();
		try {
			
			//Llamar a los metodos para iniciar, actualizar el objeto pasado por parámetro y hacer commit
			tx.begin();
			entityManager.merge(obj);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

}
