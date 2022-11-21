package nttdatacenters_hibernate_t1_draDavid.persistence;

import java.util.List;

public interface CustomerDaoI extends CommonDaoI<Customer>  {

	@Override
	List<Customer> searchAll(Customer obj);

	@Override
	Customer searchById(Long id);

	

}
