package fr.utbm.lo54project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
import javax.persistence.Table;

/**
 * Modèle "Session" : utilisé pour le mapping avec la table Session de la base de donnée
 * Constitué d'attribut privés avec anotations, des constructeurs de getters et de setters
 * @author Lodjeu - Libam - Ntieche
 *
 */
@Entity 
@Table(name = "SESSION")
public class Session {

	/**
	 * Fields mapping definition
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")	
	private int id;

	@Column(name = "START")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date start;
	
	@Column(name = "END")
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	
	@OneToMany(mappedBy = "session", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER) 
	private List<Client> clients = new ArrayList<Client>();
 
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "COURSE_CODE")
	private Course course;

	
	/**
	 * Constructor with all fields
	 * @param id
	 * @param start
	 * @param end
	 * @param clients
	 * @param location
	 * @param course
	 */
	public Session(int id, Date start, Date end, List<Client> clients,
			Location location, Course course) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.clients = clients;
		this.location = location;
		this.course = course;
	}

	/**
	 * Default constructor
	 */
	public Session() {
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

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public List<Client> getClients() {
		return clients;
	}
	
	public Client findClientById(int id){
		for(Client c:this.clients){
			if(c.getId() == id){
				return c;
			}
		}
		return null;
	} 
	
	public Client findClient(Client cl){
		for(Client c:this.clients){
			if(c.equals(cl)){
				return c;
			}
		}
		return null;
	} 
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public void addClient(Client c){
		this.clients.add(c);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
	public boolean removeClientById(int id){
		for(Client c:this.getClients()){
			if(c.getId() == id){
				this.getClients().remove(c);
				return true;
			}
		}
		return false;
	} 
	
	public boolean removeClient(Client cl){
		for(Client c:this.getClients()){
			if(c.equals(cl)){
				this.getClients().remove(cl);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Session [id=" + id + ", start=" + start + ", end=" + end
				+ ", clients=" + clients + ", location=" + location
				+ ", course=" + course + "]";
	}
	
 	
	
}
