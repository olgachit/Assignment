package controller;

import entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCurrencyController {

    @FXML
    private TextField abbreviationField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField rateField;

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("currencyPU");

    @FXML
    private void onSaveClicked() {
        String abbr = abbreviationField.getText().trim();
        String name = nameField.getText().trim();
        double rate;

        try {
            rate = Double.parseDouble(rateField.getText().trim());
        } catch (NumberFormatException e) {
            showAlert("Invalid rate");
            return;
        }

        if (abbr.isEmpty() || name.isEmpty()) {
            showAlert("Abbreviation and Name cannot be empty");
            return;
        }

        Currency currency = new Currency(abbr, name, rate);

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(currency);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            showAlert("Failed to save currency: " + e.getMessage());
            return;
        } finally {
            em.close();
        }

        Stage stage = (Stage) abbreviationField.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
