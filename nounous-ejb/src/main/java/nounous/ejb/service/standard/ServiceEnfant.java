package nounous.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import nounous.commun.dto.DtoEnfant;
import nounous.commun.exception.ExceptionValidation;
import nounous.commun.service.IServiceEnfant;
import nounous.ejb.dao.IDaoEnfant;
import nounous.ejb.data.Enfant;
import nounous.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceEnfant implements IServiceEnfant {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoEnfant daoEnfant;

	// Actions

	@Override
	public int inserer(DtoEnfant dtoEnfant) throws ExceptionValidation {
		verifierValiditeDonnees(dtoEnfant);
		int id = daoEnfant.inserer(mapper.map(dtoEnfant));
		return id;
	}

	@Override
	public void modifier(DtoEnfant dtoEnfant) throws ExceptionValidation {
		verifierValiditeDonnees(dtoEnfant);
		daoEnfant.modifier(mapper.map(dtoEnfant));
	}

	@Override
	public void supprimer(int idEnfant) throws ExceptionValidation {
		daoEnfant.supprimer(idEnfant);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoEnfant retrouver(int idEnfant) {
		Enfant enfant = daoEnfant.retrouver(idEnfant);
		return mapper.map(enfant);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoEnfant> listerTout() {
		List<DtoEnfant> liste = new ArrayList<>();
		for (Enfant enfant : daoEnfant.listerTout()) {
			liste.add( mapper.mapMinimal(enfant) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoEnfant dtoEnfant) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoEnfant.getNom() == null || dtoEnfant.getNom().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoEnfant.getNom().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (dtoEnfant.getPrenom() == null || dtoEnfant.getPrenom().isEmpty()) {
			message.append("\nLe prénom est absent.");
		} else if (dtoEnfant.getPrenom().length() > 25) {
			message.append("\nLe prénom est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
