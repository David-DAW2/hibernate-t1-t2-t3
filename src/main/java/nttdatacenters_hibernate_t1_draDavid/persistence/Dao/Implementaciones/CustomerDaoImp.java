package nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import nttdatacenters_hibernate_t1_draDavid.persistence.EntityManagerUtil;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.CustomerDaoI;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Contract;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Customer;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Office;

public class CustomerDaoImp extends CommonDaoImp<Customer> implements CustomerDaoI {
	EntityManager entitymanager = EntityManagerUtil.getEntityManager();

	/**
	 * Contructor con llamada a la clase padre para setear el tipo de objeto a usar
	 */
	public CustomerDaoImp() {
		super.setEntityClass(Customer.class);
	}

	@Override
	public Customer getCustomerByDni(int dni) {
		// Resultado.
		Customer customer = null;

		// Verificación de nulidad.
		if (dni > -1) {

			// Obtención del jugador por ID.
			Query query = entitymanager.createQuery("FROM Customer WHERE C_DNI= " + dni);
			customer = (Customer) query.getResultList().get(0);

		}
		// Retorno del Cliente encontrado.
		return customer;
	}

	@Override
	public List<Customer> searchByContractPermanency(int permanency) {

		// Creación del objeto CriteriaBuilder
		final CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		// Creación del objeto CriteriaQuery con definicion de la clase usada.
		final CriteriaQuery<Customer> cquery = cb.createQuery(Customer.class);

		// Declaración de la entidad a consultar
		final Root<Customer> rootP = cquery.from(Customer.class);

		// Declaración del Join entre tablas
		final Join<Customer, Contract> JoinT = rootP.join("contracts");

		// Declaración de WHERE
		final Predicate pr = cb.equal(JoinT.get("permanencia"), permanency);

		// Creación de la consulta
		cquery.select(rootP).where(cb.and(pr));

		// Retorno de los Clientes encontrados.
		return entityManager.createQuery(cquery).getResultList();
	}

}
