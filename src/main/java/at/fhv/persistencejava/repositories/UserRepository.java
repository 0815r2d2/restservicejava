/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 14.04.2019
 */
package at.fhv.persistencejava.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import at.fhv.persistencejava.entities.User;

public class UserRepository implements BaseRepository<User> {

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#loadAll(javax.persistence.EntityManager)
	 */
	public List<User> loadAll(EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);

		CriteriaQuery<User> selectQuery = query.select(root);
		TypedQuery<User> typedQuery = entityManager.createQuery(selectQuery);
		return typedQuery.getResultList();
	}

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#load(javax.persistence.EntityManager, java.lang.Integer)
	 */
	public User load(EntityManager entityManager, Integer id) {
		return entityManager.find(User.class, id);
	}

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#delete(javax.persistence.EntityManager, java.lang.Integer)
	 */
	public void delete(EntityManager entityManager, Integer id) {
		User emp = load(entityManager, id);
	    if (emp != null) {
	    	entityManager.remove(emp);
	    }
	}
}