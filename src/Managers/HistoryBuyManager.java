package Managers;

import Entity.Buyer;
import Entity.HistoryBuy;
import Entity.Product;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class HistoryBuyManager {

    Scanner scanner;
    public static int TotalSummaProduct;
    public static int balance;

    public HistoryBuyManager() {
        scanner = new Scanner(System.in);
    }

    public HistoryBuy BuyProduct(Product[] products, Buyer[] buyers) {
        System.out.println(" Список покупателей: ");
        for (int i = 0; i < buyers.length; i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    , i + 1
                    , buyers[i].getFirstname()
                    , buyers[i].getLastname()
                    , buyers[i].getPhone());
        }
        System.out.println("Выберите покупателя: ");
        int Buyer = scanner.nextInt();
        System.out.println("Список продуктов: ");
        for (int j = 0; j < products.length; j++) {
            System.out.printf("%s %s %s %s"
                    , j + 1
                    , products[j].getTitle()
                    , products[j].getQuantity()
                    , products[j].getPrice());
        }
        System.out.println("Выберите товар: ");
        int Product = scanner.nextInt();
        System.out.println("Выберите кол-во товара: ");
        int QuantityProduct = scanner.nextInt();
        int a = products[Product - 1].getQuantity();
        int b = products[Product - 1].getPrice();
        if (QuantityProduct > a) {
            System.out.println("На складе нет достаточного количества товара!");
        } else {
            TotalSummaProduct = b * QuantityProduct;
            int ark = products[Product - 1].getQuantity() - QuantityProduct;
            products[Product - 1].setQuantity(ark);
        }
        if (TotalSummaProduct > buyers[Buyer - 1].getCash()) {
            System.out.println("У вас недостаточно средст для совершения данной покупки!");
        } else {
            balance = buyers[Buyer - 1].getCash() - TotalSummaProduct;
            buyers[Buyer - 1].setCash(balance);
        }
        System.out.println("Остаток на счету" + balance);

        HistoryBuy historyBuy = new HistoryBuy();
        historyBuy.setProduct(products[Product - 1]);
        historyBuy.setBuyer(buyers[Buyer - 1]);
        historyBuy.setBuyOnProduct(new GregorianCalendar().getTime());
        return historyBuy;
    }

    public void printListBuys(HistoryBuy[] historyBuys) {
        for (int i = 0; i < historyBuys.length; i++) {
            System.out.printf("%s %s %s"
                    , historyBuys[i].getProduct()
                    , historyBuys[i].getBuyer()
                    , historyBuys[i].getBuyOnProduct());
        }
        System.out.println();
    }
}
