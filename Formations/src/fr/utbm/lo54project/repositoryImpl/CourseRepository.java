package fr.utbm.lo54project.repositoryImpl;
 
import java.util.List; 
import javax.persistence.Query; 
import fr.utbm.lo54project.jpa.JpaManagement; 
import fr.utbm.lo54project.model.Course;
import fr.utbm.lo54project.repositoryInterface.CourseRepositoryInterface;

/**
 * Repository (DAO) Course 
 * Toutes les m�thodes d'acc�s utilisent le singleton JpaManagement et le language de requ�tes JPQL de JPA
 * EclipseLink va automatiquement g�rer le pool de connexion et la fermeture des sessions
 * @author Lodjeu - Libam - Ntieche
 *
 */
public class CourseRepository implements CourseRepositoryInterface{
 
	 /**
	  * Fait persister un objet de type Client pass� en param�tres
	  * @param course
	  */
	 public void saveCourse(Course course){
		 JpaManagement.getInstance().getEm().getTransaction().begin();
		 JpaManagement.getInstance().getEm().persist(course);
		 JpaManagement.getInstance().getEm().getTransaction().commit();		 
	 }
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant la liste de tous les cours 
	  * @return
	  */
	 public List<Course> getCourses(){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select co from Course co");
		 return q.getResultList();
	 }
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant un cours en fonction de son identifiant
	  * pass� en param�tres
	  * @param id
	  * @return
	  */
	 public Course getCourseById(String id){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select c from Course c where c.code = '"+id+"'");
		 return (Course)q.getSingleResult(); 
	 }
	
}
