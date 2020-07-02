/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DEVON
 */
public class Menu {
    
    private Integer Id_menu;
    private Jenis Jenis;
    private Kategori Kategori;
    private String Nama_menu;
    private Integer Harga;

    public Integer getId_barang() {
        return Id_menu;
    }

    public void setId_barang(Integer Id_menu) {
        this.Id_menu = Id_menu;
    }

    public Jenis getJenis() {
        return Jenis;
    }

    public void setJenis(Jenis Jenis) {
        this.Jenis = Jenis;
    }

    public Kategori getKategori() {
        return Kategori;
    }

    public void setKategori(Kategori Kategori) {
        this.Kategori = Kategori;
    }

    public String getNama_menu() {
        return Nama_menu;
    }

    public void setNama_menu(String Nama_menu) {
        this.Nama_menu = Nama_menu;
    }

    public Integer getHarga() {
        return Harga;
    }

    public void setHarga(Integer Harga) {
        this.Harga = Harga;
    }

    public String getId_menu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
