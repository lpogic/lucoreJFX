package javafx.lucore.pane;

import javafx.lucore.OpenRoot;
import javafx.lucore.scene.OpenScene;
import javafx.lucore.shop.Shop;
import javafx.lucore.stage.OpenStage;

public abstract class OpenSceneScion {

    private Object id;
    private OpenScene scene;

    OpenSceneScion(Object id, OpenScene openScene) {
        this(id);
        setLineage(openScene);
    }

    OpenSceneScion(Object id) {
        this.id = id;
    }

    void setLineage(OpenScene openScene){
        this.scene = openScene;
    }

    public Object getId() {
        return id;
    }

    protected void setId(Object id) {
        this.id = id;
    }

    public OpenRoot root() {
        return scene.root();
    }

    public OpenStage stage(){
        return scene.stage();
    }

    public OpenScene scene(){
        return scene;
    }

    protected Shop shop(){return root().getShop();}

}
