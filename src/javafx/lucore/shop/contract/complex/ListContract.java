package javafx.lucore.shop.contract.complex;

import javafx.lucore.shop.Product;
import javafx.lucore.shop.contract.Contract;
import javafx.lucore.shop.contract.stamp.Stamp;

import java.util.List;

public class ListContract<T> implements Contract<List<T>> {

    private Class<T> brand;
    private Stamp stamp;

    public ListContract(Class<T> brand, Stamp stamp) {
        this.brand = brand;
        this.stamp = stamp;
    }

    Class<T> getBrand() {
        return brand;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> fetch(Product product, boolean spend) {
        Object o = stamp.seal(product,spend);
        if(o instanceof List && ((List) o).stream().allMatch(getBrand()::isInstance)){
            return (List<T>)o;
        } else return null;
    }
}
