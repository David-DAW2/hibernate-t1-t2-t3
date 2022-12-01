package nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces;

import java.util.List;

import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Contract;

public interface ContractDaoI extends CommonDaoI<Contract>{

	/**
	 * Devuelve los contratos que tiene el cliente 
	 * @param customerId
	 * @return
	 */
	public List<Contract> getContractsByCustomerId(final long customerId);
}
