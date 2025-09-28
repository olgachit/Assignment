package view;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Currency;

import java.util.List;

public class CurrencyConverterView {
    private TextField amountField;
    private TextField resultField;
    private ComboBox<Currency> sourceCurrencyBox;
    private ComboBox<Currency> targetCurrencyBox;
    private Button convertButton;
    private Label instructions;

    public CurrencyConverterView(Stage stage, List<Currency> currencies) {
        stage.setTitle("Currency Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(15);
        grid.setHgap(10);

        instructions = new Label("Enter amount and select currencies, then click Convert.");
        instructions.setFont(Font.font("Sans-serif", 14));
        grid.add(instructions, 0, 0, 2, 1);

        Label amountLabel = new Label("Amount:");
        amountLabel.setFont(Font.font("Sans-serif", 14));
        amountField = new TextField();
        amountField.setPromptText("Enter numeric value");
        grid.add(amountLabel, 0, 1);
        grid.add(amountField, 1, 1);

        Label sourceLabel = new Label("From Currency:");
        sourceLabel.setFont(Font.font("Sans-serif", 14));
        sourceCurrencyBox = new ComboBox<>();
        sourceCurrencyBox.getItems().addAll(currencies);
        grid.add(sourceLabel, 0, 2);
        grid.add(sourceCurrencyBox, 1, 2);

        Label targetLabel = new Label("To Currency:");
        targetLabel.setFont(Font.font("Sans-serif", 14));
        targetCurrencyBox = new ComboBox<>();
        targetCurrencyBox.getItems().addAll(currencies);
        grid.add(targetLabel, 0, 3);
        grid.add(targetCurrencyBox, 1, 3);

        convertButton = new Button("Convert");
        grid.add(convertButton, 1, 4);

        Label resultLabel = new Label("Result:");
        resultLabel.setFont(Font.font("Sans-serif", 14));
        resultField = new TextField();
        resultField.setEditable(false);
        grid.add(resultLabel, 0, 5);
        grid.add(resultField, 1, 5);

        Scene scene = new Scene(grid, 400, 350);
        stage.setScene(scene);
        stage.show();
    }

    public TextField getAmountField() { return amountField; }
    public TextField getResultField() { return resultField; }
    public ComboBox<Currency> getSourceCurrencyBox() { return sourceCurrencyBox; }
    public ComboBox<Currency> getTargetCurrencyBox() { return targetCurrencyBox; }
    public Button getConvertButton() { return convertButton; }
    public Label getInstructions() { return instructions; }
}