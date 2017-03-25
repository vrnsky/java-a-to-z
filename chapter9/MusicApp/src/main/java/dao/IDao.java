package dao;

import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 21.03.2017
 * @param <T> generic type.
 */
public interface IDao<T> {

    /**
     * Remove by id.
     */
    String REMOVE_BY_ID = "DELETE FROM %s WHERE id = ?";

    /**
     * Select all.
     */
    String SELECT_ALL = "SELECT * FROM %s";

    /**
     * Add new to the system.
     * @param value instance of T.
     * @return id which generated.
     */
    int add(T value);

    /**
     * Add new to the system.
     * @param value instance of T.
     */
    void edit(T value);

    /**
     * Return T with given id.
     * @param id of T.
     * @return T object which have id.
     */
    T getById(int id);

    /**
     * Remove from system.
     * @param value object for removing.
     */
    void remove(T value);

    /**
     * Return all instances from db.
     * @return list of all.
     */
    List<T> getAll();


}
