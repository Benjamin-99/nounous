package nounous.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounous.commun.dto.DtoNounou;
import nounous.commun.exception.ExceptionValidation;
import nounous.commun.service.IServiceNounou;
import nounous.jsf.data.Nounou;
import nounous.jsf.data.Telephone;
import nounous.jsf.data.mapper.IMapper;
import nounous.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelNounou implements Serializable {

	
	// Champs
	
	private List<Nounou>		liste;
	
	private Nounou			courant;
	
	@EJB
	private IServiceNounou 	serviceNounou ;

	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Nounou> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoNounou dto : serviceNounou .listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Nounou  getCourant() {
		if ( courant == null ) {
			courant = new Nounou ();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoNounou  dto = serviceNounou .retrouver( courant.getIdNounou() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "La personne demandée n'existe pas" );
				return "liste";
			} else {
				courant = mapper.map( dto );
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		try {
			if ( courant.getIdNounou() != null) {
				serviceNounou .inserer( mapper.map(courant) );
			} else {
				serviceNounou .modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Nounou  parent ) {
		try {
			serviceNounou .supprimer( parent.getIdNounou() );
			liste.remove(parent);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
	
	public String ajouterTelephone() {
		courant.getTelephones().add( new Telephone() );
		return null;
	}
	
	
	public String supprimerTelephone( Telephone telephone ) {
		for ( int i=0; i < courant.getTelephones().size(); ++i ) {
			if ( courant.getTelephones().get(i) == telephone ) {
				courant.getTelephones().remove( i );
				break;
			}
		}
		return null;
	}
	
}
