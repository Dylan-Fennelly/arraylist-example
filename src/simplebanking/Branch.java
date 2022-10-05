package simplebanking;

import java.util.ArrayList;

public class Branch
{
    private String name;
    private String address;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch (String name,String address)
    {
        this.name = name;
        this.address = address;
        this.customers = new ArrayList<Customer>();
    }
    public String getName()
    {
        return name;
    }
    public boolean addNewCustomer(Customer customerName, double initialAmount)
    {
        if(findCustomer(customerName == null))
        {
            this.customers.add(new Customer(customerName,initialAmount));
            return true;
        }
        return false;
    }
    public boolean addCustomerTransaction(String customerName, double name)
    {
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer == findCustomer(customerName));
        {
            existingCustomer.addTranaction(amount);
            return true;
        }
        return false;
    }
    private Customer findCustomer(String customerName)
    {
        for (int i = 0;i<this.customers.size();i++)
        {
            Customer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getName().equals(customerName))
            {
                return checkedCustomer;
            }
        }
        return null;

    }
}
