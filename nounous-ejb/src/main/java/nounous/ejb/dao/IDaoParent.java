package nounous.ejb.dao;

import java.util.List;

import nounous.ejb.data.Contrat;
import nounous.ejb.data.Enfant;


public interface IDaoParent {

	int				inserer( Enfant enfant );

	void 			modifier( Enfant enfant );

	void 			supprimer( int idEnfant );
	
	Enfant			retrouverEnfant(int idEnfant);
	
	Contrat 		retrouver( int idEnfant );

	List<Enfant> 	listerTout(int id);
    
}
