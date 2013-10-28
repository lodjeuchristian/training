package fr.utbm.lo54project.serviceInterface;
  
import java.util.List;  
import fr.utbm.lo54project.model.Course;
import fr.utbm.lo54project.model.dto.FormationsDTO;

/**
 * Interface CourseServiceInterface : définit le contrat à respecter par tous les courseService
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface CourseServiceInterface {

	/**
	 * Service qui retourne un cours en fonction de son identifiant
	 * @param courseTitle
	 * @return
	 */
	public FormationsDTO getCourseById(String courseTitle);
	
	/**
	 * Retourne la liste de tous les noms de cours
	 * @return
	 */
	public List<FormationsDTO> getCoursesName();
	
	/**
	 * Retourne la liste de tous les cours 
	 * @return
	 */
	public List<Course> getCourses();
}
