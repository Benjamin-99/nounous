package nounous.ejb.dao;

import java.util.List;

import nounous.ejb.data.Parent;
import nounous.ejb.data.Telephone;


public interface IDaoTelephone1 {

	void insererPourPersonne(Parent parent);

	void modifierPourPersonne(Parent parent);

	void supprimerPourPersonne(int idParent);

	List<Telephone> listerPourPersonne( Parent parent);

}
