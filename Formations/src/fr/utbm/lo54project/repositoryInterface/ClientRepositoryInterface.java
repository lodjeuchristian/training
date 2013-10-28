package fr.utbm.lo54project.repositoryInterface;

import java.util.List;  

import fr.utbm.lo54project.model.Client;

/**
 * Interface ClientRepositoryInterface : définit le contrat à respecter par tous les clientRepository
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface ClientRepositoryInterface {
	
	/**
	 * Fait persister un objet de type Client passé en paramètre
	 * @param client
	 * @return
	 */
	 public boolean saveClient(Client client);
	 
	 /**
	  * Crée et exécute la requête retournant un Client en fonction de son identifiant
	  * @param id
	  * @return
	  */
	 public Client getClientById(int id);
	 
	 /**
	  * Crée et exécute la requête retournant un Client en fonction des critères passés en paramètre
	  * @param nom
	  * @param prenom
	  * @param email
	  * @param telephone
	  * @param adresse
	  * @return
	  */
	 public Client getClientByFields(String nom, String prenom, String email, String telephone, String adresse);
	 
	 /**
	  * Crée et exécute la requête retournant tous le clients de la BD
	  * @return
	  */
	 public List<Client> getClients();
	 
	 /**
	  * Crée et exécute la requête retournant les clients en fonction d'une session
	  * @param sessionId
	  * @return
	  */
	 public List<Client> getClientsBySession(int sessionId);
	 
	 /**
	  * Crée et exécute la requête retournant les Clients et les Cours associés
	  * @return
	  */
	 public List<Object[]> getClientsAndCourses();
	 
	 /**
	  * Crée et exécute la requête retournant la liste des titres des Cours
	  * @return
	  */
	 public List<String> getClientCourses();
	 
	/**
	 * Crée et exécute la requête retournant les clients,
	 * ainsi que les cours, sessions et ville assiciés
	 * @param id
	 * @return
	 */
	public List<Object[]> getClientsByTown(int id);
	
	/**
	 * Crée et exécute la requête retournant les clients et les cours associés
	 * @param code
	 * @return
	 */
	public List<Object[]> getClientsByCourseName(String code);
	
	/**
	 * Créer et exécute la requête retournant les clients en fonction des
	 * l'identifiants du cours et de la ville passés en paramètres
	 * @param id
	 * @param code
	 * @return
	 */
	public List<Object[]> getClientsByTownAndCourseName(int id, String code);
}
