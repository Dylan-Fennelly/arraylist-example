package simplebanking;

import java.util.ArrayList;

public class Customer
{
    private String name;
    private ArrayList<Double> Transactions;

    public ArrayList<Double> getTransactions()
    {
        return Transactions;
    }

    public Customer(String name, double initialAmount)
    {
        this.name = name;
        addTransaction(initialAmount);
    }

    public String getName()
    {
        return name;
    }
    public void addTransaction(double amount)
    {
        Transactions.add(amount);
    }
}
