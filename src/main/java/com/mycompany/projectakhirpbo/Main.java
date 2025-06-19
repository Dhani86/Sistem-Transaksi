package com.mycompany.projectakhirpbo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer;
        
        System.out.println("=======SELAMAT DATANG DI TOKO ALAT TULIS SEJAHTERA=======");

        System.out.print("Masukkan nama pelanggan: ");
        String namaCustomer = scanner.nextLine();
        
        System.out.print("Apakah pelanggan member? (y/n): ");
        boolean isMember = scanner.nextLine().equalsIgnoreCase("y");
        customer = new Customer(namaCustomer, isMember);

        Transaction transaction = new Transaction(customer);

        System.out.println("\n=== Input Barang yang Dibeli ===");
        while (true) {
            System.out.print("Nama barang: ");
            String name = scanner.nextLine();

            System.out.print("Harga barang (Rp): ");
            double price = scanner.nextDouble();

            System.out.print("Jumlah beli: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); 

            Product product = new Product(name, price);
            transaction.addItem(product, quantity);

            System.out.print("Tambah barang lagi? (y/n): ");
            String pilihan = scanner.nextLine();
            if (!pilihan.equalsIgnoreCase("y")) break;
        }

        double total = transaction.getTotal();                       //<<Hitung Total
        double diskon = 0;
        if (customer.isMember()) {
            diskon = total * 0.1;
            System.out.printf("Diskon member 10%%: -Rp%.2f\n", diskon);
        }
        transaction.setDiskon(diskon);
        
        double totalSetelahDiskon = total - diskon;
            System.out.printf("Total: Rp%.2f\n", totalSetelahDiskon);
        

        double jumlahBayar;
        while (true) {
            System.out.print("Masukkan uang yang dibayarkan (Rp): ");
            jumlahBayar = scanner.nextDouble();
            if (jumlahBayar >= totalSetelahDiskon) break;
            System.out.println("Uang tidak cukup. Masukkan jumlah yang lebih besar.");
        }

        transaction.setJumlahBayar(jumlahBayar);
        System.out.println();
        transaction.strukBelanja();
    }
}