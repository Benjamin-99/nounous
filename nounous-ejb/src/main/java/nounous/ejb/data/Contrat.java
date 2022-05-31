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
	private int			idNounou;
    
	@ManyToOne
	@JoinColumn( name = "idparent" )
	private int			idParent;

	@Column( name = "nbreheuresentretien" )
	private Timer			nbreHeuresEntretien;

	@Column( name = "dateNaissance" )
	private Date  			dateNaissance;
	
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
    
	
	/*   , */
	public Contrat(Integer idContrat, int idNounou, int idParent, Date dateDeGarde, Timer heureArrivee, Timer heureDepart, boolean repas, Timer nbreHeuresEntretien, double tarifHoraire,  double tarifRepas) {
		super();
		this.idContrat = idContrat;
		this.idNounou = idNounou;
		this.idParent = idParent;
		this.nbreHeuresEntretien = nbreHeuresEntretien;
		this.dateDeGarde = dateDeGarde;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.repas = repas;
		this.tarifHoraire = tarifHoraire;
		this.tarifRepas = tarifRepas;
	}
    
    
    
    // Getters & setters

	public Integer getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}

	public int getIdNounou() {
		return idNounou;
	}

	public void setIdNounou(int idNounou) {
		this.idNounou = idNounou;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public Timer getNbreHeuresEntretien() {
		return nbreHeuresEntretien;
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
