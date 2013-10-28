package fr.utbm.lo54project.serviceImpl;
 
import java.util.ArrayList;
import java.util.List;
 
import fr.utbm.lo54project.model.Location;
import fr.utbm.lo54project.repositoryImpl.LocationRepository; 
import fr.utbm.lo54project.repositoryInterface.LocationRepositoryInterface;
import fr.utbm.lo54project.serviceInterface.LocationServiceInterface;

/**
 * Service LocationService : fournit un ensemble de méthodes permettant de
 * récuperer et modifier le contenu de la table Location contenue dans la BD
 * @author Lodjeu - Libam - Ntieche
 *
 */
public class LocationService implements LocationServiceInterface{
	
	private LocationRepositoryInterface locationRepository = new LocationRepository();
 
	/**
	 * Service qui retourne la liste de toutes les formations
	 * @return
	 */
	public List<Location> getAllLocations(){
		 
	  List<Location> listlocation = locationRepository.getLocations();
	  List<Location> resultat = new ArrayList<Location>();
	  
	  for(Location l:listlocation){  
		   resultat.add(l); 
	  }
	  return resultat;
	}
	
}
