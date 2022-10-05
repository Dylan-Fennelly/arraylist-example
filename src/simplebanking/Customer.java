package simplebanking;

import java.util.ArrayList;

public class Customer
{
    private String name;
    private ArrayList<Double> Transactions;

    public Customer(String name, double initialAmount)
    {
        this.name = name;
        Transactions.add(initialAmount);
    }

    public String getName() {
        return name;
    }
}
