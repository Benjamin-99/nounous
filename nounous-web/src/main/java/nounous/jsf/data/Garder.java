package nounous.jsf.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@SuppressWarnings("serial")
public class Garder implements Serializable {


	// Champs
	
	private Enfant		enfant;
	
	private Nounou			nounou; 

	@NotNull( message = "La date est obligatoire")
	private Date		DateDeGarde;
     
	@NotBlank( message = "Le prix doit être reneigné")
    @Min(value=0, message="Le prix ne peut pas être inférieur à 0")
	private double tarifHoraire;
	
	private Timer heureArrivee;
	
	private Timer heureDepart;
	
	private boolean repas;
	
	
	// Constructeurs
	
	public Garder() {
	}

	public Garder(Enfant enfant, Nounou nounou, @NotNull(message = "La date est obligatoire") Date dateDeGarde,
			@NotBlank(message = "Le prix doit être reneigné") @Min(value = 0, message = "Le prix ne peut pas être inférieur à 0") double tarifHoraire,
			Timer heureArrivee, Timer heureDepart, boolean repas) {
		super();
		this.enfant = enfant;
		this.nounou = nounou;
		DateDeGarde = dateDeGarde;
		this.tarifHoraire = tarifHoraire;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.repas = repas;
	}




	// Getters & setters
/**
	 * @return the enfant
	 */
	public Enfant getEnfant() {
		return enfant;
	}




	/**
	 * @return the nounou
	 */
	public Nounou getNounou() {
		return nounou;
	}




	/**
	 * @return the dateDeGarde
	 */
	public Date getDateDeGarde() {
		return DateDeGarde;
	}




	/**
	 * @return the tarifHoraire
	 */
	public double getTarifHoraire() {
		return tarifHoraire;
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
	 * @param enfant the enfant to set
	 */
	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}




	/**
	 * @param nounou the nounou to set
	 */
	public void setNounou(Nounou nounou) {
		this.nounou = nounou;
	}




	/**
	 * @param dateDeGarde the dateDeGarde to set
	 */
	public void setDateDeGarde(Date dateDeGarde) {
		DateDeGarde = dateDeGarde;
	}




	/**
	 * @param tarifHoraire the tarifHoraire to set
	 */
	public void setTarifHoraire(double tarifHoraire) {
		this.tarifHoraire = tarifHoraire;
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




	// hashCode() & equals()

	

	@Override
	public int hashCode() {
		return Objects.hash(enfant.getIdEnfant(),nounou.getIdNounou());
	}

	






}
