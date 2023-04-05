package dao;

import java.sql.SQLException;

public abstract class Factory {
    public static  final int MySql_DAO_FACTORY =0;
    public static final int File_DAO_FACTORY=1;

    public abstract IDao getUtilisateurDao();

    public abstract IDao getClientDao();

    public abstract IDao getAdminDao();

    public abstract IDao getCompteDao();

    public abstract IDao getBanqueDao();




public static Factory getFactory(int type) throws SQLException, DAOConfigException {
    switch (type) {
        case MySql_DAO_FACTORY:
            return FactoryMySql.getInstance();
        case File_DAO_FACTORY:
            return new FactoryId();
        default:
            return null;
    }


}}