package nttdatacenters_hibernate_t1_draDavid.services.implementaciones;

import java.util.List;

import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Implementaciones.OfficeDaoImp;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.OfficeDaoI;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Office;
import nttdatacenters_hibernate_t1_draDavid.services.interfaces.OfficeManagementI;

public class OfficeManagementImp implements OfficeManagementI<Office> {

	/**
	 * OBJETO DAO PARA PODER IMPLEMENTAR LOS MÉTODOS CRUD
	 */
	OfficeDaoI offDao;

	/**
	 * CONTRUCTOR, SE INTANCIA EL OBJETO cusDao
	 */
	public OfficeManagementImp() {
		offDao = new OfficeDaoImp();

	}

	@Override
	public void addNewOffice(Office newOffice) {

		// VALIDAR LA EXISTENCIA DE LA OFICINA
		if (newOffice != null) {

			// INSERTAR LA OFICINA
			offDao.insert(newOffice);
		}
	}

	@Override
	public void deleteOffice(Office delOffice) {

		// VALIDAR LA EXISTENCIA DE LA OFICINA
		if (delOffice != null) {

			// BORRAR LA OFICINA
			offDao.delete(delOffice);
		}
	}

	@Override
	public void modifyOffice(Office modOffice) {

		// VALIDAR LA EXISTENCIA DE LA OFICINA
		if (modOffice != null) {

			// ACTUALIZAR LA OFICINA
			offDao.update(modOffice);
		}
	}

	@Override
	public List<Office> SearchByGTNumberOfWorkers(int numWorkers) {

		// RETORNA LA LISTA DE OFICINAS CON NUMERO DE TRABAJADORES MAYOR AL NUMERO
		// PASADO POR PARÁMETRO
		return offDao.searchByNumberOfWorkers(numWorkers);
	}

}
