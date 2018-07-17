/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mbek
 */
class Pasien {

    String JK, tinggi, berat, usia, hasil;

    public Pasien(String jenisk, String tinggi, String berat, String usia, String hasil) {

        this.JK = jenisk;
        this.tinggi = tinggi;
        this.berat = berat;
        this.usia = usia;
        this.hasil = hasil;
    }

    public String getJK() {
        return JK;
    }

    public void setJK(String JK) {
        this.JK = JK;
    }

    public String getTinggi() {
        return tinggi;
    }

    public void setTinggi(String tinggi) {
        this.tinggi = tinggi;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

}

public class TugasAI {

    public static Connection con;
    public static Statement stm;

    /**
     * @param args the command line arguments
     */
    ArrayList<Pasien> tampung;

    public TugasAI() {
        //instansiasi
        tampung = new ArrayList<Pasien>();
    }

    public void isiData(String jenisk, String tinggi, String berat, String usia, String hasil) {
        tampung.add(new Pasien(jenisk, tinggi, berat, usia, hasil));
    }

    public void hitung(String jenisk, String tinggi, String berat, String usia) {
        String url = "jdbc:mysql://localhost/databaseai";
        String user = "root";
        String pass = "";
        float jkhiper = 0, thiper=0, bhiper=0, uhiper=0, jkhipo=0, thipo=0, bhipo=0, uhipo=0 ,hipo =0,hiper =0,tot =0;
        System.out.println(jenisk+" - "+tinggi+" - "+berat+" - "+usia);
        String[] sql = new String[11];
        sql[0] = "SELECT COUNT(*) FROM data WHERE hasil='HIPERTENSI' AND JK='" + jenisk + "'";
        sql[1] = "SELECT COUNT(*) FROM data WHERE hasil='HIPOTENSI' AND JK='" + jenisk + "'";
        sql[2] = "SELECT COUNT(*) FROM data WHERE hasil='HIPERTENSI' AND tinggi='" + tinggi + "'";
        sql[3] = "SELECT COUNT(*) FROM data WHERE hasil='HIPOTENSI' AND tinggi='" + tinggi + "'";
        sql[4] = "SELECT COUNT(*) FROM data WHERE hasil='HIPERTENSI' AND berat='" + berat + "'";
        sql[5] = "SELECT COUNT(*) FROM data WHERE hasil='HIPOTENSI' AND berat='" + berat + "'";
        sql[6] = "SELECT COUNT(*) FROM data WHERE hasil='HIPERTENSI' AND usia='" + usia + "'";
        sql[7] = "SELECT COUNT(*) FROM data WHERE hasil='HIPOTENSI' AND usia='" + usia + "'";
        sql[8] = "SELECT COUNT(*) FROM data WHERE hasil='HIPERTENSI'";
        sql[9] = "SELECT COUNT(*) FROM data WHERE hasil='HIPOTENSI'";
        sql[10] = "SELECT COUNT(*) FROM data";
        try {
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, pass);
            com.mysql.jdbc.Statement start = (com.mysql.jdbc.Statement) conn.createStatement();
            int xy = 0;
            while (xy <= 10) {
                ResultSet rs = start.executeQuery(sql[xy]);
                switch (xy) {
                    case 0:
                        while (rs.next()) {
                            jkhiper = rs.getInt(1);
                        }
                    case 1:
                        while (rs.next()) {
                            jkhipo = rs.getInt(1);
                        }
                    case 2:
                        while (rs.next()) {
                            thiper = rs.getInt(1);
                        }
                    case 3:
                        while (rs.next()) {
                            thipo = rs.getInt(1);
                        }
                    case 4:
                        while (rs.next()) {
                            bhiper = rs.getInt(1);
                        }
                    case 5:
                        while (rs.next()) {
                            bhipo = rs.getInt(1);
                        }
                    case 6:
                        while (rs.next()) {
                            uhiper = rs.getInt(1);
                        }
                    case 7:
                        while (rs.next()) {
                            uhipo = rs.getInt(1);
                        }
                    case 8:
                        while (rs.next()) {
                            hiper = rs.getInt(1);
                        }
                    case 9:
                        while (rs.next()) {
                            hipo = rs.getInt(1);
                        }
                    case 10:
                        while (rs.next()) {
                            tot = rs.getInt(1);
                        }
                }
                xy = xy+1;
            }

        } catch (Exception e) {
            System.err.println("koneksi gagal" + e.getMessage());
        }
        System.out.println("Hipertensi = "+hiper/tot);
        System.out.println("Hipotensi = "+hipo/tot);
        System.out.println("");
        jkhiper = jkhiper/hiper;
        jkhipo = jkhipo/hipo;
        thiper = thiper/hiper;
        thipo = thipo/hipo;
        bhiper = bhiper/hiper;
        bhipo = bhipo/hipo;
        uhiper = uhiper/hiper;
        uhipo = uhipo/hipo;
        System.out.println("Jenis Kelamin "+jenisk+" dan hipertensi ="+jkhiper);
        System.out.println("Jenis Kelamin "+jenisk+" dan hipotensi ="+jkhipo);
        System.out.println(tinggi+" dan hipertensi ="+thiper);
        System.out.println(tinggi+" dan hipotensi ="+thipo);
        System.out.println(berat+" dan hipertensi ="+bhiper);
        System.out.println(berat+" dan hipotensi ="+bhipo);
        System.out.println(usia+" dan hipertensi ="+uhiper);
        System.out.println(usia+" dan hipotensi ="+uhipo);
        hiper = jkhiper*thiper*bhiper*uhiper;
        hipo = jkhipo*thipo*bhipo*uhipo;
        System.out.println("Hasil Hipertensi = "+hiper);
        System.out.println("Hasil Hipotensi = "+hipo);
        String hasil = "";
        if(hipo>hiper){
            hasil = "HIPOTENSI";
            System.out.println(hasil);
        }else{
            hasil = "HIPERTENSI";
            System.out.println(hasil);
        }
        try{
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, pass);
            com.mysql.jdbc.Statement start = (com.mysql.jdbc.Statement) conn.createStatement();
            start.executeUpdate("INSERT INTO data (JK,tinggi,berat,usia,hasil) VALUES('"+jenisk+"','"+tinggi+"','"+berat+"','"+usia+"','"+hasil+"')");
        } catch (Exception e) {
            System.err.println("koneksi gagal" + e.getMessage());
        }
    }

    public void tampil() {
        for (Pasien pasien : tampung) {
            System.out.print(pasien.getJK());
            System.out.print(" - ");
            System.out.print(pasien.getTinggi());
            System.out.print(" - ");
            System.out.print(pasien.getBerat());
            System.out.print(" - ");
            System.out.print(pasien.getUsia());
            System.out.print(" - ");
            System.out.println(pasien.getHasil());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String url = "jdbc:mysql://localhost/databaseai";
        String user = "root";
        String pass = "";
        TugasAI tugas = new TugasAI();
        try {
            com.mysql.jdbc.Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, pass);
            com.mysql.jdbc.Statement start = (com.mysql.jdbc.Statement) conn.createStatement();
            com.mysql.jdbc.Statement start2 = (com.mysql.jdbc.Statement) conn.createStatement();
            ResultSet rs = start.executeQuery("SELECT * FROM data");
            while (rs.next()) {
                tugas.isiData(rs.getString("JK"), rs.getString("tinggi"), rs.getString("berat"), rs.getString("usia"), rs.getString("hasil"));
            }
            tugas.tampil();

        } catch (Exception e) {
            System.err.println("koneksi gagal" + e.getMessage());
        }

        int loop = 0;
        String in1 = "", in2 = "", in3 = "", in4 = "", in5 = "";
        while (loop == 0) {
            System.out.print("Masukkan Jenis Kelamin(P/W) : ");
            String x = input.next();
            if (x.toUpperCase().equals("P") || x.toUpperCase().equals("W")) {
                in1 = x.toUpperCase();
                break;
            } else {
                System.out.println("Yang anda Masukkan salah!!");
            }
        }
        while (loop == 0) {

            System.out.print("Masukkan [Tinggi]/[Pendek] : ");
            String x = input.next();
            if (x.toUpperCase().equals("TINGGI") || x.toUpperCase().equals("PENDEK")) {
                in2 = x.toUpperCase();
                break;
            } else {
                System.out.println("Yang Anda Masukkan salah!!");
            }
        }
        while (loop == 0) {
            System.out.print("Masukkan [Berat]/[Ringan] : ");
            String x = input.next();
            if (x.toUpperCase().equals("BERAT") || x.toUpperCase().equals("RINGAN")) {
                in3 = x.toUpperCase();
                break;
            } else {
                System.out.println("Yang Anda Masukkan Salah!!");
            }
        }
        while (loop == 0) {
            System.out.print("Masukkan [Tua]/[Muda] : ");
            String x = input.next();
            if (x.toUpperCase().equals("TUA") || x.toUpperCase().equals("MUDA")) {
                in4 = x.toUpperCase();
                break;
            } else {
                System.out.println("Yang Anda Masukkan Salah!!");
            }
        }
        Pasien masuk = new Pasien(in1, in2, in3, in4, in5);
        tugas.hitung(in1, in2, in3, in4);
    }

}
