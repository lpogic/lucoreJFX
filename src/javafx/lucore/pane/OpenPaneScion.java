package javafx.lucore.pane;

import javafx.lucore.OpenRoot;
import javafx.lucore.scene.OpenScene;
import javafx.lucore.shop.Shop;
import javafx.lucore.stage.OpenStage;

public abstract class OpenPaneScion {

    private OpenPane pane;

    OpenPaneScion(OpenPane openPane) {
        this();
        setLineage(openPane);
    }

    OpenPaneScion() {}

    void setLineage(OpenPane openPane){this.pane = openPane;}

    public OpenRoot root() {
        return pane.root();
    }

    public OpenStage stage(){
        return pane.stage();
    }

    public OpenScene scene(){
        return pane.scene();
    }

    public OpenPane pane(){
        return pane;
    }

    protected Shop shop(){return root().getShop();}
}
