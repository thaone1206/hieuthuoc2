/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieuthuoc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class databaseuntil {
   public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
			"databaseName=QLHT;user=sa; password = 3614867";
   public static  Connection getDBConnect(){
       try {
           Connection con = null;
           
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           // cho pheps khai bao driver
           con = DriverManager.getConnection(connectionUrl);
           return  con;
            
       } catch (ClassNotFoundException ex) {
           System.out.println("where is driver ?");
           System.err.println("erorr:" +ex.toString());
       } catch (SQLException ex) {
           //loi ketnoi
           System.out.println("error"+ex.toString());
       }
       return null;
       
       
   }
}
