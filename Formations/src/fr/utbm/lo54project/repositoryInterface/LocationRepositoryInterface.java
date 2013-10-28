package fr.utbm.lo54project.repositoryInterface;

import java.util.List;   

import fr.utbm.lo54project.model.Location;

/**
 * Interface LocationRepositoryInterface : d�finit le contrat � respecter par tous les LocationRepository
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface LocationRepositoryInterface {
	
	 /**
	  * Fait persister un objet de type Location pass� en param�res
	  * @param location
	  */
	 public void saveLocation(Location location);
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant la liste de toutes les villes
	  * @return
	  */
	 public List<Location> getLocations();
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant une ville en fonction de l'identifiant pass� en param�tres
	  * @param id
	  * @return
	  */
	 public Location getLocationsById(int id);
}
