/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hung;

/**
 *
 * @author admin
 */
public class Model_Loai {
    private int id_LSP ;
   private String ten_LSP ;
   private String mo_ta ;

    public Model_Loai() {
    }

    public Model_Loai(int id_LSP, String ten_LSP, String mo_ta) {
        this.id_LSP = id_LSP;
        this.ten_LSP = ten_LSP;
        this.mo_ta = mo_ta;
    }

    public int getId_LSP() {
        return id_LSP;
    }

    public void setId_LSP(int id_LSP) {
        this.id_LSP = id_LSP;
    }

    public String getTen_LSP() {
        return ten_LSP;
    }

    public void setTen_LSP(String ten_LSP) {
        this.ten_LSP = ten_LSP;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }
     public Object[] toDataRow() {
        return new Object[]{id_LSP, ten_LSP, mo_ta};
    }
  
   
   
}
