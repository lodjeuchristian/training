package fr.utbm.lo54project.jpa;   

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence; 

/**
 * Singleton qui assure l'instanciation unique de l'EntityManager
 * Utilisé principalement par la couche Repository(DAO) pour l'accès à la base de données
 * @author Lodjeu - Libam - Ntieche
 *
 */
public final class JpaManagement { 
	
	private static volatile JpaManagement instance = null;  
	private static final String PERSISTENCE_UNIT_NAME = "formation";
	private static EntityManagerFactory factory; 
	private static EntityManager em;
	  
	private JpaManagement() { 
	    super(); 
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager(); 
	}
	  
	public final static JpaManagement getInstance() {  
		 if (JpaManagement.instance == null) { 
            synchronized(JpaManagement.class) {
              if (JpaManagement.instance == null) {
            	  JpaManagement.instance = new JpaManagement(); 
              }
            }

		  } 
		  return JpaManagement.instance;
	 }
	 
 
	 public void getNewEntityManager(){ 
	     factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	     em = factory.createEntityManager(); 
	 }
	 
	 public void closeEntityManager(){ 
		 em.close();
	 }

	 public  EntityManager getEm() {
		 return em;
	 }
	
	 public  void setEm(EntityManager em) {
		 JpaManagement.em = em;
	 } 
 
 }