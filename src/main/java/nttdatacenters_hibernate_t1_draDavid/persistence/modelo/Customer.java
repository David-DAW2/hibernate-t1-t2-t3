package nttdatacenters_hibernate_t1_draDavid.persistence.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import nttdatacenters_hibernate_t1_draDavid.persistence.AbstractEntity;

@Entity
@Table(name = "T_DRA_CUSTOMER")
public class Customer extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID DEL CLIENTE
	 */
	private long customerId;

	/**
	 * NOMBRE DEL CLIENTE
	 */
	private String customerName;

	/**
	 * PRIMER APELLIDO DEL CLIENTE
	 */
	private String firstSurname;

	/**
	 * SEGUNDO APELLIDO DEL CLIENTE
	 */
	private String secondSurname;

	/**
	 * DNI DEL CLIENTE
	 */
	private int dni;

	/**
	 * FOREIGN KEY DE LA OFICINA A LA QUE PERTENECE EL CLIENTE
	 */
	private Office oficinaAsignada;

	/**
	 * CONTRATOS QUE PERTENECEN AL CLIENTE
	 */
	private List<Contract> contracts;

	/**
	 * RETORNA LA OFICINA ASIGNADA
	 * 
	 * @return
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_OFICINA_ID_FK")
	public Office getOficinaAsignada() {
		return oficinaAsignada;
	}

	public void setOficinaAsignada(Office oficinaAsignada) {
		this.oficinaAsignada = oficinaAsignada;
	}

	/**
	 * RETORNA LOS CONTRATOS
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fKdniCustomer")
	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	/**
	 * RETORNA EL ID DEL CLIENTE
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_CUSTOMER_ID")
	public long getcustomerId() {
		return customerId;
	}

	/**
	 * RETORNA EL NOMBRE DEL CLIENTE
	 * 
	 * @return
	 */
	@Column(name = "C_CUSTOMER_NAME")

	public String getCustomerName() {
		return customerName;
	}

	/**
	 * RETORNA EL PRIMER APELLIDO
	 * 
	 * @return
	 */
	@Column(name = "C_FIRST_SURNAME")
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * RETORNA EL SEGUNDO APELLIDO
	 * 
	 * @return
	 */
	@Column(name = "C_SECOND_SURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * RETORNA EL DNI
	 * 
	 * @return
	 */
	@Column(name = "C_DNI", unique = true, nullable = false)
	public int getDNI() {
		return dni;
	}

	/**
	 * DECLARA EL ID DE CLIENTE
	 * 
	 * @param customerId
	 */
	public void setcustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * DECLARA EL NOMBRE DEL CLIENTE
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * DECLARA EL PRIMER APELLIDO DEL CLIENTE
	 * 
	 * @param firstSurname
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * DECLARA EL SEGUNDO APELLIDO DEL CLIENTE
	 * 
	 * @param secondSurname
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * DECLARA EL DNI DEL CLIENTE
	 * 
	 * @param dNI
	 */
	public void setDNI(int dNI) {
		this.dni = dNI;
	}

	@Override
	@Transient
	public void setId(Long id) {

	}

	@Override
	@Transient
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
