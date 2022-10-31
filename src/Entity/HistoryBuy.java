package Entity;

import java.util.Date;

public class HistoryBuy {

    private Product product;
    private Buyer buyer;
    private Date BuyOnProduct;

    public HistoryBuy() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    @Override
    public String toString() {
        return "HistoryBuy{" +
                "product=" + product +
                ", buyer=" + buyer +
                ", BuyOnProduct=" + BuyOnProduct +
                '}';
    }
}