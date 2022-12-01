package nttdatacenters_hibernate_t1_draDavid.services.interfaces;

import java.util.List;

public interface ContractManagementI<Contract> {

	/**
	 * añade un nuevo contrato
	 * 
	 * @param newContract
	 */
	public void addNewContract(final Contract newContract);

	/**
	 * borra un contrato
	 * 
	 * @param delContract
	 */
	public void deleteContract(final Contract delContract);

	/**
	 * modifica un contrato
	 * 
	 * @param modContract
	 */
	public void modifyContract(final Contract modContract);

	/**
	 * lista los contratos por el id de un cliente
	 * 
	 * @param customerId
	 * @return
	 */
	public List<Contract> getContractByCustomerId(final long customerId);

}
