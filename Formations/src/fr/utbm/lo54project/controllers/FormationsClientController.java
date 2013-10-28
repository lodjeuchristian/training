package fr.utbm.lo54project.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.lo54project.model.Client;
import fr.utbm.lo54project.model.dto.FormationsDTO;
import fr.utbm.lo54project.serviceImpl.ClientService;
import fr.utbm.lo54project.serviceImpl.CourseService; 
import fr.utbm.lo54project.serviceImpl.SessionService;
import fr.utbm.lo54project.serviceImpl.Utils;
import fr.utbm.lo54project.serviceInterface.ClientServiceInterface;
import fr.utbm.lo54project.serviceInterface.CourseServiceInterface; 
import fr.utbm.lo54project.serviceInterface.SessionServiceInterface;

/**
 * Controlleur de la page des clients par formation : "/formationsclient"
 * @author Lodjeu - Libam - Ntieche
 *
 */

@WebServlet("/formationsclient")
public class FormationsClientController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClientServiceInterface clientService = new ClientService();
	private CourseServiceInterface courseService = new CourseService();
	private SessionServiceInterface sessionService = new SessionService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormationsClientController() {
        super(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 	List<FormationsDTO> formations = courseService.getCoursesName();
	 	List<FormationsDTO> sessionsCourses = sessionService.getSessionsByCourses(""); 
	 	SessionServiceInterface allSessions = new SessionService();
	 	int nbRecords = 0;
	 	
	 	
	 	if(request.getParameter("session")!=null && request.getParameter("session")!=""){
	 		String tmpSession = request.getParameter("session");
	 		int unCryptedIdInt = Utils.decryptId(tmpSession);
	 		String unCryptedIdString = ""+unCryptedIdInt;
	 		FormationsDTO  oneSession =  sessionService.getSessionById(unCryptedIdString);
	 		
	 		List<Client> clientsList = clientService.getClientsBySession(unCryptedIdInt);
	 		request.setAttribute("clientsList", clientsList);
	 		
	 		nbRecords = clientsList.size();
	 		request.setAttribute("oneSession", oneSession);
	 		
	 	} 
	 	
	 	request.setAttribute("nbRecords", nbRecords); 
	 	request.setAttribute("allSessions", allSessions);
	 	request.setAttribute("formations", formations);
	 	request.setAttribute("sessionsCourses", sessionsCourses);
		request.getRequestDispatcher("formationsclient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
