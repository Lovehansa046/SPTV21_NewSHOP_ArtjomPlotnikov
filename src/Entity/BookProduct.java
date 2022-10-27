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

    public BookProduct() {
        products = new Product[0];
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
                "scanner=" + scanner +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
