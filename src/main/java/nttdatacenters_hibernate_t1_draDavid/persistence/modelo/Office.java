package nttdatacenters_hibernate_t1_draDavid.persistence.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import nttdatacenters_hibernate_t1_draDavid.persistence.AbstractEntity;

@Entity
@Table(name = "T_DRA_OFFICE")
public class Office extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * NUMERO DE LA OFICINA
	 */
	private long numOficina;
	/**
	 * CIUDAD DONDE SE ENCUENTRA LA OFICINA
	 */
	private String ciudad;
	/**
	 * NUMERO DE TRABAJADORES CON LOS QUE CUENTA LA OFICINA
	 */
	private int numTrabajadores;

	/**
	 * LISTA DE CLIENTES QUE TIENE LA OFICINA
	 */
	private List<Customer> clientes;

	/**
	 * RETORNA LOS CLIENTES QUE PERTENECEN A LA OFICINA
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "oficinaAsignada")
	public List<Customer> getClientes() {
		return clientes;
	}

	/**
	 * DECLARA LOS CLIENTES QUE PERTENENCEN A LA OFICINA
	 * 
	 * @param clientes
	 */
	public void setClientes(List<Customer> clientes) {
		this.clientes = clientes;
	}

	/**
	 * RETORNA EL ID DE LA OFICINA
	 * 
	 * @return
	 */
	@Id
	@Column(name = "C_NUMOFICINA")
	public long getNumOficina() {
		return numOficina;
	}

	/**
	 * DECLARA EL ID DE LA OFICINA
	 * 
	 * @param numOficina
	 */
	public void setNumOficina(long numOficina) {
		this.numOficina = numOficina;
	}

	/**
	 * RETORNA LA CIUDAD
	 * 
	 * @return
	 */
	@Column(name = "C_CIUDAD", nullable = false, unique = true)
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * DECLARA LA CIUDAD
	 * 
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * RETORNA EL NUMERO DE TRABAJADORES
	 * 
	 * @return
	 */
	@Column(name = "C_NUMTRABAJADORES")
	public int getNumTrabajadores() {
		return numTrabajadores;
	}

	/**
	 * DECLARA EL NUMERO DE TRABAJADORES
	 * 
	 * @param numTrabajadores
	 */
	public void setNumTrabajadores(int numTrabajadores) {
		this.numTrabajadores = numTrabajadores;
	}

	@Override
	@Transient
	public long getId() {
		return 0;
	}

	@Override
	@Transient
	public void setId(Long id) {

	}

}
