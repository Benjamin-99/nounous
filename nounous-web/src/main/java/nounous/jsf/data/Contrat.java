package nounous.jsf.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@SuppressWarnings("serial")
public class Contrat implements Serializable {


	// Champs
	
	private Integer			idContrat;
	

	@NotNull( message = "La date est obligatoire")
	private Date		datedbcontrat;
     
	@NotBlank( message = "Le prix doit être reneigné")
    @Min(value=0, message="Le prix ne peut pas être inférieur à 0")
	private double tarifHoraire;
	
	private Timer nbreHeuresEntretien;
	
	private double tarifRepas;
	
	private Parent parent;
	
	private Garder garder;
	// Constructeurs
	
	


	public Contrat() {
	}

	
	
	
	// Getters & setters

/**
	 * @return the parent
	 */
	public Parent getParent() {
		return parent;
	}




	/**
	 * @return the garder
	 */
	public Garder getGarder() {
		return garder;
	}




	/**
	 * @param parent the parent to set
	 */
	public void setParent(Parent parent) {
		this.parent = parent;
	}




	/**
	 * @param garder the garder to set
	 */
	public void setGarder(Garder garder) {
		this.garder = garder;
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
