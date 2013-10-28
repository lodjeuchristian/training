package fr.utbm.lo54project.serviceInterface;
   
import java.util.List;   
import fr.utbm.lo54project.model.Location; 

/**
 * Interface LocationServiceInterface : définit le contrat à respecter par tous les locationService
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface LocationServiceInterface {

	/**
	 * Service qui retourne la liste de toutes les formations
	 * @return
	 */
	public List<Location> getAllLocations();
}
