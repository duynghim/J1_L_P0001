/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghiemtd.gui;



import nghiemtd.tbl_item.ItemDAO;
import nghiemtd.tbl_item.ItemDTO;
import nghiemtd.tbl_supplier.SupplierDAO;
import nghiemtd.tbl_supplier.SupplierDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author trndu
 */
public class ItemManagement extends javax.swing.JFrame {
    SupplierDAO supplierDAO = new SupplierDAO();
    ItemDAO itemDAO = new ItemDAO();
    DefaultTableModel supplierModel;
    DefaultTableModel itemModel;
    List<SupplierDTO> supplierList;
    List<ItemDTO> itemList;
    int count = 0;



    /**
     * Creates new form ItemManagement
     */
    public ItemManagement() {
        initComponents();
        loadSupplier();
        loadCombobox();
        loadItem();
    }

    private boolean checkValidOfItem() {
        String itemCode = txtItemCode.getText().trim();
        if (!itemCode.matches("^E\\d{4}$")){
            JOptionPane.showMessageDialog(this, "Item code format Exxxx!");
            return false;
        }
        String itemName = txtItemName.getText().trim();
        if (itemName.length() > 50){
            JOptionPane.showMessageDialog(this, "Item name max length is 50 character!");
            return false;
        }

        String itemUnit = txtItemUnit.getText().trim();
        if (itemUnit.length() > 50){
            JOptionPane.showMessageDialog(this, "Item unit max length is 50 character!");
            return false;
        }
        String itemPrice = txtItemPrice.getText().trim();
        if (itemPrice.length() == 0){
            JOptionPane.showMessageDialog(this, "Price is empty!");
            return false;
        }
        try{
            double price = Double.parseDouble(txtItemPrice.getText().trim());
            if (price < 0 || price > 10000){
                JOptionPane.showMessageDialog(this, "Price must be between 0 and 10000!");
                return false;
            }
        }catch (NumberFormatException numberFormatException){
            JOptionPane.showMessageDialog(this, "Price must be a number");
            return false;
        }
        return true;
    }

    public ItemDTO findItemByCode(String itemCode){
        for (ItemDTO x: itemList){
            if (x.getItemCode().contains(itemCode)){
                return x;
            }
        }
        return null;
    }

    public SupplierDTO findSupplierByCode(String supplierCode){
        for (SupplierDTO x : supplierList){
            if (x.getSuppCode().contains(supplierCode)){
                return x;
            }
        }
        return null;
    }



    public void loadItem(){
        itemModel = (DefaultTableModel) tblItems.getModel();
        itemList = itemDAO.getAllItem();
        for (ItemDTO x: itemList){
            String supplierName = findSupplierByCode(x.getSuppCode()).getSuppName();
            itemModel.addRow(new Object[]{x.getItemCode(), x.getItemName(), x.getSuppCode() + "-" + supplierName,
            x.getUnit(), x.getPrice(), x.isSupplying()});
        }
    }

    public void clearItem(){
        txtItemCode.setText("");
        txtItemName.setText("");
        txtItemPrice.setText("");
        txtItemUnit.setText("");
        cbSupplying.setSelected(false);
    }

    public void loadCombobox(){
        if (count == 1){
            cbSuppliers.removeAllItems();
        }
        for (SupplierDTO x: supplierList){
            cbSuppliers.addItem(x.getSuppCode() + "-" + x.getSuppName());
        }
    }

    public void clearSupplier(){
        txtSupCode.setText("");
        txtSupAddr.setText("");
        txtSupName.setText("");
        btnCheckCola.setSelected(false);
    }

    public void loadSupplier(){
        supplierModel = (DefaultTableModel)tblSuppliers.getModel();
        supplierList = supplierDAO.getAllSupplier();
        for (SupplierDTO x : supplierList){
            supplierModel.addRow(new Object[]{x.getSuppCode(), x.getSuppName(), x.getAddress()});
        }
    }

