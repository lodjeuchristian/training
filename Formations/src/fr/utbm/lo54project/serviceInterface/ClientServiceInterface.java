package fr.utbm.lo54project.serviceInterface;
 
import java.util.List; 
import fr.utbm.lo54project.model.Client;
import fr.utbm.lo54project.model.dto.FormationsDTO;

/**
 * Interface ClientServiceInterface : définit le contrat à respecter par tous les clientService
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface ClientServiceInterface {

	/**
	 * Enregistre un nouveau client dans la BD
	 * @param c
	 * @return
	 */
	public boolean saveClient(Client c);
	
	/**
	 * Crée et enregistre un nouveau client donnant directement ses paramètres
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param adresse
	 * @return
	 */
	public boolean addClient(String nom, String prenom, String email, String telephone, String adresse);
	
	/**
	 * Retourne un client en fonction des paramètres spécifiés
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param adresse
	 * @return
	 */
	public Client getClientByFields(String nom, String prenom, String email, String telephone, String adresse);
	
	/**
	 * Retourne les clients inscrits à une session
	 * @param sessionId
	 * @return
	 */
	public List<Client> getClientsBySession(int sessionId);
	
	/**
	 * Retourne la liste associant les clients aux cours 
	 * @return
	 */
	public List<FormationsDTO> getClientsAndCourses();
	 
	 
	 public List<FormationsDTO> getClientCourses();
	 
	 /**
	  * Retourne la liste des clients en fonction de l'identifiant de la ville
	  * @param id
	  * @return
	  */
	 public List<FormationsDTO> getClientsByTown(int id);
	 
	 /**
	  * Retourne la liste des clients en fonction du nom du cours
	  * @param cd
	  * @return
	  */
	 public List<FormationsDTO> getClientsByCourseName(String cd);
	 
	 /**
	  * Retourne la liste des clients en fonction du cours et de la ville
	  * @param id
	  * @param cd
	  * @return
	  */
	 public List<FormationsDTO> getClientsByTownAndCourseName(int id, String cd);
}
