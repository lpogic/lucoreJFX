package javafx.lucore.shop.contract;

import javafx.lucore.shop.Product;
import javafx.lucore.shop.contract.stamp.Stamp;

public class ClassicContract<T> implements Contract<T> {

    private Class<T> brand;
    private Stamp stamp;

    public ClassicContract(Class<T> brand, Stamp stamp) {
        this.brand = brand;
        this.stamp = stamp;
    }

    Class<T> getBrand() {
        return brand;
    }

    @Override
    public T fetch(Product product, boolean spend) {
        return brand.cast(stamp.seal(product,spend));
    }
}
