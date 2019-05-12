package javafx.lucore.shop.contract.stamp;

import javafx.lucore.shop.Product;

public interface Stamp {
    ServiceStamp SERVICE = new ServiceStamp();
    SupplyStamp SUPPLY = new SupplyStamp();
    WarrantyStamp WARRANTY = new WarrantyStamp();

    Object seal(Product product, boolean spend);
}
