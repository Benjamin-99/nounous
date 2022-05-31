package nounous.commun.dto;


import java.io.Serializable;
import java.util.Date;




@SuppressWarnings("serial")
public class DtoEnfant implements Serializable {
	
	private int				idEnfant;
	
	private int 			idparent;
	
	private String			nom;

	private String			prenom;

	private Date  			dateNaissance;
	

	//Constructeurs
	
	public DtoEnfant() {
		super();
	}


	public DtoEnfant(int idEnfant, int idparent, String nom, String prenom, Date dateNaissance) {
		super();
		this.idEnfant = idEnfant;
		this.idparent = idparent;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	
	
	//Getters & Setters
	





	public int getIdEnfant() {
		return idEnfant;
	}


	public void setIdEnfant(int idEnfant) {
		this.idEnfant = idEnfant;
	}


	public int getIdparent() {
		return idparent;
	}


	public void setIdparent(int idparent) {
		this.idparent = idparent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
