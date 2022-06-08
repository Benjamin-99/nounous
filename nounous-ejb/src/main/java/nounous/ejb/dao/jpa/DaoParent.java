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
import nounous.ejb.data.Parent;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoParent implements IDaoParent {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	

	@Override
	public int inserer(Parent parent) {
		em.persist(parent);
		em.flush();
		return parent.getIdParent();
	}

	@Override
	public void modifier(Parent parent) {
		em.merge(parent);
		
	}

	@Override
	public void supprimer(int idParent) {
		em.remove(retrouver(idParent));
		
	}
	
	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Parent retrouver(int idParent) {
		var graph = em.createEntityGraph( Parent.class );
		graph.addAttributeNodes( "telephones" );
		graph.addAttributeNodes( "enfants" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Parent.class, idParent, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Parent> listerTout(int id) {
		em.clear();
		var jpql = "SELECT p FROM Parent p ORDER BY p.nom, p.prenom WHERE p.idparent = :.id";
		var query = em.createQuery( jpql, Parent.class );
		return query.getResultList();
	}

	


}
