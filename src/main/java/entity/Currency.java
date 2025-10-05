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
    public String getName() { return name; }
    public double getRateToUSD() { return rateToUSD; }

    @Override
    public String toString() {
        return abbreviation + " - " + name;
    }
}
