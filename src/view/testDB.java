package view;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;


/**
 *
 * @author default
 */
public class testDB {
  public static void main(String[] args) {
      Connection con = DBconnert.getdataUSER();
      if(con!=null){
          System.out.println("thanh cong");
      }else{
          System.out.println("that bai");
      }
  }
  
}