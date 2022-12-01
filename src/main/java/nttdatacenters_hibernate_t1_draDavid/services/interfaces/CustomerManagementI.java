package nttdatacenters_hibernate_t1_draDavid.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Customer;

public interface CustomerManagementI<Customer> {

	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param customer
	 */
	public void newCustomer(final Customer customer);

	/**
	 * Borra un cliente
	 * 
	 * @param customer
	 */
	public void removeCustomer(final Customer customer);

	/**
	 * Obtiene un cliente por el id
	 * 
	 * @param id
	 * @return
	 */
	public Customer getById(final long id);

	/**
	 * Modifica un cliente
	 * 
	 * @param customer
	 */
	public void modifyCustomer(final Customer customer);

	/**
	 * Obtiene un cliente por el DNI
	 * 
	 * @param dni
	 * @return
	 */
	public Customer getByDNI(final int dni);

	/**
	 * Busca clientes que tengan en un contrato una permanencia dada por parámetro
	 * 
	 * @param permanency
	 * @return
	 */
	public List<Customer> searchCustomByContractPermanency(int permanency);

}
