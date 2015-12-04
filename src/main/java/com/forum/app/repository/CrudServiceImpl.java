package com.forum.app.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author dzigar
 *
 */
@Repository
@Transactional
public class CrudServiceImpl implements CrudService {

	@PersistenceContext
	EntityManager em;

	@Override
	public <T> T create(T t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;

	}

	@Override
	public <T> T find(Object id, Class<T> type) {
		return (T) this.em.find(type, id);

	}

	@Override
	public void delete(Object t) {
		Object ref = this.em.getReference(t.getClass(), t);
		this.em.remove(ref);
	}

	@Override
	public <T> T update(T t) {
		return (T) this.em.merge(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findByNamedQuery(String namedQueryName) {
		return this.em.createNamedQuery(namedQueryName).getResultList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findByNamedQuery(String queryName, int resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findByNamedQuery(String namedQueryName, Map<String, Object> parameters) {
		return findByNamedQuery(namedQueryName, parameters, 0);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findByNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit) {
		Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = this.em.createNamedQuery(namedQueryName);
		if (resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public <T> T findUniqueByNamedQuery(String queryName, Map<String, Object> params) {
		Set<Entry<String, Object>> rawParameters = params.entrySet();
		Query query = em.createNamedQuery(queryName);
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return (T) query.getSingleResult();
	}
}
