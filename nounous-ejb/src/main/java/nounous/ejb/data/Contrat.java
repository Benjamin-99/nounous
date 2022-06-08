package nounous.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Time;
import java.util.Date;
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
	private Time			nbreHeuresEntretien;

	@Column( name = "dateDeGarde" )
	private Date  			dateDeGarde;
	
	@Column( name = "tarifHoraire" )
	private double			tarifHoraire;
	
	@Column( name = "heureArrivee" )
	private Time			heureArrivee;
	
	@Column( name = "heureDepart" )
	private Time			heureDepart;
	
	@Column( name = "repas" )
	private boolean			repas;

	@Column( name = "tarifrepas" )
	private double			tarifRepas;
	
	
	// Constructeurs

	public Contrat() {
		super();
	}	
	
	


    
    
    public Contrat(Integer idContrat,Time nbreHeuresEntretien, Date dateDeGarde,
			double tarifHoraire, Time heureArrivee, Time heureDepart, boolean repas, double tarifRepas) {
		super();
		this.idContrat = idContrat;
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

	

	public Time getNbreHeuresEntretien() {
		return nbreHeuresEntretien;
	}






	public Time getHeureArrivee() {
		return heureArrivee;
	}






	public Time getHeureDepart() {
		return heureDepart;
	}






	public void setNbreHeuresEntretien(Time nbreHeuresEntretien) {
		this.nbreHeuresEntretien = nbreHeuresEntretien;
	}






	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}






	public void setHeureDepart(Time heureDepart) {
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


	// toString()


	

    
}
