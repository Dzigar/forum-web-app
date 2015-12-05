package com.forum.app.service;

import java.io.Serializable;
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
 * Implementation of CrudService.
 * 
 * @author dzigar
 * @param <T>,
 *            type entity
 * @param <PK>,
 *            primarykey, the primary key
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
	public <T, PK extends Serializable> T find(Class<T> type, PK id) {
		return (T) this.em.find(type, id);

	}

	@Override
	public <T, PK extends Serializable> void delete(Class<T> type, PK id) {
		T ref = (T) em.find(type, id);
		this.em.remove(ref);
	}

	@Override
	public <T> T update(T t) {
		return (T) this.em.merge(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findByNamedQuery(String namedQueryName) {
		return this.em.createNamedQuery(namedQueryName).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findByNamedQuery(String queryName, Map<String, Object> parameters) {
		return (List<T>) prepareQuery(queryName, parameters).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T findUniqueByNamedQuery(String queryName) {
		return (T) this.em.createNamedQuery(queryName).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public <T> T findUniqueByNamedQuery(String queryName, Map<String, Object> parameters) {
		return (T) prepareQuery(queryName, parameters).getSingleResult();
	}

	private Query prepareQuery(String queryName, Map<String, Object> parameters) {
		Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = this.em.createNamedQuery(queryName);
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query;
	}
}
