package controller;

import dao.TransactionDao;
import entity.Transaction;
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
        view.getConvertButton().setOnAction(event -> {
            try {
                double amount = Double.parseDouble(view.getAmountField().getText());
                Currency source = view.getSourceCurrencyBox().getValue();
                Currency target = view.getTargetCurrencyBox().getValue();

                if (source == null || target == null) {
                    view.getResultField().setText("Select currencies");
                    return;
                }

                double result = amount * target.getRateToUSD() / source.getRateToUSD();
                view.getResultField().setText(String.format("%.2f", result));

                Transaction transaction = new Transaction(amount, source, target);
                new TransactionDao().saveTransaction(transaction);

                System.out.println("Transaction saved!");

            } catch (NumberFormatException e) {
                view.getResultField().setText("Invalid amount");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
