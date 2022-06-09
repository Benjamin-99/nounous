package nounous.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table( name = "nounou" )
public class Nounou {
    
	
    // Champs
    
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idnounou" )
	private Integer			idNounou;
	
	@ManyToOne
	@JoinColumn(name="idcompte")
	private Compte		compte;
    
	@Column( name = "nom" )
	private String			nom;

	@Column( name = "prenom" )
	private String			prenom;


	@Column( name = "adresse" )
	private String  		adresse;
	
	@OneToMany( mappedBy="nounou", cascade=CascadeType.ALL )
	 private List<Contrat> contrats;
	@OneToMany( mappedBy="nounou", cascade=CascadeType.ALL )
	private List<Telephone>	telephones = new ArrayList<>();


	
	// Constructeurs
	
	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	public Nounou() {
		super();
	}
    
    public Nounou(Integer idNounou, Integer idCompte, String nom, String prenom, String adresse) {
		super();
		this.idNounou = idNounou;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
    
    
    // Getters & setters

    public int getId() {
        return idNounou;
    }

    public void setId(int id) {
        this.idNounou = id;
    }
    
    public String getNom() {
		return nom;
	}
    

	public Compte getCompte() {
		return compte;
	}

	public List<Contrat> getContrats() {
		return contrats;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
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
	


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}


	// soString()
	@Override
	public String toString() {
		return "Enfant [nom=" + nom + ", prenom=" + prenom + "]";
	}

	// hashcode() & equals()
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
		Nounou other = (Nounou) obj;
		return Objects.equals(idNounou, other.idNounou);
	}


	

    
}
