package fr.utbm.lo54project.repositoryInterface;

import java.util.List;  

import fr.utbm.lo54project.model.Client;

/**
 * Interface ClientRepositoryInterface : d�finit le contrat � respecter par tous les clientRepository
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface ClientRepositoryInterface {
	
	/**
	 * Fait persister un objet de type Client pass� en param�tre
	 * @param client
	 * @return
	 */
	 public boolean saveClient(Client client);
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant un Client en fonction de son identifiant
	  * @param id
	  * @return
	  */
	 public Client getClientById(int id);
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant un Client en fonction des crit�res pass�s en param�tre
	  * @param nom
	  * @param prenom
	  * @param email
	  * @param telephone
	  * @param adresse
	  * @return
	  */
	 public Client getClientByFields(String nom, String prenom, String email, String telephone, String adresse);
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant tous le clients de la BD
	  * @return
	  */
	 public List<Client> getClients();
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant les clients en fonction d'une session
	  * @param sessionId
	  * @return
	  */
	 public List<Client> getClientsBySession(int sessionId);
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant les Clients et les Cours associ�s
	  * @return
	  */
	 public List<Object[]> getClientsAndCourses();
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant la liste des titres des Cours
	  * @return
	  */
	 public List<String> getClientCourses();
	 
	/**
	 * Cr�e et ex�cute la requ�te retournant les clients,
	 * ainsi que les cours, sessions et ville assici�s
	 * @param id
	 * @return
	 */
	public List<Object[]> getClientsByTown(int id);
	
	/**
	 * Cr�e et ex�cute la requ�te retournant les clients et les cours associ�s
	 * @param code
	 * @return
	 */
	public List<Object[]> getClientsByCourseName(String code);
	
	/**
	 * Cr�er et ex�cute la requ�te retournant les clients en fonction des
	 * l'identifiants du cours et de la ville pass�s en param�tres
	 * @param id
	 * @param code
	 * @return
	 */
	public List<Object[]> getClientsByTownAndCourseName(int id, String code);
}
