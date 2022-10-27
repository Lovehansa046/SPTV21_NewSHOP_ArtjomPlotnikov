package Managers;

import Entity.Product;

import java.util.Scanner;

public class BookProductManager {

    Scanner scanner;

    public BookProductManager() {
        scanner = new Scanner(System.in);
    }

    public Product createBookProduct(){
        System.out.print("Введите название продукта: ");
        String productName = scanner.nextLine();
        System.out.print("Введите количество продуктов: ");
        String quantity = scanner.nextLine();
        System.out.print("Введите цену продукта: ");
        String price = scanner.nextLine();
        Product product =createProduct(productName, Integer.parseInt(quantity), new Integer(price));
        return product;
    }

    public Product createProduct(String productName, int quantity, int price) {
        Product product = new Product();
        product.setTitle(productName);
        product.setQuantity(quantity);
        product.setPrice(price);
        return product;
    }

    public void printListBookProduct(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%s. Название продукта: %s \tКоличество: %s \tЦена продукта: %s"
                    ,i+1
                    ,products[i].getTitle()
                    ,products[i].getQuantity()
                    ,products[i].getPrice());
        }
        System.out.println();
    }
}
