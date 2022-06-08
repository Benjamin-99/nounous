package nounous.jsf.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
public class Enfant implements Serializable  {

	
	// Champs
	
	
	private Integer			idEnfant;
	
	@NotNull
	private String			nom;

	@NotNull
	private String			prenom;

	@NotNull
	private Date  			dateNaissance;
	
	private Parent          parent;
	
	
	// Constructeurs
	
	public Enfant(@NotNull int idEnfant, @NotNull int idparent, @NotNull String nom, @NotNull String prenom,
			@NotNull Date dateNaissance) {
		super();
		this.idEnfant = idEnfant;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}



	public Enfant() {
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



	public Parent getParent() {
		return parent;
	}



	public void setParent(Parent parent) {
		this.parent = parent;
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
