package nounous.ejb.dao;

import java.util.List;

import nounous.ejb.data.Contrat;


public interface IDaoContrat {

	int				inserer(Contrat parent );

	void 			modifier(Contrat parent );

	void 			supprimer( int idContrat );
	
	Contrat 		retrouver( int idContrat );

	List<Contrat> 	listerTout(int idNounou);

	List<Contrat> listerToutParent(int idParent);
    
}
