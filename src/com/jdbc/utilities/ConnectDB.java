package com.jdbc.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que implementa el patró Singleton per esatablir la conexió amb la BBDD
 */
public class ConnectDB {
    /* Es declara una variable del tipus java.sql.Connection, per convenció es denomina "instància".
    Aquesta variable és la que s'instanciarà una única vegada */
    private static Connection instance;
    /* Es privatitza el constructor per tal que no sigui possible fer new ConnectDB()
       des d'un altre lloc que no sigui aquesta mateixa classe */
    private ConnectDB(){} 
    /* Per utilitzar l'única instància de la classe, s'haurà de cridar al mètode estàtic
    getInstance(). La primera vegada que es cridi, instance serà null, la resta es
    tornarà l'objecte Connection ja creat, assegurant així que només es creï un
    objecte del tipus Connection */

     public static Connection getInstance() throws SQLException{
         if (instance==null){
             instance = DriverManager.getConnection(MYSQLDEMOConnection.url,
                        MYSQLDEMOConnection.username, 
                        MYSQLDEMOConnection.password);
             System.out.println("Open Database");
         }
     return instance;}
     
     public static void closeConnection() throws SQLException{
         if (instance!=null){
             instance.close();
             System.out.println("Database Closed");
         }
     }
}
