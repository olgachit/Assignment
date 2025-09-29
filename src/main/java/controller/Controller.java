package controller;

import javafx.scene.control.Alert;
import entity.Currency;
import view.CurrencyConverterView;
import dao.CurrencyDao;

public class Controller {
    private CurrencyConverterView view;
    private final CurrencyDao dao = new CurrencyDao();

    public Controller(CurrencyConverterView view) {
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

                double fromRate = dao.getRate(from.getAbbreviation());
                double toRate = dao.getRate(to.getAbbreviation());
                double result = amount * (toRate / fromRate);
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
