package entity;

import java.util.Arrays;
import java.util.Scanner;


public class BookProduct {

    private final Scanner scanner;
    Product[] products;

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public BookProduct() {
        products = new Product[0];
        scanner = new Scanner(System.in);
    }


    public void removeProduct(){
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. Название продукта: %s Количество: %s Цена продукта: %s%n"
                    , i + 1
                    , products[i].getTitle()
                    , products[i].getQuantity()
                    , products[i].getPrice());
        }
        System.out.print("Введите номер продукта который надо удалить: ");
        int numberDeleteProduct = scanner.nextInt(); scanner.nextLine();
        this.getProducts()[numberDeleteProduct-1]=null;
        //создаем массив с количеством элементов на 1 меньше
        Product[] newProduct = new Product[this.getProducts().length-1];
        // в цикле копируем элементы в новый массив не учитывая обнуленную ячейку
        int j = 0;
        for (Product product : this.getProducts()) {
            if (product != null) {
                newProduct[j] = product;
                j++;
            }
        }
        //копируем ссылку на новый массив в книгу
        this.setProducts(newProduct);
    }

    @Override
    public String toString() {
        return "BookProduct{" +
                "scanner=" + scanner +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
