package nounous.jsf.data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Contrat implements Serializable {


	// Champs
	
	private Integer			idContrat;
	
     
	@NotBlank( message = "Le prix doit être reneigné")
    @Min(value=0, message="Le prix ne peut pas être inférieur à 0")
	private double tarifHoraire;
		
	private Time nbreHeuresEntretien;
	
	private double tarifRepas;
	
	@NotNull( message = "La date est obligatoire")
	private Date		DateDeGarde;
	
    private Time heureArrivee;
	
	private Time heureDepart;
	
	private boolean repas;
	@NotNull( message = "La date est obligatoire")

	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String			nomEnfant;

	@NotBlank( message = "Le prénom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le prénom : 25 car. maxi" )
	private String			prenomEnfant;

	@NotNull( message = "La date de naissance est obligatoire")
	private Date  dateNaissance		;
	
	private Parent parent;
	
	private Nounou nounou;
	
	// Constructeurs
	
	


	public Contrat() {
	}
	
	public Contrat(Integer idContrat,
			@NotBlank(message = "Le prix doit être reneigné") @Min(value = 0, message = "Le prix ne peut pas être inférieur à 0") double tarifHoraire,
			Time nbreHeuresEntretien, double tarifRepas, @NotNull(message = "La date est obligatoire") Date dateDeGarde,
			Time heureArrivee, Time heureDepart, boolean repas,
			@NotNull(message = "La date est obligatoire") @NotBlank(message = "Le nom doit être renseigné") @Size(max = 25, message = "Valeur trop longue pour le nom : 25 car. maxi") String nomEnfant,
			@NotBlank(message = "Le prénom doit être renseigné") @Size(max = 25, message = "Valeur trop longue pour le prénom : 25 car. maxi") String prenomEnfant,
			@NotNull(message = "La date de naissance est obligatoire") Date dateNaissance) {
		super();
		this.idContrat = idContrat;
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
	 * @return the dateDeGarde
	 */
	public Date getDateDeGarde() {
		return DateDeGarde;
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
	
	





	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(idContrat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Contrat) obj;
		return Objects.equals(idContrat, other.idContrat);
	}





}
