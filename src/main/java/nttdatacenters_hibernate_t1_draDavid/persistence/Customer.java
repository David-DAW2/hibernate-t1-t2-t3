package nttdatacenters_hibernate_t1_draDavid.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="T_DRA_CUSTOMER")
public class Customer extends AbstractEntity implements Serializable {
	EntityManager entitymanager=EntityManagerUtil.getEntityManager();

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int customerId;
	private String	customerName;
	private String firstSurname;
	private String secondSurname;
	private int dni;


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	public int getcustomerId() {
		return customerId;
	}
	
	
	
	
	@Column(name = "CUSTOMER_NAME")

	public String getCustomerName() {
		return customerName;
	}


	@Column(name = "FIRST_SURNAME")
	public String getFirstSurname() {
		return firstSurname;
	}

	

	@Column(name = "SECOND_SURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}
	
	@Column(name = "DNI", unique = true, nullable = false)
	public int getDNI() {
		return dni;
	}
	
	
	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}
	

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public void setDNI(int dNI) {
		this.dni = dNI;
	}




	@Override
	@Transient
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}




	@Override
	@Transient
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}





	
}
