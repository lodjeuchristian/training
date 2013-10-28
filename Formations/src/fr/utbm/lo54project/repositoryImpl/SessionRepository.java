package fr.utbm.lo54project.repositoryImpl;
 
import java.util.List;  
import javax.persistence.Query;  

import fr.utbm.lo54project.jpa.JpaManagement; 
import fr.utbm.lo54project.model.Session;
import fr.utbm.lo54project.repositoryInterface.SessionRepositoryInterface; 

/**
 * Repository (DAO) Session
 * Toutes les m�thodes d'acc�s utilisent le singleton JpaManagement et le language de requ�tes JPQL de JPA
 * EclipseLink va automatiquement g�rer le pool de connexion et la fermeture des sessions
 * @author Lodjeu - Libam - Ntieche
 *
 */
public class SessionRepository implements SessionRepositoryInterface{
 
	 /**
	  * Fait persister un objet de type Session pass� en param�tres
	  * @param session
	  */
	 public void saveSession(Session session){
		 JpaManagement.getInstance().getEm().getTransaction().begin();
		 JpaManagement.getInstance().getEm().persist(session);
		 JpaManagement.getInstance().getEm().getTransaction().commit();		 
	 }
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant une session en fonction de 
	  * l'identifiant pass� en param�tres
	  * @param id
	  * @return
	  */
	 public Session getSessionById(int id){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select s from Session s where s.id = "+id);	  
		 return (Session)q.getSingleResult();		 
	 }
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant la liste de toutes les sessions
	  * @return
	  */
	 public List<Session> getSessions(){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select s from Session s");
		 return q.getResultList();
	 }
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant une formation en fonction de 
	  * l'identifiant pass� en param�tre
	  * @param sessionId
	  * @return
	  */
	 public Object[] getFormationById(int sessionId){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co where s.id = "+sessionId+" order by co.code ASC");	  
		 return (Object[])q.getSingleResult();		 
	 }
	 
	 /**
	  * 
	  * @return
	  */
	 public List<Object[]> getFormationsDTO(){
		 Query q = JpaManagement.getInstance().getEm().createQuery("select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co order by co.code ASC");	  
		 return q.getResultList();		  
	 }
	 
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
	 public List<Object[]> getSearchFormationsDTO(String cours, String date, String lieu, String sortBy, String direction){ 
 		 
		 String tmp =  "co.code";
		 if(sortBy.equals("code")){
			 tmp = "co."+sortBy;
		 }
		 else
		 if(sortBy.equals("title")){
			 tmp= "co."+sortBy;
		 }
		 else
		 if(sortBy.equals("city")){ 
			 tmp = "l."+sortBy;
		 }
		 else{
	 		 tmp = "s."+sortBy;
		 }
		 sortBy = tmp;
		 
		 String request = "select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co order by "+sortBy+" "+direction; 
		 if(cours == "" && date == "" && lieu == ""){  
			 request = "select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co order by "+sortBy+" "+direction;
		 }
		 else
		 if(cours == "" && date == "" && lieu != ""){
			 request = "select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co where l.city = '"+lieu+"' order by "+sortBy+" "+direction;
		 }
		 else
		 if(cours == "" && date != "" && lieu == ""){ 
			 request = "select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co where  (s.start < '"+date+"' AND s.end > '"+date+"')  order by "+sortBy+" "+direction;
		 }
		 else
		 if(cours != "" && date == "" && lieu == ""){
			 request = "select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co where co.title like '%"+cours+"%' order by "+sortBy+" "+direction;
		 }
		 else
		 if(cours != "" && date != "" && lieu == ""){
			 request = "select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co where co.title like '%"+cours+"%' AND (s.start < '"+date+"' AND s.end > '"+date+"')  order by "+sortBy+" "+direction;
		 }
		 else
		 if(cours == "" && date != "" && lieu != ""){
			 request = "select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co where (s.start < '"+date+"' AND s.end > '"+date+"')  AND l.city = '"+lieu+"' order by "+sortBy+" "+direction;
		 }
		 else
		 if(cours != "" && date == "" && lieu != ""){
			 request = "select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co where co.title like '%"+cours+"%' AND l.city = '"+lieu+"' order by "+sortBy+" "+direction;
		 }
		 else
		 if(cours != "" && date != "" && lieu != ""){
			 request = "select s.id, co.code, co.title, l.city, s.start, s.end from Session s join s.location l join s.course co where co.title like '%"+cours+"%' AND (s.start < '"+date+"' AND s.end > '"+date+"')  AND l.city = '"+lieu+"' order by "+sortBy+" "+direction; 
		 }	  
		 
		 Query q = JpaManagement.getInstance().getEm().createQuery(request);   
		 return q.getResultList();	 
		  
 
	 }
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant les session en fonction de l'identifiant du cours pass� en param�tre
	  * @param courseId
	  * @return
	  */
	 public List<Object[]> getSessionsByCourses(String courseId){ 
		 Query q = JpaManagement.getInstance().getEm().createQuery("select l.city, s.start, s.end, co.title from Session s join s.location l join s.course co where co.code = '"+courseId+"'");
		 return q.getResultList();	
	 }
	 
	 /**
	  * Cr�e et ex�cute la requ�te retournant une session en fonction de son identiant
	  * @param tmpSession
	  * @return
	  */
	 public Object[] getSessionByStringId(String tmpSession){
		 int tmp = Integer.parseInt( tmpSession); 
		 Query q = JpaManagement.getInstance().getEm().createQuery("select s.id, s.start, s.end, l.city, co.title from Session s join s.location l join s.course co where s.id = "+tmp);
		 return (Object[]) q.getSingleResult();
	 }
	 
 

	 
	
}
