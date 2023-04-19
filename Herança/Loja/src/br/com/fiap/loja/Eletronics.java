package br.com.fiap.loja;

public class Eletronics extends Product {

    public String model;
    public String brand;

    public Eletronics(String name, double price, String model, String brand){
        super(name, price);
        this.brand = brand;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void getInfo(){
        System.out.println("Product info\n [Name]: "+ this.name + " [Price]: " + this.price + " [Model]: "+ this.model + "[Brand]: "+ this.brand);
    }
}
