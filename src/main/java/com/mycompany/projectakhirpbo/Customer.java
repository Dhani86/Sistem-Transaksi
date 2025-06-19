package com.mycompany.projectakhirpbo;

public class Customer {
    private String nama;
    private boolean isMember;

    public Customer(String nama, boolean isMember) {
        this.nama = nama;
        this.isMember = isMember;
    }

    public String getNama() { 
        return nama; 
    }
    
    public boolean isMember() {
        return isMember;
    }
}