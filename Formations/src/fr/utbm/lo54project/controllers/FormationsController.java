package fr.utbm.lo54project.controllers;

import java.io.IOException; 
import java.util.List;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import fr.utbm.lo54project.model.Location;
import fr.utbm.lo54project.model.dto.FormationsDTO; 
import fr.utbm.lo54project.serviceImpl.LocationService;
import fr.utbm.lo54project.serviceImpl.SessionService;
import fr.utbm.lo54project.serviceInterface.LocationServiceInterface;
import fr.utbm.lo54project.serviceInterface.SessionServiceInterface;

/**
 * Controlleur de la page des formations : "/formations"
 * @author Lodjeu - Libam - Ntieche
 *
 */

@WebServlet("/formations")
public class FormationsController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String direction = new String(""); 
	private String sortBy = new String("");  
	private LocationServiceInterface locationService = new LocationService();
	private SessionServiceInterface sessionService = new SessionService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormationsController() {
    	this.direction = "ASC"; 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String cours = "";  
		String date = null;
		String lieu = ""; 
		
		/*
		 * On construit les cookies ccours, clieu et cdate qui vont conserver les valeurs entrées dans les champs de recherche
		 */
		Cookie ccours = null, clieu = null;
		Cookie cdate =  new Cookie("date", "");
		
		if(request.getParameter("date") != null){
			if(request.getParameter("date") != ""){
				date =  request.getParameter("date");
				cdate = new Cookie("date", request.getParameter("date"));
			}
			else
			{
				date = null;
				cdate = new Cookie("date", "");
			}
		}
		if(request.getParameter("cours") != null){
			cours = request.getParameter("cours");
		}
		else
		{
			cours = "";
		}
		if(request.getParameter("lieu") != null){
			lieu = request.getParameter("lieu");
		} 
		else{
			lieu = "";
		}
		
		if(request.getParameter("sortby") != null){
			sortBy = request.getParameter("sortby");
		} 
		else
		{
			sortBy = "code";
		} 
		 
		ccours = new Cookie("cours",cours); 
		clieu = new Cookie("lieu",lieu);
		
		if(request.getParameter("op") != null){
			if(request.getParameter("op").equals("sort")){  
				if(direction == "ASC"){
					direction = "DESC"; 
				}
				else
				{
					direction = "ASC";
				}
			}
		}   
  
		/*
		 * On récupère la liste des formations en faisant appel au service sessionService.
		 * La liste obtenue est stockée dans formations
		 */
	 	List<FormationsDTO> formations = sessionService.getSearchFormations(cours,date,lieu,sortBy,direction); 
	 	
	 	List<Location> locations = locationService.getAllLocations();
	 	
	 	/*
	 	 * On ajoute les listes 'formations' et 'locations' à l'objet request, afin d'être utiliser par les vues jsp
	 	 */
	 	request.setAttribute("allFormations", formations); 
	 	request.setAttribute("allLocations", locations);
	 	if(formations == null){
	 		request.setAttribute("nbRecords", 0);
	 	}
	 	else
	 	{
	 		request.setAttribute("nbRecords", formations.size());
	 	} 
	 	
	 	/*
	 	 * On ajoute les élements de la recherche aux cookies correspondants
	 	 */
	 	response.addCookie(ccours); 
	 	response.addCookie(clieu);
	 	response.addCookie(cdate); 
	 	request.getRequestDispatcher("formations.jsp").forward(request, response); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
