/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import model.Kategori;
import model.Login;
import model.Jenis;
import model.Menu;
import model.Transaksi_Pesan;

/**
 *
 * @author DEVON
 */

public class Transaksi {

    Koneksi koneksi;
    ArrayList<Login> arrLogin;
    ArrayList<Menu> arrMenu;
    ArrayList<Transaksi_Pesan> arrTransaksi;

    public Transaksi() throws SQLException {

        this.koneksi = new Koneksi();
        this.arrLogin = new ArrayList<>();
        this.arrMenu = new ArrayList<>();
        this.arrTransaksi = new ArrayList<>();

    }

    public ArrayList<Menu> getDataBarang() throws SQLException {

        this.arrMenu.clear();
        ResultSet rs = this.koneksi.getData("select * from menu_06969 join kategori_06969 on menu_06969.id_kategori = kategori_06969.id_kategori join jenis_06969 on jenis_06969.id_jenis = menu_06969.id_jenis");
        while (rs.next()) {

            Jenis jenis = new Jenis();
            jenis.setId_jenis(rs.getInt("id_jenis"));
            jenis.setNama_Perusahaan(rs.getString("nama_jenis"));
            
            Kategori kategori = new Kategori();
            kategori.setId_Kategori(rs.getInt("id_kategori"));
            kategori.setNama_Kategori(rs.getString("nama_kategori"));

            Menu menu = new Menu();
            menu.setId_barang(rs.getInt("id_menu"));
            menu.setJenis(jenis);
            menu.setKategori(kategori);
            menu.setNama_menu(rs.getString("nama_menu"));
            menu.setHarga(rs.getInt("harga"));
            this.arrMenu.add(menu);
        }

        return this.arrMenu;

    }

    public ArrayList<Login> getDataLogin() throws SQLException {

        this.arrLogin.clear();

        ResultSet rs = this.koneksi.getData("select * from login_06969");

        while (rs.next()) {

            Login login = new Login();
            login.setId_login(rs.getInt("id_login"));
            login.setUsername(rs.getNString("username"));
            login.setPassword(rs.getNString("password"));

            this.arrLogin.add(login);

        }

        return this.arrLogin;

    }

    public ArrayList<Transaksi_Pesan> getDataPemesanan() throws SQLException {

        this.arrTransaksi.clear();

        ResultSet rs = this.koneksi.getData("select login_06969.username, login_06969.password, transaksi_06969.*,login_06969.* from transaksi_06969 join login_06969 on transaksi_06969.id_login = login_06969.id_login joint Menu_06969 on transaksi_06969.id_menu = menu_06969.id_menu "
                + "join kategori_06969 on menu_06969.id_kategori = kategori_06969.id_kategori join jenis_06969 on jenis_06969.id_jenis = menu_06969.id_jenis order by transaksi_06969.id_transaksi desc");
        while (rs.next()) {

            Login login = new Login();
            login.setId_login(rs.getInt("id_login"));
            login.setUsername(rs.getNString("username"));
            login.setPassword(rs.getNString("password"));
            
            Jenis jenis = new Jenis();
            jenis.setId_jenis(rs.getInt("id_jenis"));
            jenis.setNama_Perusahaan(rs.getString("nama_jenis"));
            
            Kategori kategori = new Kategori();
            kategori.setId_Kategori(rs.getInt("id_kategori"));
            kategori.setNama_Kategori(rs.getString("nama_kategori"));

            Menu menu = new Menu();
            menu.setId_barang(rs.getInt("id_menu"));
            menu.setJenis(jenis);
            menu.setKategori(kategori);
            menu.setNama_menu(rs.getString("nama_menu"));
            menu.setHarga(rs.getInt("harga"));

            Transaksi_Pesan pemesanan = new Transaksi_Pesan();
            pemesanan.setId_transaksi(rs.getInt("id_transaksi"));
            pemesanan.setLogin(login);
            pemesanan.setMenu(menu);
            pemesanan.setTanggal_transaksi(rs.getDate("tanggal_transaksi"));
            pemesanan.setJumlah_pesanan(rs.getInt("Jumlah_pesanan"));
            pemesanan.setTotal(rs.getDouble("total"));

            this.arrTransaksi.add(pemesanan);
        }

        return this.arrTransaksi;
    }

    public void insertTransaksi(model.Transaksi_Pesan pemesanan) {

        try {

            String datePemesanan = new SimpleDateFormat("dd/MM/yyyy").format(pemesanan.getTanggal_transaksi());
            this.koneksi.ManipulasiData("INSERT INTO TRANSAKSI_06969\n"
                    + "(ID_TRANSAKSI, ID_LOGIN, ID_BARANG, TANGGAL_TRANSAKSI, JUM_BARANG, HARGA_TOTAL)\n"
                    + "VALUES(ID_TRANSAKSI.NEXTVAL, " + pemesanan.getLogin().getId_login() + ", " + pemesanan.getMenu().getId_menu() + ", TO_DATE('" + datePemesanan + "','dd/MM/yyyy'),'" + pemesanan.getJumlah_pesanan() + "', " + pemesanan.getTotal().toString() + ")");
            ResultSet rsp = this.koneksi.getData("select id_transaksi.currval from dual");
            rsp.next();
            int id_transaksi = rsp.getInt("currval");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Object getDataMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
