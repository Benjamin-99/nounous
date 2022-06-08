package nounous.jsf.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Nounou implements Serializable  {

	
	// Champs
	
	Integer		idNounou;
	
	@NotBlank( message = "Le pseudo doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le pseuo : 25 car. maxi" )
	private String		nom;

	@NotBlank( message = "Le pseudo doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le pseuo : 25 car. maxi" )
	private String		prenom;
	
	private String		adresse;
	
	private List<Telephone>	telephones = new ArrayList<>();	
	
	private List<Contrat> contrats;
	// Constructeurs
	
	public Nounou() {
	}
		
	
	public Nounou(Integer idNounou,
			@NotBlank(message = "Le pseudo doit être renseigné") @Size(max = 25, message = "Valeur trop longue pour le pseuo : 25 car. maxi") String nom,
			@NotBlank(message = "Le pseudo doit être renseigné") @Size(max = 25, message = "Valeur trop longue pour le pseuo : 25 car. maxi") String prenom,
			String adresse, String telephone) {
		super();
		this.idNounou = idNounou;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	// Getters & setters








	/**
		 * @return the idNounou
		 */
		public Integer getIdNounou() {
			return idNounou;
		}




		public List<Telephone> getTelephones() {
		return telephones;
	}


	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
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
		 * @return the adresse
		 */
		public String getAdresse() {
			return adresse;
		}
		/**
		 * @param idNounou the idNounou to set
		 */
		public void setIdNounou(Integer idNounou) {
			this.idNounou = idNounou;
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
		 * @param adresse the adresse to set
		 */
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(idNounou);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Nounou) obj;
		return Objects.equals(idNounou, other.idNounou);
	}
	
}
