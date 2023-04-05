package dao.daoVolatile;

import dao.IDao;
import dao.daoMySql.DAOException;
import model.Credit;

import java.sql.SQLException;
import java.util.*;


public class CreditDao implements IDao<Credit, Long> {
    public static Set<Credit> BdCredit(){
        return new HashSet<Credit>(
                Arrays.asList(
                        new Credit(1L,300000.0, 120,2.5,"hiba",0.0),
                        new Credit(2L,300000.0, 130,2.4,"aya",0.0),
                        new Credit(3L,300000.0, 110,2.6,"anissa",0.0)

        ));
    }

    @Override
    public Credit findById(Long aLong) {
        return null;
    }

    @Override
    public List<Credit> findAll() throws DAOException {
        return null;
    }

    @Override
    public Credit save(Credit credit) throws SQLException, DAOException {
        return null;
    }

    @Override
    public Credit update(Credit credit) throws DAOException, SQLException {
        return null;
    }

    @Override
    public boolean delete(Credit credit) throws DAOException, SQLException {
        return false;
    }

    @Override
    public boolean deleteBy(Long aLong) {
        return false;
    }

    public Credit trouverParId(Long id){

        return BdCredit().stream().filter(credi -> credi.getId()== id).findFirst().orElse(null);
    }


    }

