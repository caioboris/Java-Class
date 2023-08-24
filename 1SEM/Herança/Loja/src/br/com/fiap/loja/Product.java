package br.com.fiap.loja;

public class Product {

    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getProductType() {
        return this.getClass().getSimpleName();
    }

    public String getInfo() {
        String dados =  String.format("[%s] %s (%d): %.2f - ",
                getProductType(),
                name,
                quantity,
                price);
        if(isLowOfStock()) dados = "{ !!LOW OF STOCK!! }" + dados;

        return dados;        
    };

    public double getMinPrice(){
        return price;
    }

    public boolean isLowOfStock(){
        return quantity < 5;
    }

    @Override
    public String toString(){
        return getInfo();
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
