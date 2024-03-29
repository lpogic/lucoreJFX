package javafx.lucore;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.lucore.shop.OpenDealer;
import javafx.lucore.shop.Shop;
import javafx.lucore.stage.OpenStage;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class OpenRoot extends Application {
    public final String fxmlPrePath = "/palma/fxml/";
    public final String fxmlPostPath = ".fxml";

    private Map<Object, OpenStage> stages;
    private Shop shop;
    private Stage primaryStage;

    @Override
    public void init() {
        stages = new HashMap<>();
        shop = new Shop();
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        employ(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public abstract void employ(Stage primaryStage);

    public OpenStage openStage(Object key){
        OpenStage openStage = stages.get(key);
        if(openStage == null) {
            openStage = key instanceof Stage ?
                    new OpenStage(key, this, (Stage) key) :
                    new OpenStage(key, this, new Stage());
            stages.put(key, openStage);
        }
        return openStage;
    }

    public boolean collectStage(Object key) {
        OpenStage openStage = stages.get(key);
        if(openStage != null) {
            if (openStage.getStage() == primaryStage){
                return exitDialog();
            }
            else openStage.getStage().close();
        }
        return true;
    }

    public URL getResource(String forPath){
        return getClass().getResource(forPath);
    }

    public URL getFxmlResource(String fxml){return getResource(fxmlPrePath + fxml + fxmlPostPath);}

    public boolean exitDialog(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konczenie pracy");
        alert.setHeaderText("Czy napewno chcesz wyjsc z programu?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            Platform.exit();
            return true;
        }
        return false;
    }

    public void popUpStage(String fxml){
        openStage(new Stage()).openScene(fxml).show();
    }

    public Shop getShop() {
        return shop;
    }

    public OpenDealer openDealer(OpenDealer openDealer){
        return openDealer;
    }
}
