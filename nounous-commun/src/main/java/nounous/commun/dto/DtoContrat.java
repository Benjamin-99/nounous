package nounous.commun.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
@SuppressWarnings("serial")
public class DtoContrat implements Serializable {

	// Champs

	

	private int idContrat;

	private Date datedbcontrat;

	private double tarifHoraire;

	private Time nbreHeuresEntretien;

	private double tarifRepas;

	private Date DateDeGarde;
	
	private Time heureArrivee;

	private Time heureDepart;

	private boolean repas;

	private String nomEnfant;

	private String prenomEnfant;

	private Date dateNaissance;
	
	// Constructeurs
public DtoContrat(int idContrat, Date datedbcontrat, double tarifHoraire, Time nbreHeuresEntretien,
			double tarifRepas, Date dateDeGarde, Time heureArrivee, Time heureDepart, boolean repas, String nomEnfant,
			String prenomEnfant, Date dateNaissance) {
		super();
		this.idContrat = idContrat;
		this.datedbcontrat = datedbcontrat;
		this.tarifHoraire = tarifHoraire;
		this.nbreHeuresEntretien = nbreHeuresEntretien;
		this.tarifRepas = tarifRepas;
		DateDeGarde = dateDeGarde;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.repas = repas;
		this.nomEnfant = nomEnfant;
		this.prenomEnfant = prenomEnfant;
		this.dateNaissance = dateNaissance;
	}

	// Getters & setters
	/**
	 * @param idContrat the idContrat to set
	 */
	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}


	

	/**
	 * @return the dateDeGarde
	 */
	public Date getDateDeGarde() {
		return DateDeGarde;
	}


	/**
	 * @return the repas
	 */
	public boolean isRepas() {
		return repas;
	}

	/**
	 * @return the nomEnfant
	 */
	public String getNomEnfant() {
		return nomEnfant;
	}

	/**
	 * @return the prenomEnfant
	 */
	public String getPrenomEnfant() {
		return prenomEnfant;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateDeGarde the dateDeGarde to set
	 */
	public void setDateDeGarde(Date dateDeGarde) {
		DateDeGarde = dateDeGarde;
	}


	/**
	 * @param repas the repas to set
	 */
	public void setRepas(boolean repas) {
		this.repas = repas;
	}

	/**
	 * @param nomEnfant the nomEnfant to set
	 */
	public void setNomEnfant(String nomEnfant) {
		this.nomEnfant = nomEnfant;
	}

	/**
	 * @param prenomEnfant the prenomEnfant to set
	 */
	public void setPrenomEnfant(String prenomEnfant) {
		this.prenomEnfant = prenomEnfant;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the idContrat
	 */
	public Integer getIdContrat() {
		return idContrat;
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

	/**
	 * @return the datedbcontrat
	 */
	public Date getDatedbcontrat() {
		return datedbcontrat;
	}

	/**
	 * @return the tarifHoraire
	 */
	public double getTarifHoraire() {
		return tarifHoraire;
	}

	/**
	 * @return the tarifRepas
	 */
	public double getTarifRepas() {
		return tarifRepas;
	}

	/**
	 * @param idContrat the idContrat to set
	 */
	public void setIdContrat(Integer idContrat) {
		this.idContrat = idContrat;
	}

	/**
	 * @param datedbcontrat the datedbcontrat to set
	 */
	public void setDatedbcontrat(Date datedbcontrat) {
		this.datedbcontrat = datedbcontrat;
	}

	/**
	 * @param tarifHoraire the tarifHoraire to set
	 */
	public void setTarifHoraire(double tarifHoraire) {
		this.tarifHoraire = tarifHoraire;
	}


	/**
	 * @param tarifRepas the tarifRepas to set
	 */
	public void setTarifRepas(double tarifRepas) {
		this.tarifRepas = tarifRepas;
	}

}
