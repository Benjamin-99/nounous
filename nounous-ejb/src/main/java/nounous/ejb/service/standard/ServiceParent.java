package nounous.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import nounous.commun.dto.DtoParent;
import nounous.commun.dto.DtoTelephone;
import nounous.commun.exception.ExceptionValidation;
import nounous.commun.service.IServiceParent;
import nounous.ejb.dao.IDaoParent;
import nounous.ejb.data.Parent;
import nounous.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceParent implements IServiceParent {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoParent daoParent;

	// Actions

	@Override
	public int inserer(DtoParent dtoParent) throws ExceptionValidation {
		verifierValiditeDonnees(dtoParent);
		int id = daoParent.inserer(mapper.map(dtoParent));
		return id;
	}

	@Override
	public void modifier(DtoParent dtoParent) throws ExceptionValidation {
		verifierValiditeDonnees(dtoParent);
		daoParent.modifier(mapper.map(dtoParent));
	}

	@Override
	public void supprimer(int idParent) throws ExceptionValidation {
		daoParent.supprimer(idParent);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoParent retrouver(int idParent) {
		Parent parent = daoParent.retrouver(idParent);
		return mapper.map(parent);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoParent> listerTout(int idParent) {
		List<DtoParent> liste = new ArrayList<>();
		for (Parent parent : daoParent.listerTout(idParent)) {
			liste.add( mapper.mapMinimal(parent) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoParent dtoParent) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoParent.getNom() == null || dtoParent.getNom().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoParent.getNom().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (dtoParent.getPrenom() == null || dtoParent.getPrenom().isEmpty()) {
			message.append("\nLe prénom est absent.");
		} else if (dtoParent.getPrenom().length() > 25) {
			message.append("\nLe prénom est trop long.");
		}

		for (DtoTelephone telephoe : dtoParent.getTelephones()) {
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
