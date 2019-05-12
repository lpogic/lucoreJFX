package javafx.lucore.stage;

import javafx.lucore.OpenRoot;
import javafx.lucore.shop.Shop;

public abstract class OpenRootScion {

    private Object id;
    private OpenRoot root;

    OpenRootScion(Object id, OpenRoot openRoot) {
        this(id);
        setLineage(openRoot);
    }

    OpenRootScion(Object id) {
        this.id = id;
    }

    void setLineage(OpenRoot openRoot) {
        this.root = openRoot;
    }

    public Object getId() {
        return id;
    }

    protected void setId(Object id) {
        this.id = id;
    }

    public OpenRoot root() {
        return root;
    }

    protected Shop shop() {
        return root.getShop();
    }
}
