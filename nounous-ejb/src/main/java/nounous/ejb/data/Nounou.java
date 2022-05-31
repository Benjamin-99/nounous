package nounous.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int			idCompte;
    
	@Column( name = "nom" )
	private String			nom;

	@Column( name = "prenom" )
	private String			prenom;
	
	@Column( name = "telephone")
	private String 			telephone;

	@Column( name = "adresse" )
	private String  		adresse;

	
	// Constructeurs

	public Nounou() {
		super();
	}
    
    public Nounou(Integer id, Integer idCompte, String nom, String prenom, String telephone, String adresse) {
		super();
		this.idNounou = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
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

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
