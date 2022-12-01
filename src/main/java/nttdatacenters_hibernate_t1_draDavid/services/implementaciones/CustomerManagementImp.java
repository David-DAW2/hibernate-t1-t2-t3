package nttdatacenters_hibernate_t1_draDavid.services.implementaciones;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apache.maven.archetypes.nttdatacenters_hibernate_t1_draDavid.App;

import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Implementaciones.CustomerDaoImp;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.CustomerDaoI;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Customer;
import nttdatacenters_hibernate_t1_draDavid.services.interfaces.CustomerManagementI;

public class CustomerManagementImp implements CustomerManagementI<Customer> {
	private static final Logger LOGCusMImp = LoggerFactory.getLogger(CustomerManagementImp.class);

	/**
	 * OBJETO DAO PARA PODER IMPLEMENTAR LOS MÉTODOS CRUD
	 */
	CustomerDaoI cusDao;

	/**
	 * CONTRUCTOR, SE INTANCIA EL OBJETO cusDao
	 */
	public CustomerManagementImp() {
		LOGCusMImp.info("Comienza Instanciación capa servicio");
		this.cusDao = new CustomerDaoImp();
	}

	@Override
	public void newCustomer(Customer newCustomer) {

		// VALIDAR LA EXISTENCIA DEL CLIENTE
		if (newCustomer != null) {

			// INSERTAR EL CLIENTE
			cusDao.insert(newCustomer);

		}
	}

	@Override
	public void removeCustomer(Customer delCustomer) {

		// VALIDAR LA EXISTENCIA DEL CLIENTE
		if (delCustomer != null) {

			// BORRAR EL CLIENTE
			cusDao.delete(delCustomer);

		}

	}

	@Override
	public Customer getById(long id) {

		// INSTANCIAR OBJETO CLIENTE
		Customer customer = null;

		// VALIDAR EL ID
		if (id > -1) {

			// ENCONTRAR EL CLIENTE
			customer = cusDao.searchById(id);

		}

		// RETORNAR EL CLIENTE ENCONTRADO
		return customer;
	}

	@Override
	public void modifyCustomer(Customer updCustomer) {

		// VALIDAR LA EXISTENCIA DEL CLIENTE
		if (updCustomer != null) {

			// ACTUALIZAR EL CLIENTE
			cusDao.update(updCustomer);
		}
	}

	@Override
	public Customer getByDNI(int dni) {

		// INSTANCIAR OBJETO CLIENTE

		Customer customer = null;

		// ENCONTRAR EL CLIENTE POR DNI
		customer = cusDao.getCustomerByDni(dni);

		// RETORNAR EL CLIENTE ENCONTRADO
		return customer;
	}

	@Override
	public List<Customer> searchCustomByContractPermanency(int permanency) {
		return cusDao.searchByContractPermanency(permanency);
	}

}
