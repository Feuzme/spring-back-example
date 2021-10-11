package fr.feuzme.demo.services;

import java.util.List;

public interface GenericCRUDService<T> {
	/**
	 * Get entity of database by Id
	 * @param id the desired entity
	 * @return the entity found by his id
	 */
	public T findById(String id);
	/**
	 * return all entity in database
	 * @return
	 */
	public List<T> findAll();
	/**
	 * Save the entity in DB
	 * @param entity
	 * @return the saved entity
	 */
	public T save(T entity);
	/**
	 * delete an entity by its ID
	 * @param id the id of the entity you want to delete
	 */
	void deleteById(String id);
	/**
	 * Update entity modified fields
	 * @param entity
	 * @return the entity with the new parameters 
	 */
	public T update(T entity);
}
