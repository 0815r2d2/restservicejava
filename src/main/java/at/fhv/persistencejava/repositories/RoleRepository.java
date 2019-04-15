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

import at.fhv.persistencejava.entities.Role;

public class RoleRepository implements BaseRepository<Role>{

	@Override
	public Role load(EntityManager entityManager, Integer id) {
		return entityManager.find(Role.class, id);
	}

	@Override
	public List<Role> loadAll(EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Role> query = builder.createQuery(Role.class);
		Root<Role> root = query.from(Role.class);

		CriteriaQuery<Role> selectQuery = query.select(root);
		TypedQuery<Role> typedQuery = entityManager.createQuery(selectQuery);
		return typedQuery.getResultList();
	}

	@Override
	public void delete(EntityManager entityManager, Integer id) {
		entityManager.remove(id);
	}

}
