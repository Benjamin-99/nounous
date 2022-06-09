package nounous.jsf.model.mock;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounous.jsf.data.Enfant;
import nounous.jsf.data.Telephone;
import nounous.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelEnfant implements Serializable {

	
	// Champs
	
	private List<Enfant>		liste;
	
	private Enfant			courant;
	
	@Inject
	private Donnees				données;

	
	// Getters
	
	public List<Enfant> getListe() {
		if ( liste == null ) {
			liste = données.getEnfants();
		}
		return liste;
	}

	public Enfant getCourant() {
		if ( courant == null ) {
			courant = new Enfant();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			courant = données.enfantRetrouver( courant.getIdEnfant() );
			if ( courant == null ) {
				UtilJsf.messageError( "La catégorie demandée n'existe pas" );
				return "liste";
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		if ( courant.getIdEnfant() == null) {
			données.enfantAjouter(courant);
		} else {
			données.enfantModifier(courant);
		}
		UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
		return "liste";
	}
	
	public String supprimer( Enfant item ) {
		données.enfantSupprimer( item.getIdEnfant() );
		liste.remove(item);
		UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		return null;
	}
	
	
	
}
