package fr.utbm.lo54project.serviceImpl;
 
import java.util.ArrayList;
import java.util.List; 
import fr.utbm.lo54project.model.Course;
import fr.utbm.lo54project.model.dto.FormationsDTO;
import fr.utbm.lo54project.repositoryImpl.CourseRepository;
import fr.utbm.lo54project.repositoryInterface.CourseRepositoryInterface;
import fr.utbm.lo54project.serviceInterface.CourseServiceInterface;

/**
 * Service CourseService : fournit un ensemble de méthodes permettant de
 * récuperer et modifier le contenu de la table Course contenue dans la BD
 * @author Lodjeu - Libam - Ntieche
 *
 */
public class CourseService implements CourseServiceInterface{
	
	private CourseRepositoryInterface courseRepository = new CourseRepository();
	
	/**
	 * Service qui retourne un cours en fonction de son identifiant
	 * @param courseTitle
	 * @return
	 */
	public FormationsDTO getCourseById(String courseTitle)
	{
		Course cl = courseRepository.getCourseById(courseTitle); 
		FormationsDTO fdao = new FormationsDTO();
		fdao.setCourseTitle(cl.getTitle());
		return fdao;
	}
	
	/**
	 * Retourne la liste de tous les noms de cours
	 * @return
	 */
	public List<FormationsDTO> getCoursesName()
	{
		List<Course> courses = courseRepository.getCourses();
		List<FormationsDTO> liste = new ArrayList<FormationsDTO>();
		
		for(Course s:courses){  
			  FormationsDTO fdao = new FormationsDTO();
			  fdao.setCourseCode(s.getCode());
			  fdao.setCourseTitle(s.getTitle());
			  liste.add(fdao);
		 }
		return liste;
	}
	
	/**
	 * Retourne la liste de tous les cours 
	 * @return
	 */
	public List<Course> getCourses(){
		List<Course> courses = courseRepository.getCourses();	
		return courses;
	}
}
