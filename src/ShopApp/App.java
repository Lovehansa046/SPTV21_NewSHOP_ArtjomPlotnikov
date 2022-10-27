package ShopApp;

import Entity.BookProduct;
import Entity.Buyer;
import Entity.HistoryBuy;
import Entity.Product;
import Managers.BookProductManager;
import Managers.BuyerManager;
import Managers.HistoryBuyManager;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    private final Scanner scanner;
    private Buyer[] buyers;

    private Product[] products;
    private final HistoryBuy[] historyBuys;
    private final BuyerManager buyerManager;
    private final BookProductManager bookProductManager;
    private final HistoryBuyManager historyBuyManager;

    public App(){
        scanner = new Scanner(System.in);
        buyers = new Buyer[0];
        products = new Product[0];
        historyBuys = new HistoryBuy[0];
        buyerManager = new BuyerManager();
        bookProductManager = new BookProductManager();
        historyBuyManager = new HistoryBuyManager();
    }

    public void run(){
        boolean repeat = true;
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить продукт");
            System.out.println("2. Добавить покупателя");
            System.out.println("3. Список продуктов");
            System.out.println("4. Список покупателей");
            System.out.println("5. Купить товар");
            System.out.println("6. История покупок в магазине");
            System.out.println("7. Пополнить счет");
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. Добавить продукт");
                    addProduct(bookProductManager.createBookProduct());
                    break;
                case 2:
                    System.out.println("2. Добавить покупателя");
                    addBuyer(buyerManager.newBuyer());
                    break;
                case 3:
                    System.out.println("3. Список продуктов");
                    bookProductManager.printListBookProduct(products);
                    break;
                case 4:
                    System.out.println("4. Список покупателей");
                    buyerManager.printListBuyer(buyers);
                    break;
                case 5:
                    System.out.println("5. Купить товар");
                    historyBuyManager.BuyProduct(products, buyers);
                    break;
                case 6:
                    System.out.println("6. История покупок в магазине");
                    historyBuyManager.printListBuys(historyBuys);
                    break;
                case 7:
                    System.out.println("7. Пополнить счет");
                    buyerManager.Refill(buyers);
                    break;

            }


        }while (repeat);
        System.out.println("");
    }
    private void addProduct(Product product){
        this.products = Arrays.copyOf(this.products, this.products.length + 1);
        this.products[this.products.length  - 1] = product;

    }

    private void addBuyer(Buyer buyer){
        this.buyers = Arrays.copyOf(this.buyers, this.buyers.length + 1);
        this.buyers[this.buyers.length  - 1] = buyer;
    }

}
