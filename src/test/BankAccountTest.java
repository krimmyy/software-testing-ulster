package test;

import main.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testInitialBalance() {
        BankAccount account = new BankAccount(1000);
        Assertions.assertEquals(1000, account.getBankBalance());
    }

    @Test
    void testDepositValidAmount() {
        BankAccount account = new BankAccount(5000);
        account.deposit(1500);
        Assertions.assertEquals(6500, account.getBankBalance());
    }

    @Test
    void testDepositInvalidAmount() {
        BankAccount account = new BankAccount(2000);
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-5000);
        });
    }

    @Test
    void testWithdrawalValidAmount() {
        BankAccount account = new BankAccount(3000);
        account.withdraw(650);
        Assertions.assertEquals(2350, account.getBankBalance());
    }

    @Test
    void testWithdrawlMoreThanBalance() {
        BankAccount account = new BankAccount(1000);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1500);
        });
    }

    @Test
    void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount(2000);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-500);
        });
    }

    @Test
    void testNoOverdraft() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(800);
        account.withdraw(250);
        Assertions.assertEquals(200, account.getBankBalance());
    }

    @Test
    void testInitialBalanceNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-500);
        });
    }
}
