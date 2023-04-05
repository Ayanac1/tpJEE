package dao.daoMySql;

import dao.IDao;
import model.Compte;
import model.client;

import java.util.List;

public class clientDao  implements IDao<client,Long> {
    public client findById (long id ){return null;}

    @Override
    public client findById(Long aLong) {
        return null;
    }

    public List<client> findAll(){return null;}
    public client save (client client){return null;}
    public client update (client client){return null;}
    public boolean delete (client client){return false;}

    @Override
    public boolean deleteBy(Long aLong) {
        return false;
    }

    public boolean deleteById (long id){return false;}

    @Override
    public client trouverParId(Long aLong) {
        return null;
    }
}
