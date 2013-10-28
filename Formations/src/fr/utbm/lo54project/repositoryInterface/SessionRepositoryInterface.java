package fr.utbm.lo54project.repositoryInterface;

import java.util.List;    
import fr.utbm.lo54project.model.Session;

/**
 * Interface SessionRepositoryInterface : définit le contrat à respecter par tous les SessionRepository
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface SessionRepositoryInterface {
	
	 /**
	  * Fait persister un objet de type Session passé en paramètres
	  * @param session
	  */
	 public void saveSession(Session session);
	 
	 /**
	  * Crée et exécute la requête retournant une session en fonction de 
	  * l'identifiant passé en paramètres
	  * @param id
	  * @return
	  */
	 public Session getSessionById(int id);
	 
	 /**
	  * Crée et exécute la requête retournant la liste de toutes les sessions
	  * @return
	  */
	 public List<Session> getSessions();
	 
	 /**
	  * Crée et exécute la requête retournant une formation en fonction de 
	  * l'identifiant passé en paramètre
	  * @param sessionId
	  * @return
	  */
	 public Object[] getFormationById(int sessionId);
	 
	 /**
	  * 
	  * @return
	  */
	 public List<Object[]> getFormationsDTO();
	 
	 /*
	  * Méthode de recherche des formations.
	  * Pour fonctionner, la date doit être une chaine de caractère et respecter le format "YYYY-MM-DD"
	  * Ici, on construit juste la chaine 'request' en fonction des champs fournis. Cette chaine est exécutée à la fin
	  */
	 /**
	  * Fonction de recherche d'une formation
	  * @param cours
	  * @param date
	  * @param lieu
	  * @param sortBy
	  * @param direction
	  * @return
	  */
	 public List<Object[]> getSearchFormationsDTO(String cours, String date, String lieu, String sortBy, String direction);
	 
	 /**
	  * Crée et exécute la requête retournant les session en fonction de l'identifiant du cours passé en paramètre
	  * @param courseId
	  * @return
	  */
	 public List<Object[]> getSessionsByCourses(String courseId);
	 
	 /**
	  * Crée et exécute la requête retournant une session en fonction de son identiant
	  * @param tmpSession
	  * @return
	  */
	 public Object[] getSessionByStringId(String tmpSession);
}
