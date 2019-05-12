package javafx.lucore.shop.contract.stamp;

import javafx.lucore.shop.Product;

public class ServiceStamp implements Stamp {

    @Override
    public Object seal(Product product, boolean spend) {
        return product.imp();
    }
}
