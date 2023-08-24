package br.com.fiap.loja;

public class App {

    public static void main(String[] args) {

        Clothing camisa = new Clothing("Shirt", 75.00, "Black", "M");
        Clothing bermuda = new Clothing("Shorts", 45.00, "Black", "M");
        Clothing blusa = new Clothing("Jacket", 75.00, "Black", "M");

        Eletronics celular = new Eletronics("Smartphone", 5000.00, "Iphone 13", "Apple");
        Eletronics tablet = new Eletronics("Tablet", 5000.00, "Ipad", "Apple");
        Eletronics relogio = new Eletronics("SmartWatch", 5000.00, "Apple Watch", "Apple");

        Book livro = new Book("Clean Code", 300.00, "Robert C. Martin");
        Book livro2 = new Book("Clean Architeture", 300.00, "Robert C. Martin");
        Book livro3 = new Book("Agile Software", 300.00, "Robert C. Martin");

        System.out.println(celular.getMinPrice());

    }





}
