package fr.utbm.lo54project.controllers;

import java.io.IOException;
import java.util.List; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.lo54project.model.Course;
import fr.utbm.lo54project.model.Location;
import fr.utbm.lo54project.model.dto.FormationsDTO; 
import fr.utbm.lo54project.serviceImpl.ClientService;
import fr.utbm.lo54project.serviceImpl.CourseService;
import fr.utbm.lo54project.serviceImpl.LocationService;
import fr.utbm.lo54project.serviceInterface.ClientServiceInterface;
import fr.utbm.lo54project.serviceInterface.CourseServiceInterface;
import fr.utbm.lo54project.serviceInterface.LocationServiceInterface;

/**
 * Controlleur de la page des clients et formations : "/clientsformation"
 * @author Lodjeu - Libam - Ntieche
 *
 */

@WebServlet("/clientsformation")
public class ClientsFormationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClientServiceInterface clientService = new ClientService();
	private CourseServiceInterface courseService = new CourseService();
	private LocationServiceInterface locationService = new LocationService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsFormationController() {
        super(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<FormationsDTO> clients = clientService.getClientsAndCourses();
		List<Course> courses = courseService.getCourses();
		List<Location> towns = locationService.getAllLocations();
		int nbRecords = clients.size();
		
		if((request.getParameter("ville")!=null && !request.getParameter("ville").isEmpty()) && 
		   (request.getParameter("course")==null || request.getParameter("course").isEmpty()) )
		{
			String tmp = request.getParameter("ville");
			clients = clientService.getClientsByTown(Integer.parseInt(tmp));
			nbRecords = clients.size();
	 	}
		else if((request.getParameter("course")!=null && !request.getParameter("course").isEmpty()) && 
	 			 (request.getParameter("ville")==null || request.getParameter("ville").isEmpty()) )
	 	{
	 		String tmp = request.getParameter("course");
			clients = clientService.getClientsByCourseName(tmp);
			nbRecords = clients.size();
	 	}
		else if((request.getParameter("ville")!=null && !request.getParameter("ville").isEmpty()) && 
				(request.getParameter("course")!=null && !request.getParameter("course").isEmpty()))
		{
	 		String course = request.getParameter("course");
	 		int ville = Integer.parseInt(request.getParameter("ville"));
			clients = clientService.getClientsByTownAndCourseName(ville, course);
			nbRecords = clients.size();
	 	}
		
		
		request.setAttribute("nbRecords", nbRecords);
		request.setAttribute("courses", courses);
		request.setAttribute("towns", towns);
		request.setAttribute("clients", clients);
		request.getRequestDispatcher("clientsformation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
