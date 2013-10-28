package fr.utbm.lo54project.controllers;

import java.io.IOException; 
import java.text.DateFormat; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import fr.utbm.lo54project.model.Client;
import fr.utbm.lo54project.model.Session;
import fr.utbm.lo54project.model.dto.FormationsDTO;
import fr.utbm.lo54project.serviceImpl.ClientService; 
import fr.utbm.lo54project.serviceImpl.SessionService; 
import fr.utbm.lo54project.serviceImpl.Utils;
import fr.utbm.lo54project.serviceInterface.ClientServiceInterface; 
import fr.utbm.lo54project.serviceInterface.SessionServiceInterface;

/**
 * Controlleur de la page d'inscription : "/inscription"
 * @author Lodjeu - Libam - Ntieche
 *
 */
@WebServlet("/inscription")
public class InscriptionController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final int COOKIE_MAX_AGE  = 60 * 60 * 24 * 365;  //un an
	private ClientServiceInterface clientService = new ClientService();
	private SessionServiceInterface sessionService = new SessionService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = "";
		 
		if(request.getParameter("num") != null){
			num = request.getParameter("num");
		}  
		int idSession = Utils.decryptId(num);  
 
		/*
		 * On ajoute les cookies s'il existent, aux champs du formulaire 
		 */
		Client cCookie = new Client();
		cCookie.setLastName(Utils.getCookieValue(request, "nom"));
		cCookie.setFirstName(Utils.getCookieValue(request, "prenom"));
		cCookie.setAdress(Utils.getCookieValue(request, "adresse"));
		cCookie.setPhone(Utils.getCookieValue(request, "telephone"));
		cCookie.setEmail(Utils.getCookieValue(request, "email"));
		
		FormationsDTO formation = sessionService.getFormationById(idSession); 
		request.setAttribute("fselected", formation); 
		request.setAttribute("clientCookie", cCookie);
	 	request.getRequestDispatcher("inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = "";
		String prenom = "";
		String email = "";
		String telephone = "";
		String adresse = "";
		String sessionId = "";
		String saveClientData = "";
		
		/*
		 * On récupère les champs du formulaire
		 */
		if(request.getParameter("nom") != null){
			nom = request.getParameter("nom");
		}
		if(request.getParameter("prenom") != null){
			prenom = request.getParameter("prenom");
		}
		if(request.getParameter("email") != null){
			email = request.getParameter("email");
		}
		if(request.getParameter("telephone") != null){
			telephone = request.getParameter("telephone");
		}
		if(request.getParameter("adresse") != null){
			adresse = request.getParameter("adresse");
		}
		if(request.getParameter("sessionId") != null){
			sessionId = request.getParameter("sessionId");
		}
		if(request.getParameter("saveclientdata") != null){
			saveClientData = request.getParameter("saveclientdata");
		}		
		 
		
		if(saveClientData.equals("on")){
 
			/*
			 * Si le client a coché la case 'sauvegarder vos informations'
			 * On créer les cookies qui contiendrons tous les champs du formualaire
			 */
	        Cookie cookieNom = new Cookie("nom", nom);
	        cookieNom.setMaxAge(COOKIE_MAX_AGE);
	        response.addCookie(cookieNom);
	        
	        Cookie cookiePrenom = new Cookie("prenom", prenom);
	        cookiePrenom.setMaxAge(COOKIE_MAX_AGE);
	        response.addCookie(cookiePrenom);
	        
	        Cookie cookieMail = new Cookie("email", email);
	        cookieMail.setMaxAge(COOKIE_MAX_AGE);
	        response.addCookie(cookieMail);
	        
	        Cookie cookieAdresse = new Cookie("adresse", adresse);
	        cookieAdresse.setMaxAge(COOKIE_MAX_AGE);
	        response.addCookie(cookieAdresse);
	        
	        Cookie cookieTelephone = new Cookie("telephone", telephone);
	        cookieTelephone.setMaxAge(COOKIE_MAX_AGE);
	        response.addCookie(cookieTelephone);
		}
		else
		{
			/*
			 * Si la case 'sauvegarder vos informations' est décochée,
			 * on supprime tous les cookies contenant les champs du formulaire
			 */
	        Cookie cookie = new Cookie("nom", "");
	        cookie.setMaxAge(0);
	        response.addCookie(cookie);
	        
	        Cookie cookiePrenom = new Cookie("prenom", "");
	        cookiePrenom.setMaxAge(0);
	        response.addCookie(cookiePrenom);
	        
	        Cookie cookieMail = new Cookie("email", "");
	        cookieMail.setMaxAge(0);
	        response.addCookie(cookieMail);
	        
	        Cookie cookieAdresse = new Cookie("adresse", "");
	        cookieAdresse.setMaxAge(0);
	        response.addCookie(cookieAdresse);
	        
	        Cookie cookieTelephone = new Cookie("telephone", "");
	        cookieTelephone.setMaxAge(0);
	        response.addCookie(cookieTelephone);
		}
 
		/*
		 * On ajoute le client à la formation
		 */
		if(clientService.addClient(nom,prenom,email,telephone,adresse)){
			
			/*
			 * decryptId et cryptId permettent de décrypter et crypter l'id 
			 * afin que l'id réel ne soit pas visible dans la barre d'adresse du navigateur
			 */
			int realId = Utils.decryptId(sessionId);
			Session s = sessionService.getSessionById(realId); 
			
			Client previousOne = clientService.getClientByFields(nom,prenom,email,telephone,adresse); 
			previousOne.setSession(s);
			if(clientService.saveClient(previousOne)){
				DateFormat shortDateFormat2 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
				String sdate = shortDateFormat2.format(s.getStart()); 
				String edate = shortDateFormat2.format(s.getEnd());
				request.setAttribute("sessionAddedsd", sdate);
				request.setAttribute("sessionAddeded", edate);
				request.setAttribute("clientAdded", previousOne); 
			 	request.getRequestDispatcher("inscription.jsp").forward(request, response);	
			}
			else
			{
				request.setAttribute("errorWhileAdding", "errorWhileAdding");
			 	request.getRequestDispatcher("inscription.jsp").forward(request, response);				
			} 
		};
	}

}
