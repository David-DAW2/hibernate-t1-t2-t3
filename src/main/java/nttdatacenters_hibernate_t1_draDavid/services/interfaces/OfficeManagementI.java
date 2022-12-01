package nttdatacenters_hibernate_t1_draDavid.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.OfficeDaoI;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Customer;

public interface OfficeManagementI<Office> {

	/**
	 * Añade una nueva oficina
	 * 
	 * @param newOffice
	 */
	public void addNewOffice(final Office newOffice);

	/**
	 * Borra una oficina
	 * 
	 * @param delOffice
	 */
	public void deleteOffice(final Office delOffice);

	/**
	 * Modifica una oficina
	 * 
	 * @param modOffice
	 */
	public void modifyOffice(final Office modOffice);

	/**
	 * Busca oficinas con un numero de trabajos mayor al pasado por parámetro
	 * 
	 * @param numWorkers
	 * @return
	 */
	public List<Office> SearchByGTNumberOfWorkers(int numWorkers);

}
