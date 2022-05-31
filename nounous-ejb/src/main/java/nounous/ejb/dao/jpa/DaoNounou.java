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
import nounous.ejb.data.Enfant;
import nounous.ejb.data.Parent;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoNounou implements IDaoNounou {
	
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
		em.merge( parent );
	}

	@Override
	public void supprimer(int idParent) {
		em.remove( retrouver(idParent) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Parent retrouver(int idParent) {
		var graph = em.createEntityGraph( Parent.class );
		graph.addAttributeNodes( "enfant" );
		graph.addAttributeNodes( "telephones" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Parent.class, idParent, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Enfant> listerTout() {
		em.clear();
		var jpql = "SELECT e FROM Enfant e ORDER BY e.nom, e.prenom";
		var query = em.createQuery( jpql, Enfant.class );
		return query.getResultList();
	}


	/*@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public int compterPourCategorie(int idCategorie) {
		var jpql = "SELECT COUNT(p) FROM Parent p WHERE p.categorie.id = :idCategorie";
		var query = em.createQuery( jpql, Long.class );
		query.setParameter( "idCategorie", idCategorie );
		return query.getSingleResult().intValue();
	}*/

}
