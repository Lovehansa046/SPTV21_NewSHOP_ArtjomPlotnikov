package managers;

import entity.Product;

import java.util.Scanner;

public class BookProductManager {

    Scanner scanner;

    public BookProductManager() {
        scanner = new Scanner(System.in);
    }

    public Product createBookProduct() {
        System.out.print("Введите название продукта: ");
        String productName = scanner.nextLine();
        System.out.print("Введите количество продуктов: ");
        String quantity = scanner.nextLine();
        System.out.print("Введите цену продукта: ");
        String price = scanner.nextLine();
        Product product = createProduct(productName, Integer.parseInt(quantity), new Integer(price));
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
            System.out.printf("%d. Название продукта: %s Количество: %s Цена продукта: %s%n"
                    , i + 1
                    , products[i].getTitle()
                    , products[i].getQuantity()
                    , products[i].getPrice());
        }
        System.out.println("=====================================");
    }

    public void ProductChange(Product[] products) {
        printListBookProduct(products);
        System.out.print("Выберите номер продукта для редактирования: ");
        int ProductNumberValues = scanner.nextInt();scanner.nextLine();
        System.out.print("Наименование продукта: ");
        System.out.println(products[ProductNumberValues - 1].getTitle());
        System.out.print("Изменить название продукта ? (да/нет)");
        String edit = scanner.nextLine();
        if (edit.equals("да")) {
            System.out.print("Введите новое название продукта: ");
            products[ProductNumberValues - 1].setTitle(scanner.nextLine());
        }
        System.out.print("Изменить цену продукта: ");
        System.out.println(products[ProductNumberValues - 1].getPrice());
        System.out.print("Изменить цену продукта? (да/нет)");
        edit = scanner.nextLine();
        if (edit.equals("да")) {
            System.out.print("Введите новое цену продукта: ");
            products[ProductNumberValues - 1].setPrice(scanner.nextInt());
            scanner.nextLine();
        }
        System.out.print("Количество товара: ");
        System.out.println(products[ProductNumberValues - 1].getQuantity());
        System.out.print("Изменить количество данного товара на складе? (да/нет)");
        edit = scanner.nextLine();
        if (edit.equals("да")) {
            System.out.print("Введите другое количество книги: ");
            products[ProductNumberValues - 1].setQuantity(scanner.nextInt());
            scanner.nextLine();
        }
    }
}
