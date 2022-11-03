package entity;


public class Shop {

    private int cashShop;


    public int getCashShop() {
        return cashShop;
    }


    public void setCashShop(int cashShop) {
        this.cashShop = cashShop;
    }







    @Override
    public String toString() {
        return "Shop{" +
                "cashShop=" + cashShop +
                '}';
    }
}
