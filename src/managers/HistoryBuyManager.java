package managers;

import entity.Buyer;
import entity.HistoryBuy;
import entity.Product;

import java.io.File;
import java.io.FileNotFoundException;
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
    String fileName = "История покупок.txt";




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
        Buyer = scanner.nextInt(); scanner.nextLine();

        System.out.println("=====================================");
        System.out.println("Список продуктов: ");
        for (int j = 0; j < products.length; j++) {
            System.out.printf("%d. Название продукта: %s%n Количество: %s%n Цена продукта: %s%n"
                    , j + 1
                    , products[j].getTitle()
                    , products[j].getQuantity()
                    , products[j].getPrice());
        }
        System.out.println("=====================================");
        System.out.print("Выберите товар: ");

        Product = scanner.nextInt(); scanner.nextLine();

        System.out.println("=====================================");
        System.out.print("Выберите кол-во товара: ");

        int quantityProduct = scanner.nextInt(); scanner.nextLine();
        int a = products[Product - 1].getQuantity();
        int b = products[Product - 1].getPrice();

        if (quantityProduct <= a) {
            int TotalSummaProduct = b * quantityProduct;
            if (TotalSummaProduct > buyers[Buyer - 1].getCash()) {

                System.out.println("=====================================");
                System.out.println("У вас недостаточно средст для совершения данной покупки!");
                System.out.println("=====================================");

            } else {
                int balance = buyers[Buyer - 1].getCash() - TotalSummaProduct;
                buyers[Buyer - 1].setCash(balance);
                int ark = products[Product - 1].getQuantity() - quantityProduct;
                products[Product - 1].setQuantity(ark);
                TotalSumma = TotalSummaProduct;
                QuantityProduct_final = quantityProduct;

                System.out.println("=====================================");
                System.out.println("Остаток на счету: " + balance);
                System.out.println("=====================================");
            }
        } else {

            System.out.println("=====================================");
            System.out.println("На складе нет достаточного количества товара!");
            System.out.println("=====================================");
        }


    }

    public void printHistoryBuys() throws FileNotFoundException {
        File doc = new File("История покупок.txt");
        Scanner obj = new Scanner(doc);

        while (obj.hasNextLine())
            System.out.println(obj.nextLine());

        System.out.println();
    }

    public HistoryBuy createStoryList(Product[] products, Buyer[] buyers) throws IOException {

        String historyProduct = String.valueOf(products[Product-1].getTitle());
        String historyBuyerName = (buyers[Buyer-1].getFirstname());
        String historyBuyerLastName = (buyers[Buyer-1].getLastname());
        String historyBuyerPhone = String.valueOf(buyers[Buyer-1].getPhone());


        HistoryBuy historyBuy = new HistoryBuy();
        historyBuy.setHistoryProductName(historyProduct);
        historyBuy.setHistoryProductPrice(String.valueOf(TotalSumma));
        historyBuy.setHistoryProductQantity(String.valueOf(QuantityProduct_final));
        historyBuy.setBuyer(buyers[Buyer-1]);
        historyBuy.setBuyerNames(historyBuyerName);
        historyBuy.setBuyerLastNames(historyBuyerLastName);
        historyBuy.setBuyerPhones(historyBuyerPhone);
        historyBuy.setBuyOnProduct(new GregorianCalendar().getTime());

        FileWriter line = new FileWriter(fileName, true);
        line.append("Название продукта: ").append(historyBuy.getHistoryProductName()).append(" - ");
        line.append("Цена продукта: ").append(historyBuy.getHistoryProductPrice()).append(" - ");
        line.append("Количество продукта: ").append(historyBuy.getHistoryProductQantity()).append(" - ");
        line.append("Данные покупателя: ").append(historyBuy.getBuyerNames()).append(' ').append(historyBuy.getBuyerLastNames()).append(" Номер телефона: ").append(historyBuy.getBuyerPhones()).append(" - ");
        line.append("Время покупки: ").append(String.valueOf(historyBuy.getBuyOnProduct()));
        line.append("\n");
        line.close();



        return historyBuy;
    }

}
