package javafx.lucore.shop.contract;

import javafx.lucore.shop.Product;
import javafx.lucore.shop.contract.stamp.Stamp;

public class SimpleContract implements Contract<Object> {

    private Stamp stamp;

    public SimpleContract(Stamp stamp) {
        this.stamp = stamp;
    }

    @Override
    public Object fetch(Product product, boolean spend) {
        return stamp.seal(product, spend);
    }
}
