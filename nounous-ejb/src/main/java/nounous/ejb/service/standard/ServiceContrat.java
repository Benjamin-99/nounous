package nounous.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import nounous.commun.dto.DtoContrat;
import nounous.commun.exception.ExceptionValidation;
import nounous.commun.service.IServiceContrat;
import nounous.ejb.dao.IDaoContrat;
import nounous.ejb.data.Contrat;
import nounous.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceContrat implements IServiceContrat {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoContrat daoContrat;

	// Actions

	@Override
	public int inserer(DtoContrat dtoContrat) throws ExceptionValidation {
		verifierValiditeDonnees(dtoContrat);
		int id = daoContrat.inserer(mapper.map(dtoContrat));
		return id;
	}

	@Override
	public void modifier(DtoContrat dtoContrat) throws ExceptionValidation {
		verifierValiditeDonnees(dtoContrat);
		daoContrat.modifier(mapper.map(dtoContrat));
	}

	@Override
	public void supprimer(int idContrat) throws ExceptionValidation {
		daoContrat.supprimer(idContrat);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoContrat retrouver(int idContrat) {
		Contrat contrat = daoContrat.retrouver(idContrat);
		return mapper.map(contrat);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoContrat> listerTout(int idContrat) {
		List<DtoContrat> liste = new ArrayList<>();
		for (Contrat contrat : daoContrat.listerTout(idContrat)) {
			liste.add( mapper.mapMinimal(contrat) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoContrat dtoContrat) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoContrat.getNomEnfant() == null || dtoContrat.getNomEnfant().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoContrat.getNomEnfant().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (dtoContrat.getPrenomEnfant() == null || dtoContrat.getPrenomEnfant().isEmpty()) {
			message.append("\nLe prénom est absent.");
		} else if (dtoContrat.getPrenomEnfant().length() > 25) {
			message.append("\nLe prénom est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
