package nounous.ejb.data.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import nounous.commun.dto.DtoCategorie;
import nounous.commun.dto.DtoCompte;
import nounous.commun.dto.DtoContrat;
import nounous.commun.dto.DtoEnfant;
import nounous.commun.dto.DtoNounou;
import nounous.commun.dto.DtoParent;
import nounous.commun.dto.DtoPersonne;
import nounous.commun.dto.DtoTelephone;
import nounous.ejb.data.Categorie;
import nounous.ejb.data.Compte;
import nounous.ejb.data.Contrat;
import nounous.ejb.data.Enfant;
import nounous.ejb.data.Nounou;
import nounous.ejb.data.Parent;
import nounous.ejb.data.Personne;
import nounous.ejb.data.Telephone;

@Mapper(componentModel = "cdi")
public interface IMapperEjb {

	static final IMapperEjb INSTANCE = Mappers.getMapper(IMapperEjb.class);

	// Compte

	Compte map(DtoCompte source);

	DtoCompte map(Compte source);

	// Categorie

	Categorie map(DtoCategorie source);

	DtoCategorie map(Categorie source);

	// Personne

	Personne map(DtoPersonne source);

	DtoPersonne map(Personne source);

	@Mapping(target = "categorie", ignore = true)
	@Mapping(target = "telephones", ignore = true)
	DtoPersonne mapMinimal(Personne source);

	
	// Enfant
	@Mapping(target = "parent", ignore = true)
		Enfant map(DtoEnfant source);

		DtoEnfant map(Enfant source);
		
		@Mapping(target = "idEnfant", ignore = true)

		DtoEnfant mapMinimal(Enfant source);
	
	// Parent
	@Mapping(target = "idParent", ignore = true)
	@Mapping(target = "contrat", ignore = true)
	@Mapping(target = "enfants", ignore = true)
	@Mapping(target = "contrats", ignore = true)
	@Mapping(target = "compte", ignore = true)
	Parent map(DtoParent source);
	
	@Mapping(target = "telephones", ignore = true)
	DtoParent map(Parent source);
	

 
	@Mapping(target = "telephones", ignore = true)
	@Mapping(target = "idParent", ignore = true)

	DtoParent mapMinimal(Parent source);

	// Nounou
	@Mapping(target = "contrats", ignore = true)
	@Mapping(target = "id", ignore = true)
	Nounou map(DtoNounou source);
 
	@Mapping(target = "idNounou", ignore = true)
	DtoNounou map(Nounou source);
	
	@Mapping(target = "compte", ignore = true)
	@Mapping(target = "telephones", ignore = true)
	@Mapping(target = "idNounou", ignore = true)

	DtoNounou mapMinimal(Nounou source);
	
		// Contrat
		@Mapping(target = "nounou", ignore = true)
		@Mapping(target = "parent", ignore = true)
		Contrat map(DtoContrat source);
		
		@Mapping(target = "prenomEnfant", ignore = true)
		@Mapping(target = "nomEnfant", ignore = true)
		@Mapping(target = "datedbcontrat", ignore = true)
		@Mapping(target = "dateNaissance", ignore = true)
			DtoContrat map(Contrat source);
			
			@Mapping(target = "prenomEnfant", ignore = true)
			@Mapping(target = "nomEnfant", ignore = true)
			@Mapping(target = "datedbcontrat", ignore = true)
			@Mapping(target = "dateNaissance", ignore = true)
			DtoContrat mapMinimal(Contrat source);
		
			// Telephone
		
	// @Mapping( target="personne", ignore=true )
	@Mapping(target = "personne", ignore = true)
	@Mapping(target = "parent", ignore = true)
	@Mapping(target = "nounou", ignore = true)
	Telephone map(DtoTelephone source);

	DtoTelephone map(Telephone source);

	// Méthodes auxiliaires

	@AfterMapping
	public default void addBackReference(@MappingTarget Personne target) {
		for (Telephone telephone : target.getTelephones()) {
			// telephone.setPersonne( target );
			telephone.setPersonne(target);
		}
	}


}
