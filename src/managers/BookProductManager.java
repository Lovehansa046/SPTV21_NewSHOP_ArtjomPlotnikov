package managers;

import entity.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BookProductManager {

    Scanner scanner;
    File fileNames = new File("Список продуктов.txt");

    public BookProductManager() {
        scanner = new Scanner(System.in);
    }

    public Product createBookProduct() throws IOException {
        System.out.print("Введите название продукта: ");
        String productName = scanner.nextLine();
        System.out.print("Введите количество продуктов: ");
        String quantity = scanner.nextLine();
        System.out.print("Введите цену продукта: ");
        String price = scanner.nextLine();
        Product product = createProduct(productName, Integer.parseInt(quantity), new Integer(price));
        return product;
    }

    public Product createProduct(String productName, int quantity, int price) throws IOException {
        Product product = new Product();
        product.setTitle(productName);
        product.setQuantity(quantity);
        product.setPrice(price);

        FileWriter line = new FileWriter(fileNames, true);
        line.append("Название продукта: ").append(product.getTitle()).append(" - ");
        line.append("Цена продукта: ").append(String.valueOf(product.getQuantity())).append(" - ");
        line.append("Количество продукта: ").append(String.valueOf(product.getPrice()));
        line.append("\n");
        line.close();

        return product;
    }


    public void printListBookProduct() throws FileNotFoundException {

        System.out.println("=====================================");
        printFileProduct();
        System.out.println("=====================================");
    }

    public void printFileProduct() throws FileNotFoundException {
        File doc = new File("Список продуктов.txt");
        Scanner obj = new Scanner(doc);

        while (obj.hasNextLine())
            System.out.println(obj.nextLine());

        System.out.println();
    }


    public void ProductChange(Product[] products) {
        System.out.println("=====================================");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. Название продукта: %s Количество: %s Цена продукта: %s%n"
                    , i + 1
                    , products[i].getTitle()
                    , products[i].getQuantity()
                    , products[i].getPrice());
        }
        System.out.println("=====================================");
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
