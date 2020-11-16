/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghiemtd.tbl_item;
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
public class ItemDAO implements Serializable {
    private List<ItemDTO> itemList = null;

    public List<ItemDTO> getAllItem() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        itemList = new ArrayList<>();
        try {
            conn = DBHelpers.makeConnection();
            if (conn != null) {
                String sql = "Select itemCode, itemName, unit, price, supplying, supCode " +
                        "From Items ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    ItemDTO dto = new ItemDTO(rs.getString("itemCode"), rs.getString("itemName"),
                            rs.getString("unit"), rs.getDouble("price"), rs.getBoolean("supplying"),
                            rs.getString("supCode"));
                    itemList.add(dto);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public void removeItem(String itemCode) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBHelpers.makeConnection();
            if (conn != null) {
                String sql = "Delete Items Where itemCode = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, itemCode);
                stm.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createItem(ItemDTO dto) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBHelpers.makeConnection();
            if (conn != null) {
                String sql = "Insert into Items(itemCode, itemName, unit, price, supplying, supCode) " +
                        "Values(?, ?, ?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getItemCode());
                stm.setString(2, dto.getItemName());
                stm.setString(3, dto.getUnit());
                stm.setDouble(4, dto.getPrice());
                stm.setBoolean(5, dto.isSupplying());
                stm.setString(6, dto.getSuppCode());
                stm.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateItem(ItemDTO dto) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBHelpers.makeConnection();
            if (conn != null) {
                String sql = "Update Items " +
                        "Set itemName = ?, unit = ?, price = ?, supplying = ?, supCode = ? " +
                        "Where itemCode = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getItemName());
                stm.setString(2, dto.getUnit());
                stm.setDouble(3, dto.getPrice());
                stm.setBoolean(4, dto.isSupplying());
                stm.setString(5, dto.getSuppCode());
                stm.setString(6, dto.getItemCode());
                stm.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
