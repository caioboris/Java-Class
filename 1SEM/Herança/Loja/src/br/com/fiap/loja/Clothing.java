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

    @Override
    public String getInfo(){
        return super.getInfo() + color + size;
    }

    @Override
    public double getMinPrice(){
        if(isLowOfStock())
            return super.getMinPrice() * 0.7;
        return super.getMinPrice();
    }
}
