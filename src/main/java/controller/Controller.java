package controller;

import javafx.scene.control.Alert;
import model.Currency;
import model.CurrencyModel;
import view.CurrencyConverterView;

public class Controller {
    private CurrencyModel model;
    private CurrencyConverterView view;

    public Controller(CurrencyModel model, CurrencyConverterView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getConvertButton().setOnAction(e -> {
            try {
                double amount = Double.parseDouble(view.getAmountField().getText());

                Currency from = view.getSourceCurrencyBox().getValue();
                Currency to = view.getTargetCurrencyBox().getValue();

                if (from == null || to == null) {
                    showError("Please select both source and target currencies.");
                    return;
                }

                double result = model.convert(amount, from, to);
                view.getResultField().setText(String.format("%.2f", result));
            } catch (NumberFormatException ex) {
                showError("Invalid amount. Please enter a numeric value.");
            }
        });
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
