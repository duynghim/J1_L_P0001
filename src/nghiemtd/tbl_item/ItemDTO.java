/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghiemtd.tbl_item;

import java.io.Serializable;

/**
 *
 * @author trndu
 */
public class ItemDTO implements Serializable {
    private String itemCode;
    private String itemName;
    private String unit;
    private double price;
    private boolean supplying;
    private String suppCode;

    public ItemDTO(String itemCode, String itemName, String unit, double price, boolean supplying, String suppCode) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.price = price;
        this.supplying = supplying;
        this.suppCode = suppCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSupplying() {
        return supplying;
    }

    public void setSupplying(boolean supplying) {
        this.supplying = supplying;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }
}
