package model;

import entity.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {
    private List<Currency> currencies;

    public CurrencyModel() {
        currencies = new ArrayList<>();
        // Hardcoded currencies (initial development)
        currencies.add(new Currency("USD", "US Dollar", 1.0));
        currencies.add(new Currency("EUR", "Euro", 0.93));
        currencies.add(new Currency("GBP", "British Pound", 0.82));
        currencies.add(new Currency("JPY", "Japanese Yen", 138.0));
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        // Convert from source to USD, then USD to target
        double amountInUSD = amount / from.getRateToUSD();
        return amountInUSD * to.getRateToUSD();
    }
}