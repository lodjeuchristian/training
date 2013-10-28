package fr.utbm.lo54project.serviceImpl;
 
import java.text.DateFormat;
import java.util.ArrayList; 
import java.util.List; 
import fr.utbm.lo54project.model.Session;
import fr.utbm.lo54project.model.dto.FormationsDTO;
import fr.utbm.lo54project.repositoryImpl.SessionRepository; 
import fr.utbm.lo54project.repositoryInterface.SessionRepositoryInterface;
import fr.utbm.lo54project.serviceInterface.SessionServiceInterface;

/**
 * Service SessionService : fournit un ensemble de méthodes permettant de
 * récuperer et modifier le contenu de la table Session contenue dans la BD
 * @author Lodjeu - Libam - Ntieche
 *
 */
public class SessionService implements SessionServiceInterface{
 	
	private SessionRepositoryInterface sessionRepository = new SessionRepository();
	
	/**
	 * Service qui retourne une session en fonction de son id
	 */
	public Session getSessionById(int id){
		return sessionRepository.getSessionById(id);
	}
	

	
	/**
	 * Service qui retourne une formation donnée en fonction de l'id de la session
	 */
	public FormationsDTO getFormationById(int sessionId){
		
		Object[] s = sessionRepository.getFormationById(sessionId);
		FormationsDTO fdao = new FormationsDTO();
		fdao.setSessionId(Utils.cryptId((int)s[0]));
		fdao.setCourseCode((String)s[1]);
		fdao.setCourseTitle((String)s[2]);
		fdao.setCourseLocation((String)s[3]);
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		fdao.setCourseStartDate(shortDateFormat.format(s[4]));
		DateFormat shortDateFormat2 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		fdao.setCourseEndDate(shortDateFormat2.format(s[5])); 
		
		return fdao;
	}
	
	
	/**
	 * Service qui retourne la liste de toutes les formations
	 * @return
	 */
	public List<FormationsDTO> getAllFormations(){
		 
	  List<Object[]> sdao = sessionRepository.getFormationsDTO();
	  List<FormationsDTO> liste = new ArrayList<FormationsDTO>();
	  
	  if(sdao.isEmpty()){
		  return null;
	  }
	  else
	  {
		  for(Object[] s:sdao){  
			  
			  FormationsDTO fdao = new FormationsDTO();
			  fdao.setSessionId(Utils.cryptId((int)s[0]));
			  fdao.setCourseCode((String)s[1]);
			  fdao.setCourseTitle((String)s[2]);
			  fdao.setCourseLocation((String)s[3]);
			  DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			  fdao.setCourseStartDate(shortDateFormat.format(s[4]));
			  DateFormat shortDateFormat2 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			  fdao.setCourseEndDate(shortDateFormat2.format(s[5])); 
			  
			  liste.add(fdao);
		  }
		  return liste;
	  }
	}
	
	
	/**
	 * Service qui retourne la liste de toutes les formations suivant le filtre
	 * @return
	 */
	public List<FormationsDTO> getSearchFormations(String cours, String date, String lieu, String sortBy, String direction){
		 
		String cdate = "";
		  if(date != "" && date != null){
			  cdate = Utils.convertToEnDate(date);
		  }
		  List<Object[]> sdao = sessionRepository.getSearchFormationsDTO(cours,cdate, lieu, sortBy, direction);
		  List<FormationsDTO> liste = new ArrayList<FormationsDTO>();
		  if(sdao.isEmpty()){
			  return null;
		  }
		  else
		  {
			  for(Object[] s:sdao){  
				  
				  FormationsDTO fdao = new FormationsDTO();
				  fdao.setSessionId(Utils.cryptId((int)s[0])); 
				  fdao.setCourseCode((String)s[1]);
				  fdao.setCourseTitle((String)s[2]);
				  fdao.setCourseLocation((String)s[3]);
				  DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
				  fdao.setCourseStartDate(shortDateFormat.format(s[4]));
				  DateFormat shortDateFormat2 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
				  fdao.setCourseEndDate(shortDateFormat2.format(s[5])); 
				  
				  liste.add(fdao);
			  }
			  return liste;		
		  }
	}
	
	/**
	 * Service qui retourne la liste des sessions en fonction de l'identifiant du cours
	 * @param courseId
	 * @return
	 */
	public List<FormationsDTO> getSessionsByCourses(String courseId)
	{
		List<Object[]> sessions = sessionRepository.getSessionsByCourses(courseId);
		List<FormationsDTO> liste = new ArrayList<FormationsDTO>();
		
		for(Object[] s:sessions){  
			  FormationsDTO fdao = new FormationsDTO();
			  fdao.setCourseLocation((String)s[0]);
			  DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			  fdao.setCourseStartDate(shortDateFormat.format(s[1]));
			  DateFormat shortDateFormat1 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			  fdao.setCourseEndDate(shortDateFormat1.format(s[2]));
			  fdao.setCourseTitle((String)s[3]);
			 
			  liste.add(fdao);
		 }
		return liste;
	}
	
	/**
	 * Service qui retourne une session en fonction de son identiant au format String
	 * @param tmpSession
	 * @return
	 */
	public FormationsDTO getSessionById(String tmpSession){
		Object[] sess = sessionRepository.getSessionByStringId(tmpSession);
		FormationsDTO fdao = new FormationsDTO();
		
		fdao.setSessionId((String)sess[0].toString());
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		fdao.setCourseStartDate(shortDateFormat.format(sess[1]));
		DateFormat shortDateFormat1 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		fdao.setCourseEndDate(shortDateFormat1.format(sess[2]));
		fdao.setCourseLocation((String)sess[3]);
		fdao.setCourseTitle((String)sess[4]);
		
		return fdao;	
	}
}
