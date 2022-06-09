package nounous.commun.dto;


import java.io.Serializable;
import java.util.Date;




@SuppressWarnings("serial")
public class DtoEnfant implements Serializable {
	
	private Integer				idEnfant;
		
	private String			nom;

	private String			prenom;

	private Date  			dateNaissance;
	

	//Constructeurs
	
	public DtoEnfant() {
		super();
	}


 DtoEnfant(Integer idEnfant, String nom, String prenom, Date dateNaissance) {
		super();
		this.idEnfant = idEnfant;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}





	//Getters & Setters
	





	public Integer getIdEnfant() {
		return idEnfant;
	}


	public void setIdEnfant(Integer idEnfant) {
		this.idEnfant = idEnfant;
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
