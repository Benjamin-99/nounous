package nounous.ejb.dao;

import java.util.List;

import nounous.ejb.data.Parent;
import nounous.ejb.data.Telephone;


public interface IDaoEnfant {

	void insererPourParent(Parent parent);

	void modifierPourPersonne(Parent parent);

	void supprimerPourPersonne(int idParent);

	List<Telephone> listerPourParent( Parent parent );

}
