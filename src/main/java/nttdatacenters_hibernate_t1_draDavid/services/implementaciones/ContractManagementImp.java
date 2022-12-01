package nttdatacenters_hibernate_t1_draDavid.services.implementaciones;

import java.util.List;

import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Implementaciones.ContractDaoImp;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.ContractDaoI;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Contract;
import nttdatacenters_hibernate_t1_draDavid.services.interfaces.ContractManagementI;

public class ContractManagementImp implements ContractManagementI<Contract> {
/**
 * OBJETO DAO PARA PODER IMPLEMENTAR LOS MÉTODOS CRUD
 */
	ContractDaoI contrDao;

	/**
	 * CONTRUCTOR, SE INTANCIA EL OBJETO contrDao
	 */
	public ContractManagementImp() {
		contrDao = new ContractDaoImp();
	}

	@Override
	public void addNewContract(Contract newContract) {

		// validar la existencia del contrato
		if (newContract != null) {

			// Insertar el contrato
			contrDao.insert(newContract);
		}
	}

	@Override
	public void deleteContract(Contract delContract) {

		// validar la existencia del contrato
		if (delContract != null) {

			// borrar el contrato
			contrDao.delete(delContract);
		}
	}

	@Override
	public void modifyContract(Contract modContract) {

		// Validar la existencia del contrato
		if (modContract != null) {

			// Actualizar el contrato
			contrDao.update(modContract);
		}
	}

	@Override
	public List<Contract> getContractByCustomerId(long customerId) {

		// Instancia una lista de contratos
		List<Contract> ListOfContracts = null;

		// Validar el id del cliente pasado por parámetro
		if (customerId > -1) {

			// Llamar al método para obtener los contatos
			ListOfContracts = contrDao.getContractsByCustomerId(customerId);
		}

		// Retorna la lista de contratos
		return ListOfContracts;
	}

}
