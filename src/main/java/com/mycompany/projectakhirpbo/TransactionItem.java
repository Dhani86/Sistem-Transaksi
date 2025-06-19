package com.mycompany.projectakhirpbo;  

public class TransactionItem {
    private Product product;
    private int quantity;

    public TransactionItem(Product product, int quantity) {     //<<Constructor
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalHarga() {                             
        return product.getHarga() * quantity;
    }

    public Product getProduct() { 
        return product; }
    
    public int getQuantity() { 
        return quantity; }
}