package jdbc;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) throws SQLException {
        var url= "jdbc:mysql://localhost:3306/bankati";
        var login= "root";
        var password= "";
        var driver= "com.mysql.cj.jdbc.Driver";
        Connection connexion= null;
        Statement statement=null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData= null;

        try{
            Class.forName(driver);
            System.out.println("le driver a ete charge avec succes");
           connexion= DriverManager.getConnection(url,login,password);
            System.out.println("driver acess ");

            statement= connexion.createStatement();
            resultSet = statement.executeQuery("");

        }catch (ClassNotFoundException e){
            System.out.println("introuvable");

        } catch (SQLException e) {
            System.out.println("problem");
        }finally {
            try {


            if (connexion !=null ){
                connexion.close();
                System.out.println("connexion ferme");}
            }catch (SQLException e){
                System.err.println("connection n a pas pu etre ferme");
            }
        }
    }
}
