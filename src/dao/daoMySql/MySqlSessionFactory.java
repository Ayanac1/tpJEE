package dao.daoMySql;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.Client;
import dao.DAOConfigException;
import dao.Factory;
import dao.IDao;
import model.Credit;
import model.utilisateur;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class MySqlSessionFactory extends Factory {
    private static  MySqlSessionFactory instance = null;
    private static  Connection session = null;
    private static  IDao<Client, Long> client_Dao = null;
    private static  IDao<Credit, Long> credit_Dao = null;
    private static  IDao<utilisateur, Long> user_Dao = null;


    private MySqlSessionFactory() throws DAOConfigException, IOException, SQLException, ClassNotFoundException {

        try {
            ClassLoader cL = Thread.currentThread().getContextClassLoader();
            var config = cL.getResourceAsStream("config.properties");
            if (config == null) throw new IOException("config.properties introuvable");
            var properties = new Properties();
            properties.load(config);
            var url = properties.getProperty("SDB.url");
            var user = properties.getProperty("SDB.user");
            var password = properties.getProperty("SDB.password");
            session = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie");
            var CreditDao = properties.getProperty("CreditDao");
            var ClientDao = properties.getProperty("ClientDao");
            var UtilisateurDao = properties.getProperty("UtilisateurDao");

            String cCreditDao = properties.getProperty("CreditDao");
            String cClientDao = properties.getProperty("ClientDao");
            String cUtilisateurDao = properties.getProperty("UtilisateurDao");
            credit_Dao = (IDao<Credit, Long>) Class.forName(cCreditDao).getDeclaredConstructor().newInstance();
            client_Dao = (IDao<Client, Long>) Class.forName(cClientDao).getDeclaredConstructor().newInstance();
            user_Dao = (IDao<utilisateur, Long>) Class.forName(cUtilisateurDao).getDeclaredConstructor().newInstance();

            Method setFactory = credit_Dao.getClass().getMethod("setFactory", MySqlSessionFactory.class);
            setFactory.invoke(credit_Dao, this);

            setFactory = client_Dao.getClass().getMethod("setFactory", MySqlSessionFactory.class);
            setFactory.invoke(client_Dao, this);

            setFactory = user_Dao.getClass().getMethod("setFactory", MySqlSessionFactory.class);
            setFactory.invoke(user_Dao, this);


        }catch (Exception e){
            throw new DAOConfigException(e.getMessage());
        }


    }

    public abstract com.sun.jdi.connect.spi.Connection getSession();
}
