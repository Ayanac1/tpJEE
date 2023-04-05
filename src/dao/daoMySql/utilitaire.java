package dao.daoMySql;

import java.sql.*;

public class utilitaire {
    public static PreparedStatement initPs(Connection CNX, String sql, boolean generateKey, long nom, String prenom, String email, String cin, int tel, String sexe) throws SQLException {
        PreparedStatement ps = null;
        ps = CNX.prepareStatement(sql, generateKey ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
        Object[] Columns = new Object[0];
        for (int i = 0; i < Columns.length; i++) {
            ps.setObject(i + 1, Columns[i]);
        }
        return ps;
    }

    public static void CloseDaoObject(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture du ResultSet : " + e.getMessage());
        }
    }

    public static void CloseDaoObject(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture du PreparedStatement : " + e.getMessage());

        }

    }

    public static void CloseDaoObject(Connection CNX) {
        try {
            if (CNX != null) {
                CNX.close();
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
        }

    }

    public static void CloseDaoObject(ResultSet rs, PreparedStatement ps, Connection CNX) {
        CloseDaoObject(rs);
        CloseDaoObject(ps);
        CloseDaoObject(CNX);
    }

    public static void CloseDaoObject(ResultSet rs, PreparedStatement ps) {
        CloseDaoObject(ps);
        CloseDaoObject(rs);
    }

    public static void close(PreparedStatement ps, ResultSet rs) {

    }

    public static PreparedStatement initPs(Connection connection, String update, boolean b, long nom, String prenom, String email, String cin, int tel, String sexe, long id) {
        return null;
    }

    public static PreparedStatement initPs(com.sun.jdi.connect.spi.Connection session, String sql, boolean b, Double capilateEmprunt, Integer nombreMois, Double tauxMensuel, String nomDemandeur, Double mensualite) {

        return null;
    }

    public static PreparedStatement initPs(com.sun.jdi.connect.spi.Connection session, String sql, boolean b, Long id) {
    return null;
    }
}
