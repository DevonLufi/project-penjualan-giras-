/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DEVON
 */
public class Transaksi_Pesan {
    private Integer Id_transaksi;
    private Menu barang;
    private Login login;
    private Date Tanggal_transaksi;
    private Integer Jumlah_pesanan;
    private Double Total;
    private ArrayList<Transaksi_Pesan> arr_transaksi;
    private Menu menu;

    public Integer getId_transaksi() {
        return Id_transaksi;
    }

    public void setId_transaksi(Integer Id_transaksi) {
        this.Id_transaksi = Id_transaksi;
    }

    public Menu getMenu() {
        return barang;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Date getTanggal_transaksi() {
        return Tanggal_transaksi;
    }

    public void setTanggal_transaksi(Date Tanggal_transaksi) {
        this.Tanggal_transaksi = Tanggal_transaksi;
    }
    
    public Integer getJumlah_pesanan() {
        return Jumlah_pesanan;
    }

    public void setJumlah_pesanan(Integer Jumlah_pesanan) {
        this.Jumlah_pesanan = Jumlah_pesanan;
    }
    
    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public ArrayList<Transaksi_Pesan> getArr_transaksi() {
        return arr_transaksi;
    }

    public void setArrDetail_transaksi(ArrayList<Transaksi_Pesan> arr_transaksi) {
        this.arr_transaksi = arr_transaksi;
    }

  

   
    
    
}
