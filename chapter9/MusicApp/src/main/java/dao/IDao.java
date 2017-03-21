package dao;

import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 21.03.2017
 */
public interface IDao<T> {

    String REMOVE_BY_ID = "DELETE FROM %s WHERE id = ?";
    String SELECT_ALL = "SELECT * FROM %s";
    int add(T value);
    void edit(T value);
    T getById(int id);
    void remove(T value);
    List<T> getAll();


}
