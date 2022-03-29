package ru.zhadaev;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
        T save(T entity) throws SQLException;

        Optional<T> findById(ID id) throws DAOException;

        boolean existsById(ID id) throws DAOException;

        List<T> findAll() throws DAOException;

        long count() throws DAOException;

        void deleteById(ID id);

        void delete(T entity);

        void deleteAll();
}
