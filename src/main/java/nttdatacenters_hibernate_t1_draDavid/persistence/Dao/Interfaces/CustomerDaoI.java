package nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces;

import java.util.List;

import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Customer;

public interface CustomerDaoI extends CommonDaoI<Customer>  {

	/**
	 * Devuelve el cliente que contiene el DNI pasado por parámetro
	 * @param dni
	 * @return
	 */
	public Customer getCustomerByDni(int dni);
	
	
/**
 * Devuelve una lista de clientes con permanencia pasada por parámetro en alguno de sus contratos
 * @param permanency
 * @return
 */
	public List<Customer> searchByContractPermanency(int permanency);	
}
