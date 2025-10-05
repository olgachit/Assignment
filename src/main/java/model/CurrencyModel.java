package model;

import entity.Currency;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static dao.TransactionDao.emf;

public class CurrencyModel {
    private List<Currency> currencies;

    public CurrencyModel() {
        currencies = new ArrayList<>();
        currencies.add(new Currency("USD", "US Dollar", 1.0));
        currencies.add(new Currency("EUR", "Euro", 0.93));
        currencies.add(new Currency("GBP", "British Pound", 0.82));
        currencies.add(new Currency("JPY", "Japanese Yen", 138.0));

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (Currency c : currencies) {
            if (em.find(Currency.class, c.getAbbreviation()) == null) {
                em.persist(c);
            }
        }
        em.getTransaction().commit();
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        double amountInUSD = amount / from.getRateToUSD();
        return amountInUSD * to.getRateToUSD();
    }
}