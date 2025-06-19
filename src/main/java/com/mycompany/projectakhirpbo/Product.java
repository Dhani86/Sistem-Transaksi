package com.mycompany.projectakhirpbo;

public class Product {
    private String nama;
    private double harga;

    public Product(String nama, double harga) {   //<<Constructor
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {       
        return nama; }
    
    public double getHarga() { 
        return harga; }
}