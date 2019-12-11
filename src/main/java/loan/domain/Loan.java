package loan.domain;

import halpers.domain.Domain;

import halpers.domain.FiatCurrency;

import java.sql.Timestamp;
import java.util.UUID;

public class Loan extends Domain {
    public UUID id;
    public double amount;
    public FiatCurrency currency;
    public double outspending;
    public double percentageRate;
    public double interestAccumulated;
    public LoanStatus status;
    public Timestamp createDate;
    public Timestamp closeDate;

    public Loan(
            UUID id,
            double amount,
            FiatCurrency currency,
            double outspending,
            double percentageRate,
            double interestAccumulated,
            LoanStatus status,
            Timestamp createDate,
            Timestamp closeDate
    ) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.outspending = outspending;
        this.percentageRate = percentageRate;
        this.interestAccumulated = interestAccumulated;
        this.status = status;
        this.createDate = createDate;
        this.closeDate = closeDate;
    }

    public static Loan fromJSON(String json) {
        return null;
    }

    public static Loan fromMap() {
        return null;
    }
}
