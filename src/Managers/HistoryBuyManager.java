package Managers;

import Entity.Buyer;
import Entity.HistoryBuy;
import Entity.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HistoryBuyManager {

    private final Scanner scanner;

    public static int TotalSumma;
    public static int Product;
    public static int Buyer;
    public static int QuantityProduct_final;
//    public static int[] HistoryProduct;

    public HistoryBuyManager() {
        scanner = new Scanner(System.in);
    }

    public void BuyProduct(Product[] products, Buyer[] buyers) {
        System.out.println(" Список покупателей: ");
        for (int i = 0; i < buyers.length; i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    , i + 1
                    , buyers[i].getFirstname()
                    , buyers[i].getLastname()
                    , buyers[i].getPhone());
        }
        System.out.print("Выберите покупателя: ");
//        int
        Buyer = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список продуктов: ");
        for (int j = 0; j < products.length; j++) {
            System.out.printf("%d. Название продукта: %s%n Количество: %s%n Цена продукта: %s%n"
                    , j + 1
                    , products[j].getTitle()
                    , products[j].getQuantity()
                    , products[j].getPrice());
        }
        System.out.println();
        System.out.print("Выберите товар: ");

//        int
        Product = scanner.nextInt(); scanner.nextLine();

        System.out.print("Выберите кол-во товара: ");

        int QuantityProduct = scanner.nextInt(); scanner.nextLine();
        int a = products[Product - 1].getQuantity();
        int b = products[Product - 1].getPrice();

        if (QuantityProduct <= a) {
            int TotalSummaProduct = b * QuantityProduct;
            if (TotalSummaProduct > buyers[Buyer - 1].getCash()) {
                System.out.println("У вас недостаточно средст для совершения данной покупки!");
            } else {
                int balance = buyers[Buyer - 1].getCash() - TotalSummaProduct;
                buyers[Buyer - 1].setCash(balance);
                int ark = products[Product - 1].getQuantity() - QuantityProduct;
                products[Product - 1].setQuantity(ark);
                TotalSumma = TotalSummaProduct;
                QuantityProduct_final = QuantityProduct;

                System.out.println("Остаток на счету: " + balance);
            }
        } else {
            System.out.println("На складе нет достаточного количества товара!");
        }


    }

    public void printListBuys(HistoryBuy[] historyBuys) {
        for (int i = 0; i < historyBuys.length; i++) {
            System.out.printf("%d. Название продукта: %s%n Цена продукта: %s%n Количество продукта: %s%n Данные покупателя: %s%n Дата покупки: %s%n"
                    , i + 1
                    , historyBuys[i].getHistoryProductName()
                    , historyBuys[i].getHistoryProductPrice()
                    , historyBuys[i].getHistoryProductQantity()
                    , historyBuys[i].getBuyer()
                    , historyBuys[i].getBuyOnProduct());
        }
        System.out.println();
    }

    public HistoryBuy createStoryList(Product[] products, Buyer[] buyers) throws IOException {

        String historyProduct = String.valueOf(products[Product-1].getTitle());

        HistoryBuy historyBuy = new HistoryBuy();
        historyBuy.setHistoryProductName(historyProduct);
        historyBuy.setHistoryProductPrice(String.valueOf(TotalSumma));
        historyBuy.setHistoryProductQantity(String.valueOf(QuantityProduct_final));
        historyBuy.setBuyer(buyers[Buyer - 1]);
        historyBuy.setBuyOnProduct(new GregorianCalendar().getTime());
        FileWriter fw = new FileWriter("История покупок.txt");
        fw.write("Название продукта: " + historyBuy.getHistoryProductName() + " - ");
        fw.write("Цена продукта: " + historyBuy.getHistoryProductPrice() + " - ");
        fw.write("Количество продукта: " + historyBuy.getHistoryProductQantity() + " - ");
        fw.write("Данные покупателя: " + (historyBuy.getBuyer()) + " - ");
        fw.write("Время покупки: " + (historyBuy.getBuyOnProduct()));
        fw.close();


        return historyBuy;
    }
}
