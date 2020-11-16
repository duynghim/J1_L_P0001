/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghiemtd.tbl_supplier;

import nghiemtd.ulti.DBHelpers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trndu
 */
public class SupplierDAO implements Serializable {
    private List<SupplierDTO> supplierList = null;

    public void createSupplier(SupplierDTO dto) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBHelpers.makeConnection();
            if (conn != null) {
                String sql = "Insert into Suppliers(supCode, supName, address, collaborating) " +
                        "Values(?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getSuppCode());
                stm.setString(2, dto.getSuppName());
                stm.setString(3, dto.getAddress());
                stm.setBoolean(4, dto.isCollaborating());
                stm.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<SupplierDTO> getAllSupplier() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        supplierList = new ArrayList<>();
        try {
            conn = DBHelpers.makeConnection();
            if (conn != null) {
                String sql = "Select supCode, supName, address, collaborating " +
                        "From Suppliers";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    SupplierDTO dto = new SupplierDTO(rs.getString("supCode"), rs.getString("supName"),
                            rs.getString("address"), rs.getBoolean("collaborating"));
                    supplierList.add(dto);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return supplierList;
    }

    public boolean removeSupplier(String supplierCode) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelpers.makeConnection();
            if (conn != null) {
                String sql = "Delete From Suppliers " +
                        "Where supCode = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, supplierCode);
                stm.executeUpdate();
            }
        } catch (SQLException throwables) {
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void updateSupplier(SupplierDTO dto) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBHelpers.makeConnection();
            if (conn != null) {
                String sql = "Update Suppliers " +
                        "Set supName = ?, address = ?, collaborating = ? " +
                        "Where supCode = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getSuppName());
                stm.setString(2, dto.getAddress());
                stm.setBoolean(3, dto.isCollaborating());
                stm.setString(4, dto.getSuppCode());
                stm.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}