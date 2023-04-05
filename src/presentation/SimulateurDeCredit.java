package presentation;

import dao.daoVolatile.CreditDao;
import dao.IDao;
import metier.CreditMetier;
import metier.IMetierCredit;
import model.Credit;

import java.util.Properties;
import java.util.Scanner;




public class SimulateurDeCredit {
    static ICreditController creditController;
    static Scanner clavier = new Scanner(System.in);
    private static boolean estUnNombre(String input){
        try { Integer.parseInt(input);
            return true;
        }catch (Exception e){ return false;} }
    public static void test1(){
        var dao = new CreditDao();
        var metier = new CreditMetier();
        var controleur =new CreditController();
        metier.setCreditDao(dao);
        controleur.setCreditMetier(metier);
        String rep ="";
        do {
            System.out.println("[test1]=>calcule de mensualite de credit ");
            try {
                String input ="";
                while (true){
                    System.out.println("=>entrer l id du credit");
                    input= clavier.nextLine();
                    if (estUnNombre(input))break;
                    System.out.println("entrer non valide");
                }
                long id = Long.parseLong(input);
                controleur.afficher_Mensualite(id);
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }while (!rep.equalsIgnoreCase("oui"));
        System.out.println("au revoir");

    }

    public static void test2() throws Exception {
        IDao<Credit, Long> dao = null;
        IMetierCredit metier = null;
        ICreditController controller = null;


        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        var config = classLoader.getResourceAsStream("presentation/config.properties");
        Properties properties = new Properties();
        try {
            properties.load(config);
            var daoClass = properties.getProperty("DAO");
            var serviceClass = properties.getProperty("service");
            var controllClass = properties.getProperty("Controller");

            Class cDao = Class.forName(daoClass);
            dao = (IDao<Credit, Long>) cDao.getDeclaredConstructor().newInstance();

            Class cMetier = Class.forName(serviceClass);
            dao = (IDao<Credit, Long>) cMetier.getDeclaredConstructor().newInstance();

            Class cControll = Class.forName(controllClass);
            dao = (IDao<Credit, Long>) cControll.getDeclaredConstructor().newInstance();







        }catch (Exception e) {
        }    }
    public static void main(String[] args)throws Exception {test2();}
}
