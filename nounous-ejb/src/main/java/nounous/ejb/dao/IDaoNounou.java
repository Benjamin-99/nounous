package nounous.ejb.dao;

import java.util.List;

import nounous.ejb.data.Nounou;


public interface IDaoNounou {

	int			inserer( Nounou nounou );

	void 		modifier( Nounou nounou );

	void 		supprimer( int idNounou );

	Nounou 		retrouver( int idNounou );

	List<Nounou> listerTout();
    

}
