import javafx.application.Application;
import javafx.stage.Stage;
import controller.Controller;
import model.CurrencyModel;
import view.CurrencyConverterView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        CurrencyModel model = new CurrencyModel();
        CurrencyConverterView view = new CurrencyConverterView(primaryStage, model.getCurrencies());
        new Controller(model, view);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

