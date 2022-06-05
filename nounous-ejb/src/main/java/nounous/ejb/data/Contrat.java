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
@Table( name = "contrat" )
public class Contrat {
    
	
    // Champs
    
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idcontrat" )
	private Integer			idContrat;
	
	@ManyToOne
	@JoinColumn(name="idnounou")
	private Nounou		nounou;
    
	@ManyToOne
	@JoinColumn( name = "idparent" )
	private 	Parent		parent;

	@Column( name = "nbreheuresentretien" )
	private Timer			nbreHeuresEntretien;

	@Column( name = "dateDeGarde" )
	private Date  			dateDeGarde;
	
	@Column( name = "tarifHoraire" )
	private double			tarifHoraire;
	
	@Column( name = "heureArrivee" )
	private Timer			heureArrivee;
	
	@Column( name = "heureDepart" )
	private Timer			heureDepart;
	
	@Column( name = "repas" )
	private boolean			repas;

	@Column( name = "tarifrepas" )
	private double			tarifRepas;
	
	
	// Constructeurs

	public Contrat() {
		super();
	}	
	
	
	public Contrat(Integer idContrat, Nounou nounou, Parent parent, Timer nbreHeuresEntretien, Date dateDeGarde,
			double tarifHoraire, Timer heureArrivee, Timer heureDepart, boolean repas, double tarifRepas) {
		super();
		this.idContrat = idContrat;
		this.nounou = nounou;
		this.parent = parent;
		this.nbreHeuresEntretien = nbreHeuresEntretien;
		this.dateDeGarde = dateDeGarde;
		this.tarifHoraire = tarifHoraire;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.repas = repas;
		this.tarifRepas = tarifRepas;
	}

    
    
    
    
    // Getters & setters





	public Integer getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}

	public Timer getNbreHeuresEntretien() {
		return nbreHeuresEntretien;
	}

	public Nounou getNounou() {
		return nounou;
	}


	public Parent getParent() {
		return parent;
	}


	public void setNounou(Nounou nounou) {
		this.nounou = nounou;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public void setNbreHeuresEntretien(Timer nbreHeuresEntretien) {
		this.nbreHeuresEntretien = nbreHeuresEntretien;
	}

	public Date getDateDeGarde() {
		return dateDeGarde;
	}

	public void setDateDeGarde(Date dateDeGarde) {
		this.dateDeGarde = dateDeGarde;
	}

	public double getTarifHoraire() {
		return tarifHoraire;
	}

	public void setTarifHoraire(double tarifHoraire) {
		this.tarifHoraire = tarifHoraire;
	}

	public Timer getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Timer heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public Timer getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Timer heureDepart) {
		this.heureDepart = heureDepart;
	}

	public boolean isRepas() {
		return repas;
	}

	public void setRepas(boolean repas) {
		this.repas = repas;
	}

	public double getTarifRepas() {
		return tarifRepas;
	}

	public void setTarifRepas(double tarifRepas) {
		this.tarifRepas = tarifRepas;
	}


	// soString()


	

    
}
