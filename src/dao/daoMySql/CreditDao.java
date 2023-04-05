package dao.daoMySql;


import com.sun.jdi.connect.spi.Connection;
import dao.IDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Credit;
import model.utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CreditDao implements IDao<Credit,Long> {
    MySqlSessionFactory factory;
    private Credit credit;

    public Credit findById (long idCredit ) throws DAOException {
        Credit credit = null;
        Connection session = factory.getSession();
        PreparedStatement ps = null;
        String SQL = "SELECT * FROM credit WHERE idCredit = ?";
        ResultSet rs = null;
        try {
            ps = utilitaire.initPs((java.sql.Connection) session, SQL, false, utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getCin(), utilisateur.getTel(), utilisateur.getSexe());
            rs = ps.executeQuery();
            if (rs.next())
                credit = map(rs);
            System.out.println("[SQL}: " + SQL);
            return credit;

    }
    catch (SQLException e) {
        throw new DAOException("erreur findById credit", e);
    }
    finally {
        utilitaire.CloseDaoObject(rs, ps);
    }
    }
    public List<Credit> findAll() throws DAOException {
        List<Credit> credits = null;
        Connection session = factory.getSession();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM credit";
        try {
            ps = utilitaire.initPs((java.sql.Connection) session, SQL, false, utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getCin(), utilisateur.getTel(), utilisateur.getSexe());
            rs = ps.executeQuery();
            while (rs.next())
                credits.add(map(rs));
            System.out.println("[SQL}: " + SQL);
            return credits;

        } catch (SQLException e) {
            throw new DAOException("erreur findById credit", e);
        } finally {
            utilitaire.CloseDaoObject(rs, ps);
        }
    }
    public Credit save(Credit credit) throws DAOException, SQLException {
        Connection session = factory.getSession();
        PreparedStatement ps = null;
        String SQL = "INSERT INTO credit (montant, duree, taux, nom, mensualite) VALUES (?,?,?,?,?)";
        try {
            ps = utilitaire.initPs(session, SQL
                    , true
                    , credit.getCapilate_Emprunt()
                    , credit.getNombre_mois()
                    , credit.getTaux_Mensuel()
                    , credit.getNom_demandeur()
                    , credit.getMensualite());


            var status = ps.executeUpdate();
            if (status == 0)
                throw new DAOException("erreur save credit");
            else {
                var rs = ps.getGeneratedKeys();
                var id = rs.getLong(1);
                credit.setIdCredit(id);
            }
            System.out.println("[SQL}: " + SQL);
            return credit;
        }
        catch (SQLException e) {
            throw new DAOException("erreur save credit", e);
        }
        finally {
            utilitaire.CloseDaoObject(ps);
        }
    }
    public Credit update(Credit credit) throws SQLException, DAOException {
        Connection session = factory.getSession();
        PreparedStatement ps = null;
        String SQL = "UPDATE credit SET montant = ?, duree = ?, taux = ?, nom = ?, mensualite = ? WHERE idCredit = ?";
        try {
            ps = utilitaire.initPs(session, SQL
                    , true
                    , credit.getCapilate_Emprunt()
                    , credit.getNombre_mois()
                    , credit.getTaux_Mensuel()
                    , credit.getNom_demandeur()
                    , credit.getMensualite());


            var status = ps.executeUpdate();
            if (status == 0)
                throw new DAOException("erreur save credit");
            System.out.println("[SQL}: " + SQL);
            return credit;
        }
        catch (SQLException e) {
            throw new DAOException("erreur save credit", e);
        }
        finally {
            utilitaire.CloseDaoObject(ps);
        }
    }
    public boolean delete(Credit credit) throws DAOException {
        Connection session = factory.getSession();
        PreparedStatement ps = null;
        String SQL = "DELETE FROM credit WHERE idCredit = ?";
        try {
            ps = utilitaire.initPs(session, SQL
                    , false
                    , credit.getId());


            var status = ps.executeUpdate();
            if (status == 0)
                throw new DAOException("erreur save credit");
            System.out.println("[SQL}: " + SQL);
            return true;
        }
        catch (SQLException e) {
            throw new DAOException("erreur save credit", e);
        }
        finally {
            utilitaire.CloseDaoObject(ps);
        }
    }
    public boolean deleteBy(Long aLong)throws DAOException {
        return false;
    }

   public Credit map(ResultSet rs) throws DAOException{
        try {
            return new Credit(rs.getLong("idCredit"), rs.getDouble("montant"), rs.getInt("duree"), rs.getDouble("taux"), rs.getString("nom"), rs.getDouble("mensualite"));
        } catch (SQLException e) {
            throw new DAOException("erreur map credit", e);
        }
    }
}
