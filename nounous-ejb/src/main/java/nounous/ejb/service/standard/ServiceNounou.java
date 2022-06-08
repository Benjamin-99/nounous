package nounous.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import nounous.commun.dto.DtoNounou;
import nounous.commun.dto.DtoTelephone;
import nounous.commun.exception.ExceptionValidation;
import nounous.commun.service.IServiceNounou;
import nounous.ejb.dao.IDaoNounou;
import nounous.ejb.data.Nounou;
import nounous.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceNounou implements IServiceNounou {

	// Champs
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoNounou daoNounou;

	// Actions

	@Override
	public int inserer(DtoNounou dtoNounou) throws ExceptionValidation {
		verifierValiditeDonnees(dtoNounou);
		int id = daoNounou.inserer(mapper.map(dtoNounou));
		return id;
	}

	@Override
	public void modifier(DtoNounou dtoNounou) throws ExceptionValidation {
		verifierValiditeDonnees(dtoNounou);
		daoNounou.modifier(mapper.map(dtoNounou));
	}

	@Override
	public void supprimer(int idNounou) throws ExceptionValidation {
		daoNounou.supprimer(idNounou);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoNounou retrouver(int idNounou) {
		Nounou nounou = daoNounou.retrouver(idNounou);
		return mapper.map(nounou);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoNounou> listerTout() {
		List<DtoNounou> liste = new ArrayList<>();
		for (Nounou nounou : daoNounou.listerTout()) {
			liste.add( mapper.mapMinimal(nounou) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoNounou dtoNounou) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoNounou.getNom() == null || dtoNounou.getNom().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoNounou.getNom().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (dtoNounou.getPrenom() == null || dtoNounou.getPrenom().isEmpty()) {
			message.append("\nLe prénom est absent.");
		} else if (dtoNounou.getPrenom().length() > 25) {
			message.append("\nLe prénom est trop long.");
		}

		for (DtoTelephone telephoe : dtoNounou.getTelephones()) {
			if (telephoe.getLibelle() == null || telephoe.getLibelle().isEmpty()) {
				message.append("\nLlibellé absent pour le téléphone : " + telephoe.getNumero());
			} else if (telephoe.getLibelle().length() > 25) {
				message.append("\nLe libellé du téléphone est trop long : " + telephoe.getLibelle());
			}

			if (telephoe.getNumero() == null || telephoe.getNumero().isEmpty()) {
				message.append("\nNuméro absent pour le téléphone : " + telephoe.getLibelle());
			} else if (telephoe.getNumero().length() > 25) {
				message.append("\nLe numéro du téléphone est trop long : " + telephoe.getNumero());
			}
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
