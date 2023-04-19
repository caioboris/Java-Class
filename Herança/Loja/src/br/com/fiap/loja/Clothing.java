package br.com.fiap.loja;

public class Clothing extends Product{

    public String color;
    public String size;

    public Clothing(String name, double price, String color, String size){
        super(name,price);
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void getInfo(){
        System.out.println("Product info\n [Name]: "+ this.name + " [Price]: " + this.price + " [Color]: "+ this.color + " [Size]: " + this.size );
    }
}
