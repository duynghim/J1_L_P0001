/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghiemtd.tbl_supplier;

import java.io.Serializable;

/**
 *
 * @author trndu
 */
public class SupplierDTO implements Serializable {
    private String suppCode;
    private String suppName;
    private String address;
    private boolean collaborating;

    public SupplierDTO(String suppCode, String suppName, String address, boolean collaborating) {
        this.suppCode = suppCode;
        this.suppName = suppName;
        this.address = address;
        this.collaborating = collaborating;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCollaborating() {
        return collaborating;
    }

    public void setCollaborating(boolean collaborating) {
        this.collaborating = collaborating;
    }
}
