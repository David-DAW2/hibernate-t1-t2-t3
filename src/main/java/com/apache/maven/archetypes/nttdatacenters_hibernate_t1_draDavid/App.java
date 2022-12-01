package com.apache.maven.archetypes.nttdatacenters_hibernate_t1_draDavid;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Implementaciones.ContractDaoImp;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Implementaciones.CustomerDaoImp;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.ContractDaoI;
import nttdatacenters_hibernate_t1_draDavid.persistence.Dao.Interfaces.CustomerDaoI;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Contract;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Customer;
import nttdatacenters_hibernate_t1_draDavid.persistence.modelo.Office;
import nttdatacenters_hibernate_t1_draDavid.services.implementaciones.ContractManagementImp;
import nttdatacenters_hibernate_t1_draDavid.services.implementaciones.CustomerManagementImp;
import nttdatacenters_hibernate_t1_draDavid.services.implementaciones.OfficeManagementImp;
import nttdatacenters_hibernate_t1_draDavid.services.interfaces.ContractManagementI;
import nttdatacenters_hibernate_t1_draDavid.services.interfaces.CustomerManagementI;
import nttdatacenters_hibernate_t1_draDavid.services.interfaces.OfficeManagementI;

/**
 * Hello world!
 *
 */

public class App {
	private static final Logger LOG =LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		/**
		 * inyección del servicio de clientes
		 */
		LOG.debug("Comienza Instanciación capa servicio");
		CustomerManagementI<Customer> gestorClientes = new CustomerManagementImp();
		ContractManagementI<Contract>gestorContratos=new ContractManagementImp();
		OfficeManagementI<Office>gestorOficinas=new OfficeManagementImp();

		/**
		 * Instanciación de objetos Customers
		 */

		Customer nandi = new Customer();
		nandi.setCustomerName("nandi");
		nandi.setFirstSurname("marquez");
		nandi.setSecondSurname("noseque");
		nandi.setDNI(111112);
		Customer rafa = new Customer();
		rafa.setCustomerName("rafa");
		rafa.setFirstSurname("ossorio");
		rafa.setSecondSurname("valera");
		rafa.setDNI(890112);
		Customer julian = new Customer();
		julian.setCustomerName("julian");
		julian.setFirstSurname("marquez");
		julian.setSecondSurname("ossorio");
		julian.setDNI(90752);
		Customer marcos = new Customer();
		marcos.setCustomerName("marcos");
		marcos.setFirstSurname("avea");
		marcos.setSecondSurname("olalla");
		marcos.setDNI(121252);


		Customer david = new Customer();
		david.setCustomerName("david");
		david.setFirstSurname("rodriguez");
		david.setSecondSurname("noseque");
		david.setDNI(133332);

		Customer miguel = new Customer();
		miguel.setCustomerName("miguel");
		miguel.setFirstSurname("ortiz");
		miguel.setSecondSurname("urgel");
		miguel.setDNI(144442);

		Customer nieves = new Customer();
		nieves.setCustomerName("nieves");
		nieves.setFirstSurname("nevado");
		nieves.setSecondSurname("fiat");
		nieves.setDNI(155556);
		
		/**
		 * Instanciación de lista de contractos para cada cliente
		 */
		
		List<Contract> listaParaNieves = new ArrayList<Contract>();
		List<Contract> listaParaNandi = new ArrayList<Contract>();
		List<Contract> listaParaDavid = new ArrayList<Contract>();


		/**
		 * Instanciación de objetos contrato
		 */

		Contract contrato1 = new Contract();
		contrato1.setReference("10928x");
		contrato1.setPermanencia(12);

		Contract contrato2 = new Contract();
		contrato2.setReference("114928x");
		contrato2.setPermanencia(15);
		Contract contrato3 = new Contract();
		contrato3.setReference("12998x");
		contrato3.setPermanencia(15);
		Contract contrato4 = new Contract();
		contrato4.setReference("13998x");
		contrato4.setPermanencia(3);
		
		Contract contrato5 = new Contract();
		contrato5.setReference("2998f");
		Contract contrato6 = new Contract();
		contrato6.setReference("30398f");
		Contract contrato7 = new Contract();
		contrato7.setReference("45438j");
		contrato7.setPermanencia(15);

		/**
		 * Adición de objetos contractos en las listas de clientes
		 */
		

		listaParaNieves.add(contrato1);
		listaParaNieves.add(contrato2);
		listaParaNieves.add(contrato3);
		listaParaNieves.add(contrato4);
		listaParaNandi.add(contrato5);
		listaParaNandi.add(contrato6);
		listaParaDavid.add(contrato7);


		/**
		 * Establecer lista de contratos a cada cliente
		 */
	
