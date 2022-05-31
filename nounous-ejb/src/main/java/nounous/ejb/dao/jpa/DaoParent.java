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

import nounous.ejb.dao.IDaoParent;
import nounous.ejb.data.Contrat;
import nounous.ejb.data.Enfant;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoParent implements IDaoParent {
	
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
		em.merge(enfant);
		
	}

	@Override
	public void supprimer(int idEnfant) {
		em.remove(retrouver(idEnfant));
		
	}

	@Override
	public Enfant retrouverEnfant(int idEnfant) {
		var graph = em.createEntityGraph( Enfant.class );
		graph.addAttributeNodes( "enfants" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Enfant.class, idEnfant, props );
	}
	
	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Contrat retrouver(int idEnfant) {
		var graph = em.createEntityGraph( Contrat.class );
		graph.addAttributeNodes( "telephones" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Contrat.class, idEnfant, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Enfant> listerTout(int id) {
		em.clear();
		var jpql = "SELECT e FROM Enfant e ORDER BY e.nom, e.prenom WHERE e.idparent = :.id";
		var query = em.createQuery( jpql, Enfant.class );
		return query.getResultList();
	}

	


}
