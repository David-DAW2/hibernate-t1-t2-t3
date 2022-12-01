package nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nttdatacenters_hibernate_t1_draDavid.persistence.EntityManagerUtil;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.CommonDaoI;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.ContractDaoI;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Contract;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Customer;

public class ContractDaoImp extends CommonDaoImp<Contract> implements ContractDaoI {
	EntityManager entitimanager = EntityManagerUtil.getEntityManager();

	/**
	 * Contructor con llamada a la clase padre para setear el tipo de objeto a usar
	 */
	public ContractDaoImp() {
		super.setEntityClass(Contract.class);
	}

	@Override
	public List<Contract> getContractsByCustomerId(long customerId) {
		// Creación lista de clientes
		List<Contract> listOfCustomers = null;

		// Validación de id
		if (customerId > -1) {

			// Creación de objeto Query
			Query query = entitimanager.createQuery("FROM Contract WHERE C_CUSTOMER_ID_FK = " + customerId);
			listOfCustomers = query.getResultList();
		}
		// Retornamos la lista
		return listOfCustomers;
	}
}
