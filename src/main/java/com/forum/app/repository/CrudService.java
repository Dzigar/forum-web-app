package com.forum.app.repository;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author dzigar
 *
 */
public interface CrudService {

	<T> T create(T t);

	<T> T find(Object id, Class<T> type);

	<T> T update(T t);

	void delete(Object t);

	@SuppressWarnings("rawtypes")
	List findByNamedQuery(String queryName);

	@SuppressWarnings("rawtypes")
	List findByNamedQuery(String queryName, int resultLimit);

	@SuppressWarnings("rawtypes")
	List findByNamedQuery(String namedQueryName, Map<String, Object> parameters);

	@SuppressWarnings("rawtypes")
	List findByNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit);

	<T> T findUniqueByNamedQuery(String queryName, Map<String, Object> params);
}
