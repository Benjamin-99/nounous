package nounous.jsf.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Parent implements Serializable  {

	
	// Champs
	
	Integer		idParent;
	
	@NotBlank( message = "Le pseudo doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le pseuo : 25 car. maxi" )
	private String		nom;

	@NotBlank( message = "Le pseudo doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le pseuo : 25 car. maxi" )
	private String		prenom;

	
	private String		adresse;
	

	private List<Telephone>	telephones = new ArrayList<>();
	
	
	// Constructeurs
	
	public Parent() {
	}
		public Parent(Integer idParent,
			@NotBlank(message = "Le pseudo doit être renseigné") @Size(max = 25, message = "Valeur trop longue pour le pseuo : 25 car. maxi") String nom,
			@NotBlank(message = "Le pseudo doit être renseigné") @Size(max = 25, message = "Valeur trop longue pour le pseuo : 25 car. maxi") String prenom,
			String adresse) {
		super();
		this.idParent = idParent;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	
	// Getters & setters





	/**
		 * @return the idParent
		 */
		public Integer getidParent() {
			return idParent;
		}
		public Integer getIdParent() {
		return idParent;
	}
	public List<Telephone> getTelephones() {
		return telephones;
	}
	public void setIdParent(Integer idParent) {
		this.idParent = idParent;
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
		 * @param idParent the idParent to set
		 */
		public void setidParent(Integer idParent) {
			this.idParent = idParent;
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
		return Objects.hash(idParent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Parent) obj;
		return Objects.equals(idParent, other.idParent);
	}
	
}
