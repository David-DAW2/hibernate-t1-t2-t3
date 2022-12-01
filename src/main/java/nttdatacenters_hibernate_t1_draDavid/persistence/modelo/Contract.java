package nttdatacenters_hibernate_t1_draDavid.persistence.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import nttdatacenters_hibernate_t1_draDavid.persistence.AbstractEntity;

@Entity
@Table(name = "T_DRA_CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * REFERENCIA DEL CONTRATO
	 */
	private String reference;

	/**
	 * TIPO DE CONTRATO
	 */
	private int tipo;

	/**
	 * FOREIGN KEY DEL DNI DEL CLIENTE AL QUE PERTENECE EL CONTRATO
	 */
	private Customer fKdniCustomer;

	/**
	 * TIEMPO DE PERMANENCIA EN EL CONTRATO
	 */
	private Integer permanencia;

	/**
	 * RETORNA EL TIEMPO DE PERMANENCIA
	 * 
	 * @return
	 */
	@Column(name = "C_PERMANENCIA")
	public Integer getPermanencia() {
		return permanencia;
	}

	/**
	 * DECLARA EL TIEMPO DE PERMANENCIA
	 * 
	 * @param permanencia
	 */
	public void setPermanencia(Integer permanencia) {
		this.permanencia = permanencia;
	}

	/**
	 * RETORNA LA REFERENCIA DEL CONTRATO
	 * 
	 * @return
	 */
	@Id
	@Column(name = "C_REFERENCIA")
	public String getReference() {
		return reference;
	}

	/**
	 * DECLARA EL TIEMPO DE PERMANENCIA
	 * 
	 * @param permanencia
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * RETORNA EL TIPO DE CONTRATO
	 * 
	 * @return
	 */
	@Column(name = "C_TIPO")
	public int getTipo() {
		return tipo;
	}

	/**
	 * DECLARA EL TIPO DE CONTRATO
	 * 
	 * @param tipo
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * RETORNA EL CLIENTE AL CUAL PERTENECE EL CONTRATO
	 * 
	 * @return
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_CUSTOMER_ID_FK")
	public Customer getfKdniCustomer() {
		return fKdniCustomer;
	}

	/**
	 * DECLARA AL CLIENTE QUE PERTENECE EL CONTRATO
	 * 
	 * @param fKdniCustomer
	 */
	public void setfKdniCustomer(Customer fKdniCustomer) {
		this.fKdniCustomer = fKdniCustomer;
	}

	@Override
	@Transient
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transient
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

}
