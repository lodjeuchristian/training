package fr.utbm.lo54project.serviceImpl;

import java.text.DateFormat;
import java.util.ArrayList; 
import java.util.List;

import fr.utbm.lo54project.model.Client;
import fr.utbm.lo54project.model.dto.FormationsDTO;
import fr.utbm.lo54project.repositoryImpl.ClientRepository;
import fr.utbm.lo54project.repositoryInterface.ClientRepositoryInterface;
import fr.utbm.lo54project.serviceInterface.ClientServiceInterface;

/**
 * Service ClientService : fournit un ensemble de méthodes permettant de
 * récuperer et modifier le contenu de la table Client contenue dans la BD
 * @author Lodjeu - Libam - Ntieche
 *
 */
public class ClientService implements ClientServiceInterface{ 

	private ClientRepositoryInterface clientRepository = new ClientRepository();
	
	
	/**
	 * Enregistre un nouveau client dans la BD
	 * @param c
	 * @return
	 */
	public boolean saveClient(Client c){
		if(clientRepository.saveClient(c)){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Crée et enregistre un nouveau client donnant directement ses paramètres
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param adresse
	 * @return
	 */
	public boolean addClient(String nom, String prenom, String email, String telephone, String adresse){
		
		Client c = new Client();
		c.setFirstName(prenom);
		c.setLastName(nom);
		c.setEmail(email);
		c.setPhone(telephone);
		c.setAdress(adresse);
		
		if(clientRepository.saveClient(c)){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Retourne un client en fonction des paramètres spécifiés
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param adresse
	 * @return
	 */
	public Client getClientByFields(String nom, String prenom, String email, String telephone, String adresse){
		return clientRepository.getClientByFields(nom, prenom, email, telephone, adresse); 
	 
	}
	
	/**
	 * Retourne les clients inscrits à une session
	 * @param sessionId
	 * @return
	 */
	public List<Client> getClientsBySession(int sessionId){
		return clientRepository.getClientsBySession(sessionId);
	}
	
	/**
	 * Retourne la liste associant les clients aux cours 
	 * @return
	 */
	public List<FormationsDTO> getClientsAndCourses(){
		 List<Object[]> clients = clientRepository.getClientsAndCourses();
		 List<FormationsDTO> liste = new ArrayList<FormationsDTO>();
		 
		for(Object[] c:clients){  
			  FormationsDTO fdao = new FormationsDTO();
			  fdao.setClientFirstName((String)c[0]);
			  fdao.setClientLastName((String)c[1]);
			  fdao.setCourseTitle((String)c[2]);
			  DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			  fdao.setCourseStartDate(shortDateFormat.format(c[3]));
			  fdao.setCourseLocation((String)c[4]);
			 
			  liste.add(fdao);
		 }
		return liste;
	 }
	 
	 
	 public List<FormationsDTO> getClientCourses(){
		 List<String> clients = clientRepository.getClientCourses();
		 List<FormationsDTO> liste = new ArrayList<FormationsDTO>();
		 
		 for(String c:clients){  
			  FormationsDTO fdao = new FormationsDTO();
			  fdao.setCourseTitle((String)c); 
			  
			  liste.add(fdao);
		 }
		return liste;
	 }
	 
	 /**
	  * Retourne la liste des clients en fonction de l'identifiant de la ville
	  * @param id
	  * @return
	  */
	 public List<FormationsDTO> getClientsByTown(int id){
		 List<Object[]> clients = clientRepository.getClientsByTown(id);
		 List<FormationsDTO> liste = new ArrayList<FormationsDTO>();
		 
		for(Object[] c:clients){  
			  FormationsDTO fdao = new FormationsDTO();
			  fdao.setClientFirstName((String)c[0]);
			  fdao.setClientLastName((String)c[1]);
			  fdao.setCourseTitle((String)c[2]);
			  DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			  fdao.setCourseStartDate(shortDateFormat.format(c[3]));
			  fdao.setCourseLocation((String)c[4]);
			 
			  liste.add(fdao);
		 }
		return liste;
	 }
	 
	 /**
	  * Retourne la liste des clients en fonction du nom du cours
	  * @param cd
	  * @return
	  */
	 public List<FormationsDTO> getClientsByCourseName(String cd){
		 List<Object[]> clients = clientRepository.getClientsByCourseName(cd);
		 List<FormationsDTO> liste = new ArrayList<FormationsDTO>();
		 
		for(Object[] c:clients){  
			  FormationsDTO fdao = new FormationsDTO();
			  fdao.setClientFirstName((String)c[0]);
			  fdao.setClientLastName((String)c[1]);
			  fdao.setCourseTitle((String)c[2]);
			  DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			  fdao.setCourseStartDate(shortDateFormat.format(c[3]));
			  fdao.setCourseLocation((String)c[4]);
			 
			  liste.add(fdao);
		 }
		return liste;
	 }
	 
	 /**
	  * Retourne la liste des clients en fonction du cours et de la ville
	  * @param id
	  * @param cd
	  * @return
	  */
	 public List<FormationsDTO> getClientsByTownAndCourseName(int id, String cd){
		 List<Object[]> clients = clientRepository.getClientsByTownAndCourseName(id,cd);
		 List<FormationsDTO> liste = new ArrayList<FormationsDTO>();
		 
		for(Object[] c:clients){  
			  FormationsDTO fdao = new FormationsDTO();
			  fdao.setClientFirstName((String)c[0]);
			  fdao.setClientLastName((String)c[1]);
			  fdao.setCourseTitle((String)c[2]);
			  DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			  fdao.setCourseStartDate(shortDateFormat.format(c[3]));
			  fdao.setCourseLocation((String)c[4]);
			 
			  liste.add(fdao);
		 }
		return liste;
	 }
}
