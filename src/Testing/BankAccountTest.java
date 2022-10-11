package Testing;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest
{
    @Test
    public void deposit()
    {
        BankAccount johnsAccount = new BankAccount("John","Loane",100);
        double balance = johnsAccount.deposit(200,true);
        double expBalance = 300;
        assertEquals(expBalance,balance,0.0001);
    }
    @Test
    public void withdraw()
    {
        BankAccount johnsAccount = new BankAccount("John","Loane",100);
        double balance = johnsAccount.withdraw(50,true);
        double expBalance = 50;
        assertEquals(expBalance,balance,0.0001);
    }
}