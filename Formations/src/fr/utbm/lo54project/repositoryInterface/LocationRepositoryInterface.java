package fr.utbm.lo54project.repositoryInterface;

import java.util.List;   

import fr.utbm.lo54project.model.Location;

/**
 * Interface LocationRepositoryInterface : définit le contrat à respecter par tous les LocationRepository
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface LocationRepositoryInterface {
	
	 /**
	  * Fait persister un objet de type Location passé en paramères
	  * @param location
	  */
	 public void saveLocation(Location location);
	 
	 /**
	  * Crée et exécute la requête retournant la liste de toutes les villes
	  * @return
	  */
	 public List<Location> getLocations();
	 
	 /**
	  * Crée et exécute la requête retournant une ville en fonction de l'identifiant passé en paramètres
	  * @param id
	  * @return
	  */
	 public Location getLocationsById(int id);
}
