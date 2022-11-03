package entity;

import java.util.Date;

public class HistoryBuy {
    private Buyer buyer;
    private Date BuyOnProduct;

    public HistoryBuy() {
    }


    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getBuyOnProduct() {
        return BuyOnProduct;
    }

    public void setBuyOnProduct(Date buyOnProduct) {
        BuyOnProduct = buyOnProduct;
    }

    String HistoryProductName;
    String HistoryProductPrice;
    String HistoryProductQantity;
    String buyerNames;
    String buyerLastNames;
    String buyerPhones;

    public String getBuyerNames() {
        return buyerNames;
    }

    public void setBuyerNames(String buyerNames) {
        this.buyerNames = buyerNames;
    }

    public String getBuyerLastNames() {
        return buyerLastNames;
    }

    public void setBuyerLastNames(String buyerLastNames) {
        this.buyerLastNames = buyerLastNames;
    }

    public String getBuyerPhones() {
        return buyerPhones;
    }

    public void setBuyerPhones(String buyerPhones) {
        this.buyerPhones = buyerPhones;
    }

    public String getHistoryProductName() {
        return HistoryProductName;
    }

    public void setHistoryProductName(String historyProductName) {
        HistoryProductName = historyProductName;
    }

    public String getHistoryProductPrice() {
        return HistoryProductPrice;
    }

    public void setHistoryProductPrice(String historyProductPrice) {
        HistoryProductPrice = historyProductPrice;
    }

    public String getHistoryProductQantity() {
        return HistoryProductQantity;
    }

    public void setHistoryProductQantity(String historyProductQantity) {
        HistoryProductQantity = historyProductQantity;
    }

    @Override
    public String toString() {
        return "HistoryBuy{" +
                "buyer=" + buyer +
                ", BuyOnProduct=" + BuyOnProduct +
                ", HistoryProductName='" + HistoryProductName + '\'' +
                ", HistoryProductPrice='" + HistoryProductPrice + '\'' +
                ", HistoryProductQantity='" + HistoryProductQantity + '\'' +
                ", buyerName='" + buyerNames + '\'' +
                ", buyerLastName='" + buyerLastNames + '\'' +
                ", buyerPhone='" + buyerPhones + '\'' +
                '}';
    }

}