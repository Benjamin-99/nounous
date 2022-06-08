package nounous.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Timer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "enfant" )
public class Enfant {

	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idenfant" )
	private int				idEnfant;
	
	@Column( name = "nomenfant" )
	private String			nom;

	@ManyToOne
	@JoinColumn( name = "idparent" )
	private Parent		parent;

	@Column( name = "prenomenfant" )
	private String			prenom;

	@Column( name = "dateNaissance" )
	private Date  			dateNaissance;
	
	//Constructeurs
	
	public Enfant() {
		super();
	}


	public Enfant(String nom, String prenom, Date dateNaissance, Date dateDeGarde, Timer heureArrivee,
			Timer heureDepart, boolean repas) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;

	}
	
	
	//Getters & Setters
	
	public int getIdEnfant() {
		return idEnfant;
	}


	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public void setIdEnfant(int idEnfant) {
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
