package nounous.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nounous.ejb.dao.IDaoEnfant;
import nounous.ejb.data.Enfant;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEnfant implements IDaoEnfant {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Enfant enfant) {
		em.persist(enfant);
		em.flush();
		return enfant.getIdEnfant();
	}

	@Override
	public void modifier(Enfant enfant) {
		em.merge( enfant );
	}

	@Override
	public void supprimer(int idEnfant) {
		em.remove( retrouver(idEnfant) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Enfant retrouver(int idEnfant) {
	return em.find( Enfant.class, idEnfant);
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Enfant> listerTout() {
		em.clear();
		var jpql = "SELECT e FROM Enfant e ORDER BY e.nom, e.prenom";
		var query = em.createQuery( jpql, Enfant.class );
		return query.getResultList();
	}


	

}
