package nounous.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nounous.ejb.dao.IDaoNounou;
import nounous.ejb.data.Nounou;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoNounou implements IDaoNounou {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Nounou nounou) {
		em.persist(nounou);
		em.flush();
		return nounou.getId();
	}

	@Override
	public void modifier(Nounou nounou) {
		em.merge( nounou );
	}

	@Override
	public void supprimer(int idNounou) {
		em.remove( retrouver(idNounou) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Nounou retrouver(int idNounou) {
		var graph = em.createEntityGraph( Nounou.class );
		graph.addAttributeNodes( "contrats" );
		graph.addAttributeNodes( "telephones" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Nounou.class, idNounou, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Nounou> listerTout() {
		em.clear();
		var jpql = "SELECT n FROM Nounou n ORDER BY n.nom, n.prenom";
		var query = em.createQuery( jpql, Nounou.class );
		return query.getResultList();
	}


}
