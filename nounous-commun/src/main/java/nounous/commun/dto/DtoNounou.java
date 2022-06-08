package nounous.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





@SuppressWarnings("serial")
public class DtoNounou implements Serializable {
	
	
	// Champs
	
	private Integer			idNounou;
	
	private String			nom;
	
	private String			prenom;
	
	private String          adresse;
	
	private DtoCompte compte;
	
	private List<DtoTelephone>	telephones = new ArrayList<>();	
	
	
	
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

	

	public DtoCompte getCompte() {
		return compte;
	}

	public void setIdNounou(Integer idNounou) {
		this.idNounou = idNounou;
	}

	public void setCompte(DtoCompte compte) {
		this.compte = compte;
	}


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


	public List<DtoTelephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<DtoTelephone> telephones) {
		this.telephones = telephones;
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
