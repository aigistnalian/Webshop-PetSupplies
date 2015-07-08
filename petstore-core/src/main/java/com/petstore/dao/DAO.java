package com.petstore.dao;

/**
 * @author analian
 *
 * @param <K>
 * @param <E>
 */
public interface DAO<K, E> {
    void persist(E entity);
    void remove(E entity);
    E findById(K id);
}
