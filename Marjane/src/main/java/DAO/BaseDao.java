package DAO;

import java.util.*;

public interface BaseDao<T> {
    Optional<T> findById(Long id);

    T save(T t);

    List<T> all();

    Boolean update(Long id, T t);

    Boolean delete(Long id);
}
