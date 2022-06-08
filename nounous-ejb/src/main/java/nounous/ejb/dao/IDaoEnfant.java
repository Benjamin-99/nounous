package nounous.ejb.dao;

import java.util.List;

import nounous.ejb.data.Enfant;


public interface IDaoEnfant {

	int inserer(Enfant parent);

	void modifier(Enfant parent);

	void supprimer(int idEnfant);

	List<Enfant> listerTout();

	Enfant retrouver(int idEnfant);

	
}
