package nounous.jsf.model.mock;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounous.jsf.data.Parent;
import nounous.jsf.data.Telephone;
import nounous.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelParent implements Serializable {

	
	// Champs
	
	private List<Parent>		liste;
	
	private Parent			courant;
	
	@Inject
	private Donnees				données;

	
	// Getters
	
	public List<Parent> getListe() {
		if ( liste == null ) {
			liste = données.getParents();
		}
		return liste;
	}

	public Parent getCourant() {
		if ( courant == null ) {
			courant = new Parent();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			courant = données.parentRetrouver( courant.getIdParent() );
			if ( courant == null ) {
				UtilJsf.messageError( "La catégorie demandée n'existe pas" );
				return "liste";
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		if ( courant.getIdParent() == null) {
			données.parentAjouter(courant);
		} else {
			données.parentModifier(courant);
		}
		UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
		return "liste";
	}
	
	public String supprimer( Parent item ) {
		données.parentSupprimer( item.getIdParent() );
		liste.remove(item);
		UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		return null;
	}
	
	
	public String ajouterTelephone() {
		courant.getTelephones().add( new Telephone() );
		return null;
	}
	
	
	public String supprimerTelephone( Telephone item ) {
		for ( int i=0; i < courant.getTelephones().size(); ++i ) {
			if ( courant.getTelephones().get(i) == item ) {
				courant.getTelephones().remove( i );
				break;
			}
		}
		return null;
	}
	
}
