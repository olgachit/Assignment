package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Currency {
    @Id
    private String abbreviation;
    private String name;
    @Column(name = "rate_to_usd")
    private double rateToUSD;

    public Currency(String abbreviation, String name, double rateToUSD) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    public Currency() {}

    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getRateToUSD() { return rateToUSD; }
    public void setRateToUSD(double rateToUSD) { this.rateToUSD = rateToUSD; }

    @Override
    public String toString() {
        return abbreviation + " - " + name;
    }
}
