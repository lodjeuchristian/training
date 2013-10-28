package fr.utbm.lo54project.repositoryInterface;

import java.util.List;   

import fr.utbm.lo54project.model.Course;

/**
 * Interface CourseRepositoryInterface : définit le contrat à respecter par tous les courseRepository
 * @author Lodjeu - Libam - Ntieche
 *
 */
public interface CourseRepositoryInterface {
	
	 /**
	  * Fait persister un objet de type Client passé en paramètres
	  * @param course
	  */
	 public void saveCourse(Course course);
	 
	 /**
	  * Crée et exécute la requête retournant la liste de tous les cours 
	  * @return
	  */
	 public List<Course> getCourses();
	 
	 /**
	  * Crée et exécute la requête retournant un cours en fonction de son identifiant
	  * passé en paramètres
	  * @param id
	  * @return
	  */
	 public Course getCourseById(String id);
}
