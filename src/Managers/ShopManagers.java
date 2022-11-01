package Managers;


import Entity.Product;
import Entity.Shop;


public class ShopManagers {

    public Shop createShopList() {
        int SummaProduct = HistoryBuyManager.TotalSumma;
        Shop shop = ShopCashEveryTime(SummaProduct);
        return shop;
    }

    public Shop ShopCashEveryTime(int SummaProduct){
        Shop shop = new Shop();
        shop.setCashShop(SummaProduct);
        return shop;
    }

    public void ShopCashList(Shop[] shops) {
        for (int i = 0; i < shops.length; i++) {
            System.out.printf("%d. Прибыль магазина c покупателя: %s%n"
                    , i + 1
                    , shops[i].getCashShop());
        }
        int sum = 0;
        for (int i = 0; i < shops.length; i++) {
            sum = sum + shops[i].getCashShop();

        }
        System.out.print("Общая прибыль магазина: " + sum);

        System.out.println();
    }

}