    public boolean checkValidOfSupplier(){
        String supplierCode = txtSupCode.getText().trim();
        if (!supplierCode.matches("^[A-Z]{2}$")){
            JOptionPane.showMessageDialog(this, "Supplier Code Format: 2 Character!");
            txtSupCode.requestFocus();
            return false;
        }

        String supplierName = txtSupName.getText().trim();
        if (supplierName.length() == 0){
            JOptionPane.showMessageDialog(this, "Supplier name is empty!");
            txtSupName.requestFocus();
            return false;
        }
        if (supplierName.length() > 50){
            JOptionPane.showMessageDialog(this, "Supplier name max length is 50 characters!");
            txtSupName.requestFocus();
            return false;
        }

        String supplierAddress = txtSupAddr.getText().trim();
        if (supplierAddress.length() == 0){
            JOptionPane.showMessageDialog(this, "Supplier address is empty!");
            txtSupAddr.requestFocus();
            return false;
        }
        if (supplierAddress.length() > 50){
            JOptionPane.showMessageDialog(this, "Supplier address max length is 50 characters!");
            txtSupAddr.requestFocus();
            return false;
        }
        return true;
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSuppliers = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnCheckCola = new javax.swing.JCheckBox();
        txtSupAddr = new javax.swing.JTextField();
        txtSupName = new javax.swing.JTextField();
        txtSupCode = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnSuppCreate = new javax.swing.JButton();
        btnSuppUpdate = new javax.swing.JButton();
        btnSuppRemove = new javax.swing.JButton();
        btnSuppClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbSupplying = new javax.swing.JCheckBox();
        cbSuppliers = new javax.swing.JComboBox<>();
        txtItemPrice = new javax.swing.JTextField();
        txtItemUnit = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        txtItemCode = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnItemCreate = new javax.swing.JButton();
        btnItemUpdate = new javax.swing.JButton();
        btnItemRemove = new javax.swing.JButton();
        btnItemClear = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Items Management");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel7.setText("Code:");

        tblSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSuppliersMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSuppliers);

        jLabel8.setText("Name:");

        jLabel9.setText("Address:");

        jLabel10.setText("Collaborating:");

        btnCheckCola.setPreferredSize(new java.awt.Dimension(16, 16));

