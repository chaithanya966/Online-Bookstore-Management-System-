package com.vcube.models;
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private int stock;
    private String description;
    public Book() {}
    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }
    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title=title; }
    public String getAuthor(){ return author; }
    public void setAuthor(String author){ this.author=author; }
    public double getPrice(){ return price; }
    public void setPrice(double price){ this.price=price; }
    public int getStock(){ return stock; }
    public void setStock(int stock){ this.stock=stock; }
    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description=description; }
}
