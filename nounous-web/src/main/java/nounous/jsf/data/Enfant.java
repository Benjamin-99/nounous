package nounous.jsf.data;

import java.io.Serializable;

import java.util.Date;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Enfant implements Serializable {


	// Champs
	
	private Integer			idEnfant;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String			nom;

	@NotBlank( message = "Le prénom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le prénom : 25 car. maxi" )
	private String			prenom;

	@NotNull( message = "La date de naissance est obligatoire")
	private Date  dateNaissance		;

	
	
	// Constructeurs
	
	public Enfant() {
	}

	public Enfant(Integer idEnfant,
			@NotBlank(message = "Le nom doit être renseigné") @Size(max = 25, message = "Valeur trop longue pour le nom : 25 car. maxi") String nom,
			@NotBlank(message = "Le prénom doit être renseigné") @Size(max = 25, message = "Valeur trop longue pour le prénom : 25 car. maxi") String prenom,
			@NotNull(message = "La date de naissance est obligatoire") Date dateNaissance) {
		super();
		this.idEnfant = idEnfant;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	
	
	// Getters & setters

	



	/**
	 * @return the idEnfant
	 */
	public Integer getIdEnfant() {
		return idEnfant;
	}




	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}




	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}




	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}




	/**
	 * @param idEnfant the idEnfant to set
	 */
	public void setIdEnfant(Integer idEnfant) {
		this.idEnfant = idEnfant;
	}




	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}




	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(idEnfant);
	}

	



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Enfant) obj;
		return Objects.equals(idEnfant, other.idEnfant);
	}
	

}