		nieves.setContracts(listaParaNieves);
		david.setContracts(listaParaDavid);
		nandi.setContracts(listaParaNandi);

		/**
		 * Establecer cliente único a cada contrato
		 */
	
		
		contrato1.setfKdniCustomer(nieves);
		contrato2.setfKdniCustomer(nieves);
		contrato3.setfKdniCustomer(nieves);
		contrato4.setfKdniCustomer(nieves);
		contrato5.setfKdniCustomer(nandi);
		contrato6.setfKdniCustomer(nandi);
		contrato7.setfKdniCustomer(david);

		
		/**
		 * Instanciación de lista de clientes para cada oficina
		 */	
		
		List<Customer> cusSevilla=new ArrayList<Customer>();
		List<Customer> cusMalaga=new ArrayList<Customer>();
		List<Customer> cusMadrid=new ArrayList<Customer>();
		List<Customer> cusBarcelona=new ArrayList<Customer>();
		
		
		/**
		 * Adición de objetos cliente en las listas de oficinas
		 */
		cusSevilla.add(nieves);
		cusSevilla.add(rafa);
		cusSevilla.add(julian);
		cusSevilla.add(marcos);
		cusMalaga.add(miguel);
		cusMadrid.add(david);
		cusBarcelona.add(nandi);
		
		
		/**
		 * Instanciación de objetos Customers
		 */
		Office ofiSevilla=new Office();
		Office ofiMalaga=new Office();
		Office ofiMadrid=new Office();
		Office ofiBarcelona=new Office();
		
		
		
		ofiSevilla.setCiudad("Sevilla");
		ofiBarcelona.setCiudad("Barcelona");
		ofiMadrid.setCiudad("Madrid");
		ofiMalaga.setCiudad("Malaga");
		
		ofiSevilla.setClientes(cusSevilla);
		ofiBarcelona.setClientes(cusBarcelona);
		ofiMadrid.setClientes(cusMadrid);
		ofiMalaga.setClientes(cusMalaga);
		
		ofiSevilla.setNumTrabajadores(20);
		ofiBarcelona.setNumTrabajadores(45);
		ofiMadrid.setNumTrabajadores(60);
		ofiMalaga.setNumTrabajadores(32);
		
		ofiSevilla.setNumOficina(1234);
		ofiMadrid.setNumOficina(2222);
		ofiMalaga.setNumOficina(3333);
		ofiBarcelona.setNumOficina(4444);
		
		
		/**
		 * Asignacion de oficina unica para cada cliente
		 */
		
		nieves.setOficinaAsignada(ofiSevilla);
		marcos.setOficinaAsignada(ofiSevilla);
		julian.setOficinaAsignada(ofiSevilla);
		rafa.setOficinaAsignada(ofiSevilla);
		miguel.setOficinaAsignada(ofiMalaga);
		david.setOficinaAsignada(ofiMadrid);
		nandi.setOficinaAsignada(ofiBarcelona);
		
		
		/**
		 * adiccion de oficinas al servicio oficina
		 */

		gestorOficinas.addNewOffice(ofiBarcelona);
		gestorOficinas.addNewOffice(ofiMadrid);
		gestorOficinas.addNewOffice(ofiSevilla);
		gestorOficinas.addNewOffice(ofiMalaga);

		
		
//		gestorClientes.newCustomer(nieves);
//		gestorClientes.newCustomer(miguel);
//		gestorClientes.newCustomer(david);
//		gestorClientes.newCustomer(nandi);
		

	

		/**
		 * Llamada al método buscar cliente por DNI
		 */

		gestorClientes.getByDNI(155556);

		/**
		 * Llamada al método  buscar cliente por Id
		 */
		gestorClientes.getById(1);

		
		/**
		 * Llamada al método  buscar oficinas con un numero mayor al pasado por parámetros
		 */
		
		List<Office> listaOfis= gestorOficinas.SearchByGTNumberOfWorkers(10);
		
		
		/**
		 * Iteración por oficinas encontradas
		 */
		for (Office office : listaOfis) {
			
			System.out.println(office.getCiudad()+" "+office.getId()+" "+office.getNumOficina());
		}
		
		
		/**
		 * Llamada al metodo buscar clientes con un tiempo de permanencia pasado por parámetro en un contrato 
		 */
		List<Customer> listaCusByPermanency=gestorClientes.searchCustomByContractPermanency(15);
		
		/**
		 * Iteración por clientes encontrados
		 */
		for (Customer customer : listaCusByPermanency) {
			System.out.println(customer.getcustomerId()+" "+customer.getCustomerName());
		}
		
//    	------------------------------------------------------
	


	}

}
