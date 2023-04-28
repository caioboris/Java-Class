package br.com.fiap.loja;

public class Book extends Product{

    public String author;

    public Book(String name, double price, String author){
        super(name,price);
        this.author = author;
    }

    @Override
    public String getInfo(){
        return super.getInfo() + author;
    }

    @Override
    public double getMinPrice(){
        return super.getMinPrice() * 0.8;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
