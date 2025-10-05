package model;

import entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;



public class CurrencyModel {
    private List<Currency> currencies;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("currencyPU");

    public CurrencyModel() {
        currencies = new ArrayList<>();
        currencies.add(new Currency("USD", "US Dollar", 1.0));
        currencies.add(new Currency("EUR", "Euro", 0.93));
        currencies.add(new Currency("GBP", "British Pound", 0.82));
        currencies.add(new Currency("JPY", "Japanese Yen", 138.0));

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (Currency c : currencies) {
            em.persist(c);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Currency> getCurrencies() {
        EntityManager em = emf.createEntityManager();
        List<Currency> dbCurrencies = em.createQuery("SELECT c FROM Currency c", Currency.class)
                .getResultList();
        em.close();
        return dbCurrencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        double amountInUSD = amount / from.getRateToUSD();
        return amountInUSD * to.getRateToUSD();
    }
}