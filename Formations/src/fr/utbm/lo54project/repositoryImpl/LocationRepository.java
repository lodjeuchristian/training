package fr.utbm.lo54project.repositoryImpl;

import java.util.List;  
import javax.persistence.Query; 
import fr.utbm.lo54project.jpa.JpaManagement;
import fr.utbm.lo54project.model.Location;
import fr.utbm.lo54project.repositoryInterface.LocationRepositoryInterface;

/**
 * Repository (DAO) Location 
 * Toutes les m�thodes d'acc�s utilisent le singleton JpaManagement et le language de requ�tes JPQL de JPA
 * EclipseLink va automatiquement g�rer le pool de connexion et la fermeture des sessions
 * @author Lodjeu - Libam - Ntieche
 *
 */
public class LocationRepository implements LocationRepositoryInterface{

	 /**
	  * Fait persister un objet de type Location pass� en param�res
	  * @param location
	  */
	 public void saveLocation(Location location){
		 JpaManagement.getInstance().getEm().getTransaction().begin();
		 JpaManagement.getInstance().getEm().persist(location);
		 JpaManagement.getInstance().getEm().getTransaction().commit();		 
	 }
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant la liste de toutes les villes
	  * @return
	  */
	 public List<Location> getLocations(){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select l from Location l order by l.city ASC");
		 return q.getResultList();
	 }
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant une ville en fonction de l'identifiant pass� en param�tres
	  * @param id
	  * @return
	  */
	 public Location getLocationsById(int id){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select l from Location l where l.id = "+id);
		 return (Location) q.getSingleResult();
	 }
	 
	
}
