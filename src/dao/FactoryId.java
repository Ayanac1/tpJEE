package dao;
import dao.IDao;

public class FactoryId extends Factory {


    @Override
    public IDao getUtilisateurDao() {
        return null;
    }

    @Override
    public IDao getClientDao() {
        return null;
    }

    @Override
    public IDao getAdminDao() {
        return null;
    }

    @Override
    public IDao getCompteDao() {
        return null;
    }

    @Override
    public IDao getBanqueDao() {
        return null;
    }
}
