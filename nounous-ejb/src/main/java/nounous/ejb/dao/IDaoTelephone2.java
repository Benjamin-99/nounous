package nounous.ejb.dao;

import java.util.List;

import nounous.ejb.data.Nounou;
import nounous.ejb.data.Telephone;


public interface IDaoTelephone2 {

	void insererPourPersonne(Nounou nounou);

	void modifierPourPersonne(Nounou nounou);

	void supprimerPourPersonne(int idnounou);

	List<Telephone> listerPourPersonne( Nounou nounou);

}
