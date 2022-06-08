package nounous.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@SuppressWarnings("serial")
public class DtoParent implements Serializable {
	
	
	// Champs
	
	private int				idParent;
	
	private String			nom;
	
	private String			prenom;
	
	private String          adresse;
	
	private List<DtoTelephone>	telephones = new ArrayList<>();
	
	

	
	// Constructeurs
	


	public DtoParent() {
	}

	public DtoParent(int idParent, String nom, String prenom, String adresse ) {
		super();
		this.idParent = idParent;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	
	
	// Getters & setters

	public int getIdParent() {
		return idParent;
	}
	public String getAdresse() {
		return adresse;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

	public String getNom() {
		return nom;
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

	
	public List<DtoTelephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<DtoTelephone> telephones) {
		this.telephones = telephones;
	}


}
