package backend;

import java.util.ArrayList;

public class Pemesanan {
    private Barang barang;
    private String status;
    private static ArrayList<Pemesanan> listPemesanan = new ArrayList<Pemesanan>();

    public Pemesanan(Barang barang, String status) {
        this.barang = barang;
        this.status = status;

        listPemesanan.add(this);
    }

    public Barang getBarang() {
        return barang;
    }

    public String getStatus() {
        return status;
    }

    public static ArrayList<Pemesanan> getListPemesanan(){
        return listPemesanan;
    }
 }