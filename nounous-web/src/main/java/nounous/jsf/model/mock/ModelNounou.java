package nounous.jsf.model.mock;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounous.jsf.data.Nounou;
import nounous.jsf.data.Telephone;
import nounous.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelNounou implements Serializable {

	
	// Champs
	
	private List<Nounou>		liste;
	
	private Nounou			courant;
	
	@Inject
	private Donnees				données;

	
	// Getters
	
	public List<Nounou> getListe() {
		if ( liste == null ) {
			liste = données.getNounous();
		}
		return liste;
	}

	public Nounou getCourant() {
		if ( courant == null ) {
			courant = new Nounou();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			courant = données.nounouRetrouver( courant.getIdNounou() );
			if ( courant == null ) {
				UtilJsf.messageError( "La catégorie demandée n'existe pas" );
				return "liste";
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		if ( courant.getIdNounou() == null) {
			données.nounouAjouter(courant);
		} else {
			données.nounouModifier(courant);
		}
		UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
		return "liste";
	}
	
	public String supprimer( Nounou item ) {
		données.nounouSupprimer( item.getIdNounou() );
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
