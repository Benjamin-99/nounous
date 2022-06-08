package nounous.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "telephone" )
public class Telephone {

	
	// Champs

	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idtelephone" )
	private int				id;
	
	@ManyToOne
	@JoinColumn( name = "idparent" )
	private Parent		parent;
	
	@ManyToOne
	@JoinColumn( name = "idnounou" )
	private Nounou		nounou;
	
	


	@ManyToOne
	@JoinColumn( name = "idpersonne" )
	private Personne		personne;

	@Column( name = "libelle" )
	private String			libelle;

	@Column( name = "numero" )
	private String			numero;
	
	
	// Constructeurs
	
	public Telephone() {
	}
	
	public Telephone(int id, Personne personne, String libelle, String numero) {
		this.id = id;
		this.personne = personne;
		this.libelle = libelle;
		this.numero = numero;
	}


	// Getters & setters
	public Parent getParent() {
		return parent;
	}

	public Nounou getNounou() {
		return nounou;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public void setNounou(Nounou nounou) {
		this.nounou = nounou;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	// hashcode() et equals()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Telephone other = (Telephone) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
