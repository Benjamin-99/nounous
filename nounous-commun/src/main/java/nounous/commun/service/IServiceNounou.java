package nounous.commun.service;

import java.util.List;

import nounous.commun.dto.DtoNounou;
import nounous.commun.exception.ExceptionValidation;


public interface IServiceNounou {
	
	int				inserer( DtoNounou dtoNounou ) throws ExceptionValidation;
	
	void			modifier( DtoNounou dtoNounou ) throws ExceptionValidation;
	
	void			supprimer( int idNounou ) throws ExceptionValidation;
	
	DtoNounou 	retrouver( int idNounou );
	
	List<DtoNounou> listerTout();
	

}
