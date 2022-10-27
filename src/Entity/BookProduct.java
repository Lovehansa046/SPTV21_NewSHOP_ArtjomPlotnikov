package Entity;

import java.util.Arrays;
import java.util.Scanner;

public class BookProduct {

    Scanner scanner;
    Product[] products;

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    public Product addProducts() {
        Product product = new Product();
        System.out.println("Введите название продукта");
        product.setTitle(scanner.nextLine());
        System.out.println("Введите цену продукта (целыми числами)");
        product.setPrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Количество товара");
        product.setQuantity(scanner.nextInt());
        scanner.nextLine();
        return product;
    }

    public BookProduct() {
        products = new Product[0];
    }
    public void addProduct(Product product){
        Product[] newProduct = Arrays.copyOf(products, products.length+1);
        newProduct[newProduct.length - 1] = product;
        products = newProduct;
    }

    public void removeProduct(int numberDeleteProduct){
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
                "products=" + Arrays.toString(products) +
                '}';
    }
}
