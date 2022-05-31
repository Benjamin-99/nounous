package nounous.ejb.dao;

import java.util.List;

import nounous.ejb.data.Enfant;
import nounous.ejb.data.Parent;


public interface IDaoNounou {

	int			inserer( Parent parent );

	void 		modifier( Parent parent );

	void 		supprimer( int idParent );

	Parent 		retrouver( int idParent );

	List<Enfant> listerTout();
    
    //int 		compterPourCategorie( int idCategorie );

}
