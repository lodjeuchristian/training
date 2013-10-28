package fr.utbm.lo54project.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modèle "Client" : utilisé pour le mapping avec la table Client de la base de donnée
 * Constitué d'attribut privés avec anotations, des constructeurs de getters et de setters
 * @author Lodjeu - Libam - Ntieche
 *
 */
@Entity 
@Table(name = "CLIENT")
public class Client {
	
	/**
	 * Fields mapping definition
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "ADRESS")
	private String adress;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "EMAIL")
	private String email;
	

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "SESSION_ID")
	private Session session;


	/**
	 * Constructor using all fields
	 * @param id
	 * @param lastName
	 * @param firstName
	 * @param adress
	 * @param phone
	 * @param email
	 * @param session
	 */
	public Client(int id, String lastName, String firstName, String adress,
			String phone, String email, Session session) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.session = session;
	}
 
	/**
	 * Default constructor
	 */
	public Client() {
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


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Session getSession() {
		return session;
	}


	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", lastName=" + lastName + ", firstName="
				+ firstName + ", adress=" + adress + ", phone=" + phone
				+ ", email=" + email + ", session=" + session + "]";
	}
	
 
  

}
