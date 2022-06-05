package nounous.ejb.data;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table( name = "parent"  )
public class Parent {
	
	
	// Champs
	
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idparent" )
	private int				idParent;
	
	@Column( name = "nom" )
	private String			nom;
	
	@Column( name = "prenom" )
	private String			prenom;
	
	
	
	 @OneToMany( mappedBy="parent", cascade=CascadeType.ALL )
	 private List<Contrat> contrat;

	
	@Column( name = "adresse" )
	private String			adresse;

	@OneToMany( mappedBy = "parent", cascade = ALL, orphanRemoval = true  )
	@OrderBy( "libelle" )
	private List<Telephone>	telephones = new ArrayList<>();
	
	@OneToMany( mappedBy = "parent", cascade = ALL, orphanRemoval = true  )
	@OrderBy( "prenom" )
	private List<Enfant>	enfants = new ArrayList<>();
	
	
	// Constructeurs
	
	public Parent() {
	}


	public Parent(int idParent, String nom, String prenom, String adresse, List<Enfant> enfants) {
		super();
		this.idParent = idParent;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.enfants = enfants;
	}

	
	
	// Getters & setters





	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idparent) {
		this.idParent = idparent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public List<Contrat> getContrat() {
		return contrat;
	}




	public void setContrat(List<Contrat> contrat) {
		this.contrat = contrat;
	}




	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

/*	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}*/

	public List<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}
	
	// Actions

	/*public void ajouterTelephone( Telephone telephone ) {
		telephones.add( telephone );
	}
	

	public void retirerTelephone( Telephone telephone ) {
		telephones.remove(telephone);
	}*/
	
	public void ajouterEnfant( Enfant enfant ) {
		enfants.add( enfant );
	}
	

	public void retirerEnfant( Enfant enfant ) {
		enfants.remove(enfant);
	}
	
	
	// hashcode() + equals()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idParent;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		if (idParent != other.idParent)
			return false;
		return true;
	}
	

}
