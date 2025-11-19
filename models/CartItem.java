package com.vcube.models;
public class CartItem {
    private Book book;
    private int qty;
    public CartItem(Book book, int qty){ this.book=book; this.qty=qty; }
    public Book getBook(){ return book; }
    public int getQty(){ return qty; }
}
