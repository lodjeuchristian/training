package fr.utbm.lo54project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType; 
import javax.persistence.Id; 
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Modèle "Course" : utilisé pour le mapping avec la table Course de la base de donnée
 * Constitué d'attribut privés avec anotations, des constructeurs de getters et de setters
 * @author Lodjeu - Libam - Ntieche
 *
 */
@Entity 
@Table(name = "COURSE")
public class Course {
	
	/**
	 * Fields mapping definition
	 */
	@Id 
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "TITLE")
	private String title;
	
	
	@OneToMany(mappedBy = "course", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER) 
	private List<Session> sessions = new ArrayList<Session>();

	
	/**
	 * Constructor using all fields
	 * @param code
	 * @param title
	 * @param sessions
	 */
	public Course(String code, String title, List<Session> sessions) {
		super();
		this.code = code;
		this.title = title;
		this.sessions = sessions;
	}

	/**
	 * Default constructor
	 */
	public Course() {
		super();
	}

	/**
	 * Getters and setters
	 * @return
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	public void addSession(Session s){
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
		return "Course [code=" + code + ", title=" + title + ", sessions="
				+ sessions + "]";
	}
 
	
}
