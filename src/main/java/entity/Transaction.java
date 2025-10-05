package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "source_currency")
    private Currency source;

    @ManyToOne
    @JoinColumn(name = "destination_currency")
    private Currency destination;

    public Transaction() {}

    public Transaction(double amount, Currency source, Currency destination) {
        this.amount = amount;
        this.source = source;
        this.destination = destination;
    }

    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public Currency getSource() { return source; }
    public Currency getDestination() { return destination; }
}
