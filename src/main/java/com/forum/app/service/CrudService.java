package com.forum.app.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * CrudService interface.
 * 
 * @author dzigar
 *
 */
public interface CrudService {

	/**
	 * Creates a new object for the given type. After a call to this method the
	 * entity will be persisted into database and then refreshed. Also current
	 * persistent Session will be flushed.
	 * 
	 * @param <T>
	 * @param t
	 * @return persisted Object
	 */
	<T> T create(T t);

	/**
	 * Finds an object by id
	 * 
	 * @param <T>
	 * @param <PK>
	 * @param type
	 * @param id
	 * @return the object
	 */
	<T, PK extends Serializable> T find(Class<T> type, PK id);

	/**
	 * Updates the given object
	 * 
	 * @param <T>
	 * @param t
	 * @return persisted object
	 */
	<T> T update(T t);

	/**
	 * Deletes the given object by id
	 * 
	 * @param <T>
	 * @param <PK>
	 * @param type
	 *            , entity class type
	 * @param id
	 */
	<T, PK extends Serializable> void delete(Class<T> type, PK id);

	/**
	 * Finds a list of objects for the given query name
	 * 
	 * @param <T>
	 * @param queryName
	 * @return returns a list of objects
	 */
	<T> List<T> findByNamedQuery(String queryName);

	/**
	 * Find a a list of objects for the given query with parameters
	 * 
	 * @param <T>
	 * @param queryName
	 * @param params
	 * @return resulting list
	 */
	<T> List<T> findByNamedQuery(String queryName, Map<String, Object> params);

	/**
	 * Returns one result, query without parameters
	 * 
	 * @param <T>
	 * @param queryName
	 * @return T object
	 */
	<T> T findUniqueByNamedQuery(String queryName);

	/**
	 * Returns just one result with a named query and parameters
	 * 
	 * @param <T>
	 * @param queryName
	 * @param params
	 * @return T object
	 */
	<T> T findUniqueByNamedQuery(String queryName, Map<String, Object> params);
}
