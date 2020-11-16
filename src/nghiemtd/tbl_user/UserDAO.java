/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghiemtd.tbl_user;

import nghiemtd.ulti.DBHelpers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author trndu
 */
public class UserDAO implements Serializable {

    public boolean checkLogin(String userName, String password){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBHelpers.makeConnection();
            if (conn != null){
                String sql = "Select userID " +
                        "From Users " +
                        "Where userID = ? and password = ? and status = 1";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userName);
                stm.setString(2, password);
                rs = stm.executeQuery();

                if (rs.next()){
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
