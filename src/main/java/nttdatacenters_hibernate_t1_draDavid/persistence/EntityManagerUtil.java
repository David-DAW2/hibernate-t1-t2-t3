package nttdatacenters_hibernate_t1_draDavid.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	/*clase sencilla de utilidad que nos ayude a establecer y manejar las conexiones con la base de datos*/
	
	public static EntityManager getEntityManager() {

		EntityManagerFactory factory=Persistence.createEntityManagerFactory("HibernateT2");
		EntityManager manager=factory.createEntityManager();

		return manager;
	}
}
