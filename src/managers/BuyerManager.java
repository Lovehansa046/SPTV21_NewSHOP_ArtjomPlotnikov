package managers;

import entity.Buyer;

import java.util.Scanner;

public class BuyerManager {

    Scanner scanner;


    public BuyerManager() {
        scanner = new Scanner(System.in);
    }

    public Buyer newBuyer() {
        Buyer buyer = new Buyer();
        System.out.print("Введите имя покупателя: ");
        buyer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию покупателя: ");
        buyer.setLastname(scanner.nextLine());
        System.out.print("Введите телефон покупателя: ");
        buyer.setPhone(scanner.nextLine());
        return buyer;
    }

    public void printListBuyer(Buyer[] buyers) {
        for (int i = 0; i < buyers.length; i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    , i + 1
                    , buyers[i].getFirstname()
                    , buyers[i].getLastname()
                    , buyers[i].getPhone());
        }
    }

    public void Refill(Buyer[] buyers) {
        System.out.println("=====================================");
        System.out.println("Выберите покупателя для зачисления на его счет денежных средств");
        System.out.println("=====================================");
        System.out.println("Список покупателей");
        System.out.println("=====================================");
        for (int i = 0; i < buyers.length; i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    , i + 1
                    , buyers[i].getFirstname()
                    , buyers[i].getLastname()
                    , buyers[i].getPhone());
        }
        System.out.print("Введите индекс покупателя: ");
        int buyer = scanner.nextInt(); scanner.nextLine();
        System.out.print("Сколько денег желаете добавить на счет? : ");
        int addMoney = scanner.nextInt(); scanner.nextLine();
        int TotalMoney = buyers[buyer - 1].getCash() + addMoney;
        buyers[buyer - 1].setCash(TotalMoney);
        System.out.println("=====================================");
        System.out.println("Счет пополнен!");
        System.out.println("=====================================");
        System.out.println("На счету на данный момент: " + buyers[buyer - 1].getCash());
        System.out.println("=====================================");

    }
    public void PrintCash(Buyer[] buyers){
        System.out.println("список покупателей");
        for (int i = 0; i < buyers.length; i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    , i + 1
                    , buyers[i].getFirstname()
                    , buyers[i].getLastname()
                    , buyers[i].getPhone());
        }
        System.out.print("Введите индекс покупателя, чтобы посмотреть его баланс: ");
        int balans = scanner.nextInt(); scanner.nextLine();
        int printCash = buyers[balans-1].getCash();
        System.out.println("=====================================");
        System.out.println("Баланс данного покупателя: " + printCash);
        System.out.println("=====================================");
    }
}