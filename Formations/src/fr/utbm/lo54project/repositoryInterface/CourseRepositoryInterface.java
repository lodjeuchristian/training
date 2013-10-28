package fr.utbm.lo54project.repositoryInterface;

import java.util.List;   

import fr.utbm.lo54project.model.Course;

/**
 * Interface CourseRepositoryInterface : d�finit le contrat � respecter par tous les courseRepository
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface CourseRepositoryInterface {
	
	 /**
	  * Fait persister un objet de type Client pass� en param�tres
	  * @param course
	  */
	 public void saveCourse(Course course);
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant la liste de tous les cours 
	  * @return
	  */
	 public List<Course> getCourses();
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant un cours en fonction de son identifiant
	  * pass� en param�tres
	  * @param id
	  * @return
	  */
	 public Course getCourseById(String id);
}
