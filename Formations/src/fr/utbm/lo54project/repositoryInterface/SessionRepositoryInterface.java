package fr.utbm.lo54project.repositoryInterface;

import java.util.List;    
import fr.utbm.lo54project.model.Session;

/**
 * Interface SessionRepositoryInterface : d�finit le contrat � respecter par tous les SessionRepository
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface SessionRepositoryInterface {
	
	 /**
	  * Fait persister un objet de type Session pass� en param�tres
	  * @param session
	  */
	 public void saveSession(Session session);
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant une session en fonction de 
	  * l'identifiant pass� en param�tres
	  * @param id
	  * @return
	  */
	 public Session getSessionById(int id);
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant la liste de toutes les sessions
	  * @return
	  */
	 public List<Session> getSessions();
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant une formation en fonction de 
	  * l'identifiant pass� en param�tre
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
	  * M�thode de recherche des formations.
	  * Pour fonctionner, la date doit �tre une chaine de caract�re et respecter le format "YYYY-MM-DD"
	  * Ici, on construit juste la chaine 'request' en fonction des champs fournis. Cette chaine est ex�cut�e � la fin
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
	  * Cr�e et ex�cute la requ�te retournant les session en fonction de l'identifiant du cours pass� en param�tre
	  * @param courseId
	  * @return
	  */
	 public List<Object[]> getSessionsByCourses(String courseId);
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant une session en fonction de son identiant
	  * @param tmpSession
	  * @return
	  */
	 public Object[] getSessionByStringId(String tmpSession);
}
