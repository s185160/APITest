/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    
    //Vi anvender kode fra denne her side i porjektet https://stackoverflow.com/questions/37909487/how-can-i-connect-to-mariadb-using-java

    //start medat erklÃ¦re attributter:
    private static Connection con = null;
    private static String databasenavn,url,user,password;
    private Statement stmt =null;
    private static final String driver = "com.mysql.jdbc.Driver";
//vores skema hedder ejournal
   // private String databasenavn, url,user,password;
//
//
//    public static void main(String[] args) {
////ConnectionProvider cp =new ConnectionProvider();
////cp.connectToLocal("127.0.0.1");
//        connectToLocal("192.168.239.25");
//        //Husk at nÃ¥r I tilgÃ¥r en anden IP, sÃ¥ Ã¦ndrer I fÃ¸lgende i jeres nye connection:
//        //IP, username, password og databasenavnet
//
//    }


    public static void connectToLocal(String ipaddress){
        try {
//for lokale maskiness
            //String  driver = "org.sqlite.JDBC";
//definer din drve til at vÃ¦re Mariadb i stedet for SQLITE
            Class.forName(driver);
            System.out.println("Forbinder ....");
            databasenavn= "ejournal";
             url = "jdbc:mariadb://"+ipaddress+":3306/"+databasenavn;
            System.out.println("Ip er"+ipaddress);
             user = "nakisa";
             //for atconnectetil
             password = "2019";


            con = DriverManager.getConnection(url, user, password);
            System.out.println("Hej");
        } catch (SQLException | ClassNotFoundException sqe){

                   // url = "jdbc:mariadb://"+"localhost"+"/"+databasenavn;
            // con = DriverManager.getConnection(url,user,password);
           sqe.printStackTrace();
        }
    }

    public void connectToOther(){


    }



    public static Connection getConnection() {

        if (con != null)
            return con;
        else {
            try {
//for lokale maskine
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/appointmentdatabase?zeroDateTimeBehavior=convertToNull";
                String user = "appointmentUser";
                String password = "abcd";
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException cnfe) {
                System.out.println(cnfe);
            } catch (SQLException sqe) {
                System.out.println(sqe);
            }
            return con;
        }

    }
    
}
