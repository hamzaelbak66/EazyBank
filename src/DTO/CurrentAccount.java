package DTO;

import INTERFACES.statut;

import java.time.LocalDate;

public class CurrentAccount extends Account {
    private double maxPrice;
    public CurrentAccount(String accnum, double balance, LocalDate creationdate, statut status, Client client, double maxprice, Employee employye) {
        super(accnum, balance, creationdate, status, client, employye);
        setMaxPrice(maxprice);
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

}
