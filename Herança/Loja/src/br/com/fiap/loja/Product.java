package br.com.fiap.loja;

public class Product {

    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void getProductType(){
        System.out.println(this.getClass().getSimpleName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
