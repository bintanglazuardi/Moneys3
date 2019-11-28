package com.kuliah.komsi.moneys3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Transaksi implements Parcelable {
    private String nama;
    private String nominal;
    private String tanggal;
    private String kategori;
    private String catatan;

    public Transaksi(String nama, String nominal, String tanggal, String kategori, String catatan){
        this.nama = nama;
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.kategori = kategori;
        this.catatan = catatan;
    }

    protected Transaksi(Parcel in) {
        nama = in.readString();
        nominal = in.readString();
        tanggal = in.readString();
        kategori = in.readString();
        catatan = in.readString();
    }

    public static final Creator<Transaksi> CREATOR = new Creator<Transaksi>() {
        @Override
        public Transaksi createFromParcel(Parcel in) {
            return new Transaksi(in);
        }

        @Override
        public Transaksi[] newArray(int size) {
            return new Transaksi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(nominal);
        parcel.writeString(tanggal);
        parcel.writeString(kategori);
        parcel.writeString(catatan);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    @NonNull
    @Override
    public String toString() {
        return "Transaksi{" +
                "nama='" + nama + '\'' +
                ", nominal='" + nominal + '\'' +
                ", tanggal='" + tanggal + '\'' +
                ", kategori='" + kategori + '\'' +
                ", catatan='" + catatan + '\'' +
                '}';
    }
}
