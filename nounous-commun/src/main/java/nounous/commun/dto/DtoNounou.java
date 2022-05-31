package nounous.commun.dto;

import java.io.Serializable;



@SuppressWarnings("serial")
public class DtoNounou implements Serializable {
	
	
	// Champs
	
	private int				idNounou;
	
	private String			nom;
	
	private String			prenom;
	
	private String          adresse;
	
	private String	telephone ;
	
	
	// Constructeurs
	
	public DtoNounou() {
	}

	public DtoNounou(int idNounou, String nom, String prenom, String adresse ) {
		super();
		this.idNounou = idNounou;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	
	
	// Getters & setters

	

	public String getNom() {
		return nom;
	}

	/**
	 * @return the idNounou
	 */
	public int getIdNounou() {
		return idNounou;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param idNounou the idNounou to set
	 */
	public void setIdNounou(int idNounou) {
		this.idNounou = idNounou;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	
	

}
