/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghiemtd.ulti;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class DBHelpers implements Serializable{
    public static Connection makeConnection() 
            throws SQLException, ClassNotFoundException{
        //1. Load driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Create connection statement
        String url = "jdbc:sqlserver://localhost:1433;databaseName=ItemManagement";
        //3. Open connection
        Connection con = DriverManager.getConnection(url, "sa", "Nh@Tr@ng29");
        return con;
    }
}
