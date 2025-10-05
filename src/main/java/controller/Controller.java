package controller;

import dao.TransactionDao;
import entity.Transaction;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import entity.Currency;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CurrencyModel;
import view.CurrencyConverterView;
import dao.CurrencyDao;

import java.io.IOException;

public class Controller {
    @FXML
    private ListView<Currency> currencyListView;
    @FXML
    private TextField amountField;
    @FXML
    private TextField resultField;
    @FXML
    private ComboBox<Currency> sourceCurrencyBox;
    @FXML
    private ComboBox<Currency> targetCurrencyBox;

    private final CurrencyModel currencyModel;
    private final TransactionDao transactionDao;

    public Controller() {
        currencyModel = new CurrencyModel();
        transactionDao = new TransactionDao();
    }

    @FXML
    public void initialize() {
        loadCurrencies();
    }

    private void loadCurrencies() {
        try {
            currencyListView.setItems(FXCollections.observableArrayList(currencyModel.getCurrencies()));
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load currencies");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void onConvertClicked() {
        try {
            Currency selectedCurrency = currencyListView.getSelectionModel().getSelectedItem();
            if (selectedCurrency == null) {
                resultField.setText("Select a currency");
                return;
            }

            double amount = Double.parseDouble(amountField.getText());

            double result = amount * selectedCurrency.getRateToUSD();
            resultField.setText(String.format("%.2f", result));

            Transaction transaction = new Transaction(amount, selectedCurrency, selectedCurrency);
            transactionDao.saveTransaction(transaction);

        } catch (NumberFormatException e) {
            resultField.setText("Invalid amount");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Conversion failed");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    private void onAddCurrencyClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddCurrency.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Add New Currency");
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.showAndWait();

            sourceCurrencyBox.getItems().clear();
            targetCurrencyBox.getItems().clear();
            sourceCurrencyBox.getItems().addAll(currencyModel.getCurrencies());
            targetCurrencyBox.getItems().addAll(currencyModel.getCurrencies());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
