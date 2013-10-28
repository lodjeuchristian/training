package fr.utbm.lo54project.repositoryImpl;

import java.util.List; 
import javax.persistence.Query;
import fr.utbm.lo54project.jpa.JpaManagement;
import fr.utbm.lo54project.model.Client;
import fr.utbm.lo54project.repositoryInterface.ClientRepositoryInterface;
 
/**
 * Repository (DAO) Client 
 * Toutes les méthodes d'accès utilisent le singleton JpaManagement et le language de requêtes JPQL de JPA
 * EclipseLink va automatiquement gérer le pool de connexion et la fermeture des sessions
 * @author Lodjeu - Libam - Ntieche
 *
 */
public class ClientRepository implements ClientRepositoryInterface{

	/**
	 * Fait persister un objet de type Client passé en paramètre
	 * @param client
	 * @return
	 */
	 public boolean saveClient(Client client){
		 try{
			 JpaManagement.getInstance().getEm().getTransaction().begin();
			 JpaManagement.getInstance().getEm().persist(client);
			 JpaManagement.getInstance().getEm().getTransaction().commit();
			 return true;
		 }
		 catch(Exception e){
			 return false;
		 }
	 }
	 
	 /**
	  * Crée et exécute la requête retournant un Client en fonction de son identifiant
	  * @param id
	  * @return
	  */
	 public Client getClientById(int id){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select cl from Client cl where cl.id = "+id);
		 return (Client)q.getSingleResult();  
	 }
	 
	 /**
	  * Crée et exécute la requête retournant un Client en fonction des critères passés en paramètre
	  * @param nom
	  * @param prenom
	  * @param email
	  * @param telephone
	  * @param adresse
	  * @return
	  */
	 public Client getClientByFields(String nom, String prenom, String email, String telephone, String adresse){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select cl from Client cl where cl.lastName = '"+nom+"' AND cl.firstName = '"+prenom+"' AND cl.email = '"+email+"' order by cl.id DESC").setMaxResults(1);
		 return (Client)q.getSingleResult();  		 
	 }
	 
	 /**
	  * Crée et exécute la requête retournant tous le clients de la BD
	  * @return
	  */
	 public List<Client> getClients(){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select cl from Client cl");
		 return q.getResultList();
	 }
	 
	 /**
	  * Crée et exécute la requête retournant les clients en fonction d'une session
	  * @param sessionId
	  * @return
	  */
	 public List<Client> getClientsBySession(int sessionId){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select cl from Client cl join cl.session s where s.id = "+sessionId);
		 return q.getResultList();
	 }
	 
	 /**
	  * Crée et exécute la requête retournant les Clients et les Cours associés
	  * @return
	  */
	 public List<Object[]> getClientsAndCourses(){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select cl.firstName, cl.lastName, c.title, s.start, l.city from Client cl join cl.session s join s.location l join s.course c");
		 return q.getResultList();
	 }
	 
	 /**
	  * Crée et exécute la requête retournant la liste des titres des Cours
	  * @return
	  */
	 public List<String> getClientCourses(){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select c.title from Course c order by c.title ASC");
		 return q.getResultList();
	 }
	 
	/**
	 * Crée et exécute la requête retournant les clients,
	 * ainsi que les cours, sessions et ville assiciés
	 * @param id
	 * @return
	 */
	public List<Object[]> getClientsByTown(int id){
		Query q = JpaManagement.getInstance().getEm().createQuery("select cl.firstName, cl.lastName, c.title, s.start, l.city from Client cl join cl.session s join s.location l join s.course c where l.id ="+id);
		return q.getResultList();
	}
	
	/**
	 * Crée et exécute la requête retournant les clients et les cours associés
	 * @param code
	 * @return
	 */
	public List<Object[]> getClientsByCourseName(String code){
		Query q = JpaManagement.getInstance().getEm().createQuery("select cl.firstName, cl.lastName, c.title, s.start, l.city from Client cl join cl.session s join s.location l join s.course c where c.code ='"+code+"'");
		return q.getResultList();
	}
	
	/**
	 * Créer et exécute la requête retournant les clients en fonction des
	 * l'identifiants du cours et de la ville passés en paramètres
	 * @param id
	 * @param code
	 * @return
	 */
	public List<Object[]> getClientsByTownAndCourseName(int id, String code){
		Query q = JpaManagement.getInstance().getEm().createQuery("select cl.firstName, cl.lastName, c.title, s.start, l.city from Client cl join cl.session s join s.location l join s.course c where c.code ='"+code+"' and l.id="+id);
		return q.getResultList();
	}


}
