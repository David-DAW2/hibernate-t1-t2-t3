package nttdatacenters_hibernate_t1_draDavid.persistence;

public  class CustomerDaoImp extends CommonDaoImp<Customer>	implements CustomerDaoI {

	public CustomerDaoImp() {
		super.setEntityClass(Customer.class);
	}

}
