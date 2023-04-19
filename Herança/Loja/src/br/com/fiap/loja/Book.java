package br.com.fiap.loja;

public class Book extends Product{

    public String author;

    public Book(String name, double price, String author){
        super(name,price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        author = author;
    }

    public void getInfo(){
        System.out.println("Product info\n [Name]: "+ this.name + " [Price]: " + this.price + " [Author]: "+ this.author );
    }
}
