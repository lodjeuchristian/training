package fr.utbm.lo54project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Modèle "Location" : utilisé pour le mapping avec la table Location de la base de donnée
 * Constitué d'attribut privés avec anotations, des constructeurs de getters et de setters
 * @author Lodjeu - Libam - Ntieche
 *
 */
@Entity 
@Table(name = "LOCATION")
public class Location {

	/**
	 * Fields mapping definition
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CITY")
	private String city;
	
	
	@OneToMany(mappedBy = "location", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER) 
	private List<Session> sessions = new ArrayList<Session>();


	/**
	 * Constructor using all fields
	 * @param id
	 * @param city
	 * @param sessions
	 */
	public Location(int id, String city, List<Session> sessions) {
		super();
		this.id = id;
		this.city = city;
		this.sessions = sessions;
	}

	/**
	 * Default constructor
	 */
	public Location() {
		super();
	}


	/**
	 * Getters and setters
	 * @return
	 */
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public List<Session> getSessions() {
		return sessions;
	}
	
	public Session findSessionById(int id){
		for(Session s:this.getSessions()){
			if(s.getId() == id){
				return s;
			}
		}
		return null;
	} 
	
	public Session findSession(Session se){
		for(Session s:this.getSessions()){
			if(s.equals(se)){
				return s;
			}
		}
		return null;
	} 


	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	
	public void setSession(Session s){
		this.sessions.add(s);
	}

	
	public boolean removeSessionById(int id){
		for(Session s:this.getSessions()){
			if(s.getId() == id){
				this.getSessions().remove(s);
				return true;
			}
		}
		return false;
	} 
	
	public boolean removeSession(Session se){
		for(Session s:this.getSessions()){
			if(s.equals(se)){
				this.getSessions().remove(se);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", sessions="
				+ sessions + "]";
	}
 
	
	
}
