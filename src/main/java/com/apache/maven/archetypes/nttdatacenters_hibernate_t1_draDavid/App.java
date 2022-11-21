package com.apache.maven.archetypes.nttdatacenters_hibernate_t1_draDavid;

import java.sql.DriverManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nttdatacenters_hibernate_t1_draDavid.persistence.Customer;
import nttdatacenters_hibernate_t1_draDavid.persistence.CustomerDaoImp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	CustomerDaoImp iniciador=new CustomerDaoImp();
    	Customer nandi=new Customer();
    	nandi.setCustomerName("nandi");
    	nandi.setFirstSurname("marquez");
    	nandi.setSecondSurname("noseque");
    	nandi.setDNI(123412);
    	iniciador.insert(nandi);
    	
}
    
}