        btnSuppCreate.setText("Create");
        btnSuppCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppCreateActionPerformed(evt);
            }
        });
        jPanel5.add(btnSuppCreate);

        btnSuppUpdate.setText("Update");
        btnSuppUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppUpdateActionPerformed(evt);
            }
        });
        jPanel5.add(btnSuppUpdate);

        btnSuppRemove.setText("Remove");
        btnSuppRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppRemoveActionPerformed(evt);
            }
        });
        jPanel5.add(btnSuppRemove);

        btnSuppClear.setText("Clear");
        btnSuppClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppClearActionPerformed(evt);
            }
        });
        jPanel5.add(btnSuppClear);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSupAddr)
                            .addComponent(txtSupName)
                            .addComponent(txtSupCode)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCheckCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSupCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSupAddr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(btnCheckCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Suppliers", jPanel2);

        jLabel1.setText("Code:");

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Supplier", "Unit", "Price", "Supplying"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblItems);

        jLabel2.setText("Name:");

        jLabel3.setText("Unit:");

        jLabel4.setText("Price:");

        jLabel5.setText("Suppliers:");

        jLabel6.setText("Supplying:");

        cbSupplying.setPreferredSize(new java.awt.Dimension(16, 16));

        btnItemCreate.setText("Create");
        btnItemCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemCreateActionPerformed(evt);
            }
        });
        jPanel4.add(btnItemCreate);

        btnItemUpdate.setText("Update");
        btnItemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnItemUpdate);

        btnItemRemove.setText("Remove");
        btnItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemRemoveActionPerformed(evt);
            }
        });
        jPanel4.add(btnItemRemove);

        btnItemClear.setText("Clear");
        btnItemClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemClearActionPerformed(evt);
            }
        });
        jPanel4.add(btnItemClear);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtItemPrice)
                            .addComponent(txtItemUnit)
                            .addComponent(txtItemName)
                            .addComponent(txtItemCode)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSupplying, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbSupplying, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 91, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Items", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnItemCreateActionPerformed(java.awt.event.ActionEvent evt) {
        if (!checkValidOfItem()){
            return;
        }
        String itemCode = txtItemCode.getText().trim();
        System.out.println(findItemByCode(itemCode));
        if (findItemByCode(itemCode) != null){
            JOptionPane.showMessageDialog(this, "Item Code is duplicate");
            return;
        }

        String itemName = txtItemName.getText().trim();
        String unit = txtItemUnit.getText().trim();
        double price = Double.valueOf(txtItemPrice.getText().trim());
        String supCode = (String) cbSuppliers.getSelectedItem();
        boolean supplying = cbSupplying.isSelected();

        ItemDTO dto = new ItemDTO(itemCode, itemName, unit, price, supplying, supCode.substring(0, 2));
        itemDAO.createItem(dto);
        itemModel.addRow(new Object[]{itemCode, itemName, supCode, unit, price, supplying});
        itemList.add(dto);
        clearItem();
        JOptionPane.showMessageDialog(this, "Create Item successful");
    }//GEN-LAST:event_btnItemCreateActionPerformed

    private void btnItemUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemUpdateActionPerformed
        int row = tblItems.getSelectedRow();
        if (row < 0){
            JOptionPane.showMessageDialog(this, "Choose the item to update!");
            return;
        }

        if (!checkValidOfItem()){
            return;
        }

        String itemCode = txtItemCode.getText().trim();
        String itemName = txtItemName.getText().trim();
        String itemUnit = txtItemUnit.getText().trim();
        boolean supplying = cbSupplying.isSelected();
        String supCode  = cbSuppliers.getSelectedItem().toString().substring(0, 2);
        double price = Double.valueOf(txtItemPrice.getText().trim());
        itemList.remove(findItemByCode(itemCode));
        ItemDTO dto = new ItemDTO(itemCode, itemName, itemUnit, price, supplying, supCode);
        itemDAO.updateItem(dto);
        itemList.add(dto);

        tblItems.setValueAt(itemCode, row, 0);
        tblItems.setValueAt(itemName, row, 1);
        tblItems.setValueAt(cbSuppliers.getSelectedItem().toString(), row, 2);
        tblItems.setValueAt(itemUnit, row, 3);
        tblItems.setValueAt(price, row, 4);
        tblItems.setValueAt(supplying, row, 5);

        JOptionPane.showMessageDialog(this, "Update successful");

    }//GEN-LAST:event_btnItemUpdateActionPerformed

    private void btnItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemRemoveActionPerformed
        int row = tblItems.getSelectedRow();
        if (row < 0){
            JOptionPane.showMessageDialog(this, "Choose items to remove");
            return;
        }
        String itemCode = (String) tblItems.getValueAt(row, 0);
        if (JOptionPane.showConfirmDialog(this, "Do you want to remove " + itemCode + " item?") ==
        JOptionPane.OK_OPTION){
            itemDAO.removeItem(itemCode);
            itemList.remove(findItemByCode(itemCode));
            itemModel.removeRow(row);
        }
    }//GEN-LAST:event_btnItemRemoveActionPerformedyy

    private void btnItemClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemClearActionPerformed
        txtItemCode.setEditable(true);
        txtItemCode.setText("");
        txtItemName.setText("");
        txtItemPrice.setText("");
        txtItemUnit.setText("");
        cbSupplying.setSelected(false);
    }//GEN-LAST:event_btnItemClearActionPerformed

    private void btnSuppUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppUpdateActionPerformed
        int row = tblSuppliers.getSelectedRow();
        if (row < 0){
            JOptionPane.showMessageDialog(this, "Choose supplier you want to update");
            return;
        }

        if (!checkValidOfSupplier()){
            return;
        }

        String supplierCode = txtSupCode.getText().trim();
        SupplierDTO dto = findSupplierByCode(supplierCode);
        supplierList.remove(dto);
        String supplierFullname = txtSupName.getText().trim();
        String supplierAddress = txtSupAddr.getText().trim();
        boolean collaborating = btnCheckCola.isSelected();

        SupplierDTO supplier = new SupplierDTO(supplierCode, supplierFullname, supplierAddress, collaborating);
        supplierDAO.updateSupplier(supplier);
        supplierList.add(supplier);

        supplierModel.setValueAt(supplierFullname, row, 1);
        supplierModel.setValueAt(supplierAddress, row, 2);

        JOptionPane.showMessageDialog(this, "Update successful!");
        count = 1;
        loadCombobox();
    }//GEN-LAST:event_btnSuppUpdateActionPerformed

    private void btnSuppClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppClearActionPerformed
        txtSupCode.setEditable(true);
        txtSupCode.setText("");
        txtSupAddr.setText("");
        txtSupName.setText("");
        btnCheckCola.setSelected(false);
    }//GEN-LAST:event_btnSuppClearActionPerformed

    private void btnSuppRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppRemoveActionPerformed
        int row = tblSuppliers.getSelectedRow();
        if (row < 0){
            JOptionPane.showMessageDialog(this, "Choose supplier you want to remove!");
            return;
        }
        String supplierCode = (String) tblSuppliers.getValueAt(row, 0);
        if (JOptionPane.showConfirmDialog(this, "Do you want to remove " + supplierCode
        + " supplier?") == JOptionPane.OK_OPTION){
            if (!supplierDAO.removeSupplier(supplierCode)){
                JOptionPane.showMessageDialog(this, "You must remove all items of this supplier first!");
                return;
            }
            SupplierDTO dto = findSupplierByCode(supplierCode);
            supplierModel.removeRow(row);
            supplierList.remove(dto);
            count = 1;
            loadCombobox();
            clearSupplier();
        }
    }//GEN-LAST:event_btnSuppRemoveActionPerformed

    private void btnSuppCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppCreateActionPerformed
        if (!checkValidOfSupplier()){
            return;
        }

        String supplierCode = txtSupCode.getText().trim();
        if (findSupplierByCode(supplierCode) != null){
            JOptionPane.showMessageDialog(this, "Supplier code is duplicate!");
            return;
        }

        String supplierFullname = txtSupName.getText().trim();
        String suppierAddress = txtSupAddr.getText().trim();
        boolean collaborating = btnCheckCola.isSelected();
        SupplierDTO dto = new SupplierDTO(supplierCode, supplierFullname, suppierAddress, collaborating);
        supplierDAO.createSupplier(dto);
        supplierModel.addRow(new Object[]{supplierCode, supplierFullname, suppierAddress});
        supplierList.add(dto);
        JOptionPane.showMessageDialog(this, "Create supplier successful");
        clearSupplier();
        count = 1;
        loadCombobox();
    }//GEN-LAST:event_btnSuppCreateActionPerformed

    private void tblSuppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSuppliersMouseClicked
        int row = tblSuppliers.getSelectedRow();
        txtSupCode.setEditable(false);
        String supplierCode = (String) tblSuppliers.getValueAt(row, 0);
        SupplierDTO dto = findSupplierByCode(supplierCode);
        txtSupCode.setText(supplierCode);
        txtSupName.setText(dto.getSuppName());
        txtSupAddr.setText(dto.getAddress());
        btnCheckCola.setSelected(dto.isCollaborating());
    }//GEN-LAST:event_tblSuppliersMouseClicked

    private void tblItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemsMouseClicked
        // TODO add your handling code here:
        int row = tblItems.getSelectedRow();
        txtItemCode.setEditable(false);
        String itemCode = (String) tblItems.getValueAt(row, 0);
        ItemDTO dto = findItemByCode(itemCode);
        txtItemCode.setText(itemCode);
        txtItemName.setText(dto.getItemName());
        txtItemUnit.setText(dto.getUnit());
        txtItemPrice.setText(String.valueOf(dto.getPrice()));
        cbSupplying.setSelected(dto.isSupplying());
        String supplierName = findSupplierByCode(dto.getSuppCode()).getSuppName();
        cbSuppliers.setSelectedItem(dto.getSuppCode() + "-" + supplierName);
    }//GEN-LAST:event_tblItemsMouseClicked




    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ItemManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox btnCheckCola;
    private javax.swing.JButton btnItemClear;
    private javax.swing.JButton btnItemCreate;
    private javax.swing.JButton btnItemRemove;
    private javax.swing.JButton btnItemUpdate;
    private javax.swing.JButton btnSuppClear;
    private javax.swing.JButton btnSuppCreate;
    private javax.swing.JButton btnSuppRemove;
    private javax.swing.JButton btnSuppUpdate;
    private javax.swing.JComboBox<String> cbSuppliers;
    private javax.swing.JCheckBox cbSupplying;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblItems;
    private javax.swing.JTable tblSuppliers;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemPrice;
    private javax.swing.JTextField txtItemUnit;
    private javax.swing.JTextField txtSupAddr;
    private javax.swing.JTextField txtSupCode;
    private javax.swing.JTextField txtSupName;
    // End of variables declaration//GEN-END:variables
}
