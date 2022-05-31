package nounous.commun.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;

@SuppressWarnings("serial")
public class DtoContrat implements Serializable {

	// Champs

	private int idContrat;

	private Date datedbcontrat;

	private double tarifHoraire;

	private Timer nbreHeuresEntretien;

	private double tarifRepas;

	private Date DateDeGarde;

	private DtoParent parent;

	private Timer heureArrivee;

	private Timer heureDepart;

	private boolean repas;

	private String nomEnfant;

	private String prenomEnfant;

	private Date dateNaissance;
	// Constructeurs

	public DtoContrat(int idContrat, Date datedbcontrat, double tarifHoraire, Timer nbreHeuresEntretien,
			double tarifRepas, Date dateDeGarde, Timer heureArrivee, Timer heureDepart, boolean repas, String nomEnfant,
			String prenomEnfant, Date dateNaissance, DtoParent parent) {
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
		this.parent = parent;
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
	 * @return the heureArrivee
	 */
	public Timer getHeureArrivee() {
		return heureArrivee;
	}

	/**
	 * @return the heureDepart
	 */
	public Timer getHeureDepart() {
		return heureDepart;
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
	 * @param heureArrivee the heureArrivee to set
	 */
	public void setHeureArrivee(Timer heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	/**
	 * @param heureDepart the heureDepart to set
	 */
	public void setHeureDepart(Timer heureDepart) {
		this.heureDepart = heureDepart;
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
	 * @return the nbreHeuresEntretien
	 */
	public Timer getNbreHeuresEntretien() {
		return nbreHeuresEntretien;
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
	 * @param nbreHeuresEntretien the nbreHeuresEntretien to set
	 */
	public void setNbreHeuresEntretien(Timer nbreHeuresEntretien) {
		this.nbreHeuresEntretien = nbreHeuresEntretien;
	}

	/**
	 * @param tarifRepas the tarifRepas to set
	 */
	public void setTarifRepas(double tarifRepas) {
		this.tarifRepas = tarifRepas;
	}

}
