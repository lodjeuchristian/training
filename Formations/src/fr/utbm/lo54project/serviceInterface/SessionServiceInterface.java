package fr.utbm.lo54project.serviceInterface;
    
import java.util.List;    
import fr.utbm.lo54project.model.Session;
import fr.utbm.lo54project.model.dto.FormationsDTO; 

/**
 * Interface SessionServiceInterface : définit le contrat à respecter par tous les sessionService
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface SessionServiceInterface {

	/**
	 * Service qui retourne une session en fonction de son id
	 */
	public Session getSessionById(int id);
	

	
	/**
	 * Service qui retourne une formation donnée en fonction de l'id de la session
	 */
	public FormationsDTO getFormationById(int sessionId);
	
	
	/**
	 * Service qui retourne la liste de toutes les formations
	 * @return
	 */
	public List<FormationsDTO> getAllFormations();
	
	
	/**
	 * Service qui retourne la liste de toutes les formations suivant le filtre
	 * @return
	 */
	public List<FormationsDTO> getSearchFormations(String cours, String date, String lieu, String sortBy, String direction);
	
	/**
	 * Service qui retourne la liste des sessions en fonction de l'identifiant du cours
	 * @param courseId
	 * @return
	 */
	public List<FormationsDTO> getSessionsByCourses(String courseId);
	
	/**
	 * Service qui retourne une session en fonction de son identiant au format String
	 * @param tmpSession
	 * @return
	 */
	public FormationsDTO getSessionById(String tmpSession);
}
