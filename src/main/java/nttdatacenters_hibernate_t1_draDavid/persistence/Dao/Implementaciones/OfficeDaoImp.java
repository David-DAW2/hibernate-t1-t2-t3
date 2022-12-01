package nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Implementaciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Root;

import nttdatacenters_hibernate_t1_draDavid.persistence.EntityManagerUtil;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.OfficeDaoI;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Office;

public class OfficeDaoImp extends CommonDaoImp<Office> implements OfficeDaoI{

	EntityManager entityManager= EntityManagerUtil.getEntityManager();
	/**
	 * Contructor con llamada a la clase padre para setear el tipo de objeto a usar
	 */
	
	public OfficeDaoImp() {
		super.setEntityClass(Office.class);
	}


	@Override
	public List<Office> searchByNumberOfWorkers(int numeroTrabajadores) {
		// Creación del objeto CriteriaBuilder
		final CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		// Creación del objeto CriteriaQuery con definicion de la clase usada.
		final CriteriaQuery<Office> cquery = cb.createQuery(Office.class);

		// Declaración de la entidad a consultar
		final Root<Office> rootP = cquery.from(Office.class);
		
		// Declaración de WHERE
		final Predicate pr = cb.greaterThan(rootP.<Integer>get("numTrabajadores"), numeroTrabajadores);

		// Creación de la consulta
		cquery.select(rootP).where(cb.and(pr));

		
		// Retorno de los Clientes encontrados.
		return entityManager.createQuery(cquery).getResultList();
	}


	
	
}
