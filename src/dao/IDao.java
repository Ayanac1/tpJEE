package dao;

import dao.daoMySql.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface IDao <T,ID>{
    T findById (ID id);
    List<T> findAll () throws DAOException;
    T save (T t) throws SQLException, DAOException;
    T update (T t) throws DAOException, SQLException;
    boolean delete (T t) throws DAOException, SQLException;
    boolean deleteBy (ID id) throws DAOException;
    T trouverParId(ID id);
}
