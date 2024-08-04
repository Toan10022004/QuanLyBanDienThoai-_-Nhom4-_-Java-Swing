/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import hung.Model_khachhang;

public class DataHolder {
    private static DataHolder instance;
    private Model_khachhang mdkh;

    private DataHolder() {}

    public static DataHolder getInstance() {
        if (instance == null) {
            instance = new DataHolder();
        }
        return instance;
    }

    public void setMdkh(Model_khachhang mdkh) {
        this.mdkh = mdkh;
    }

    public Model_khachhang getMdkh() {
        return mdkh;
    }
}
