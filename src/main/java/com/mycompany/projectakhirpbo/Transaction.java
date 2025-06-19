package com.mycompany.projectakhirpbo;

import java.util.ArrayList;

public class Transaction {
    private Customer customer;
    private ArrayList<TransactionItem> items;
    private double jumlahBayar;

    public Transaction(Customer customer) {                     //<<Constructor
        this.customer = customer;
        this.items = new ArrayList<>();
        this.jumlahBayar = 0;
    }

    public void addItem(Product product, int quantity) {        //<<Menyimpan Daftar Nama dan Jumlah Barang
        items.add(new TransactionItem(product, quantity));
    }

    public void setJumlahBayar(double jumlahBayar) {            //<<Menyimpan Nominal Uang
        this.jumlahBayar = jumlahBayar;
    }

    public double getTotal() {                                  //<<Menghitung Nilai Total Belanja
        double total = 0;
        for (TransactionItem item : items) {
            total += item.getTotalHarga();
        }
        return total;
    }

    public void strukBelanja() {
        System.out.println("===== STRUK PEMBELANJAAN =====");
        System.out.println("Pelanggan: " + customer.getNama());
        System.out.println("------------------------------");

        for (TransactionItem item : items) {
            double subTotal = item.getTotalHarga();
            System.out.printf("%-15s x %d = Rp%.2f\n", item.getProduct().getNama(), item.getQuantity(), subTotal);
        }

        double total = getTotal();
        double kembalian = jumlahBayar - total;

        System.out.println("------------------------------");
        System.out.printf("TOTAL BAYAR  : Rp%.2f\n", total);
        System.out.printf("UANG DIBAYAR : Rp%.2f\n", jumlahBayar);
        System.out.printf("KEMBALIAN    : Rp%.2f\n", kembalian);
        System.out.println("Terima kasih telah berbelanja!");
    }
}