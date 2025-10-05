package dao;

import entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import entity.Currency;
import datasource.MariaDbConnection;
import java.sql.*;
import java.util.*;

public class CurrencyDao {
    private EntityManager em;

    public CurrencyDao() {
        em = Persistence.createEntityManagerFactory("currencyPU").createEntityManager();
    }

    public List<Currency> getAllCurrencies() {
        /*
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT abbreviation, name, rate_to_usd FROM Currency";
        List<Currency> currencies = new ArrayList<>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String abbreviation = rs.getString(1);
                String name = rs.getString(2);
                double rate = rs.getDouble(3);
                Currency currency = new Currency(abbreviation, name, rate);
                currencies.add(currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currencies;

         */
        return em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
    }

    public Currency getCurrency(String abbreviation) {
        /*
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT abbreviation, name, rate_to_usd FROM Currency WHERE abbreviation=?";
        Currency currency = null;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbreviation);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String abbr = rs.getString(1);
                String name = rs.getString(2);
                double rate = rs.getDouble(3);
                currency = new Currency(abbr, name, rate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currency;

         */
        return em.find(Currency.class, abbreviation);
    }

    public double getRate(String abbreviation) {
        /*
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT rate_to_usd FROM Currency WHERE abbreviation=?";
        double rate = 0.0;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbreviation);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rate = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rate;

         */
        Currency currency = em.find(Currency.class, abbreviation);
        return currency != null ? currency.getRateToUSD() : 0.0;
    }

    public void persist(Currency currency) {
        /*
        Connection conn = MariaDbConnection.getConnection();
        String sql = "INSERT INTO Currency (abbreviation, name, rate_to_usd) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, currency.getAbbreviation());
            ps.setString(2, currency.getName());
            ps.setDouble(3, currency.getRateToUSD());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }
}

