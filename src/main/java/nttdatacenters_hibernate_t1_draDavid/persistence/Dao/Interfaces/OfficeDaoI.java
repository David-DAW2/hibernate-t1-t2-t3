package nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces;

import java.util.List;

import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Customer;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Office;

public interface OfficeDaoI extends CommonDaoI<Office>{
	
	
/**
 * Devuelve una lista de oficinas que tengan el número de trabajadores pasado por parámetros
 * @param numeroTrabajadores
 * @return
 */
public List<Office> searchByNumberOfWorkers(int numeroTrabajadores);
}
