package nttdatacenters_hibernate_t1_draDavid.persistence;

import java.util.List;

public interface CommonDaoI<T> {

	
	/**
	 * INSERTA UN REGISTRO EN LA BASE DE DATOS
	 * @param obj
	 */
	public void insert(final T obj);
	
	/**
	 * RECUPERA LOS REGISTRO DE TODA LA TABLA
	 * @param obj
	 */
	public List<T> searchAll(final T obj);
	/**
	 * RECUPERA UN REGISTRO A TRAVES DEL ID DADO
	 * @param obj
	 */
	public T searchById(final Long id);
	/**
	 * ELIMINA UN REGISTRO
	 * @param obj
	 */
	public void delete(final T obj);
	/**
	 * MODIFICA UN REGISTRO A TRAVES DEL ID DADO
	 * @param obj
	 */
	public void update(final T obj);

	
}
