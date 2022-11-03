package shopApp;

import entity.BookProduct;
import entity.Buyer;
import entity.HistoryBuy;
import entity.Product;
import entity.Shop;
import managers.BookProductManager;
import managers.BuyerManager;
import managers.HistoryBuyManager;
import managers.ShopManagers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    private final Scanner scanner;
    private Buyer[] buyers;

    private Shop[] shops;

    private Product[] products;
    private HistoryBuy[] historyBuys;
    private final BuyerManager buyerManager;
    private final BookProductManager bookProductManager;
    private final HistoryBuyManager historyBuyManager;

    private final ShopManagers shopManagers;

    private final BookProduct bookProduct;
    private HistoryBuy historyBuy;

    public App(){
        scanner = new Scanner(System.in);
        buyers = new Buyer[0];
        products = new Product[0];
        historyBuys = new HistoryBuy[0];
        buyerManager = new BuyerManager();
        bookProductManager = new BookProductManager();
        historyBuyManager = new HistoryBuyManager();
        bookProduct = new BookProduct();
        shopManagers = new ShopManagers();
        shops = new Shop[0];
    }

    public void run() throws IOException {
        boolean repeat = true;
        do {
            System.out.println("");
            System.out.println("================= Задачи ===================");
            System.out.println("");
            System.out.println("===> (0)     Выйти из програм       (0) <===");
            System.out.println("===> (1)     Добавить продукт       (1) <===");
            System.out.println("===> (2)    Добавить покупателя     (2) <===");
            System.out.println("===> (3)     Список продуктов       (3) <===");
            System.out.println("===> (4)    Список покупателей      (4) <===");
            System.out.println("===> (5)      Купить товар          (5) <===");
            System.out.println("===> (6) История покупок в магазине (6) <===");
            System.out.println("===> (7)     Пополнить счет         (7) <===");
            System.out.println("===> (8)    Посмотреть баланс       (8) <===");
            System.out.println("===> (9)  Изменить данные о товаре  (9) <===");
            System.out.println("===> (10)    Удаление продукта     (10) <===");
            System.out.println("===> (11)    Прибыль магазина      (11) <===");

            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
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
                    bookProductManager.printListBookProduct();
                    break;
                case 4:
                    System.out.println("4. Список покупателей");
                    buyerManager.printListBuyer();
                    break;
                case 5:
                    System.out.println("5. Купить товар");
                    historyBuyManager.BuyProduct(products, buyers);
                    addCashShop(shopManagers.createShopList());
                    addHistoryShop(historyBuyManager.createStoryList(products,buyers));
                    break;
                case 6:
                    System.out.println("6. История покупок в магазине");
                    historyBuyManager.printHistoryBuys();
                    break;
                case 7:
                    System.out.println("7. Пополнить счет");
                    buyerManager.Refill(buyers);
                    break;
                case 8:
                    System.out.println("8. Посмотреть баланс");
                    buyerManager.PrintCash(buyers);
                    break;
                case 9:
                    System.out.println("9. Изменить данные о товаре");
                    bookProductManager.ProductChange(products);
                    break;
                case 10:
                    System.out.println("10. Удаление продукта");
                    bookProduct.removeProduct();
                    break;
                case 11:
                    System.out.println("11. Прибыль магазина");
                    shopManagers.ShopCashList(shops);

            }


        } while (repeat);
        System.out.println("============> Закрытие программы, пока! <================");

    }
    private void addProduct(Product product){
        this.products = Arrays.copyOf(this.products, this.products.length + 1);
        this.products[this.products.length  - 1] = product;

    }

    private void addBuyer(Buyer buyer){
        this.buyers = Arrays.copyOf(this.buyers, this.buyers.length + 1);
        this.buyers[this.buyers.length  - 1] = buyer;
    }
    private void addCashShop(Shop shop){
        this.shops = Arrays.copyOf(this.shops, this.shops.length + 1);
        this.shops[this.shops.length  - 1] = shop;
    }

    private void addHistoryShop(HistoryBuy historyBuy){
        this.historyBuys = Arrays.copyOf(this.historyBuys, this.historyBuys.length + 1);
        this.historyBuys[this.historyBuys.length  - 1] = historyBuy;
    }


}
