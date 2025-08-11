package example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

    @Test
    void givenCustomerWithSufficientBalance_whenWithdraw_thenSucceed() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);

        // Act
        String result = am.withdraw(c, 500);

        // Assert
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(500, c.getBalance());
    }



    // TODO: Write tests that cover all scenarios for the withdraw method


    @Test
    public void withdraw_SHOULD_returnInsufficientBalance_WHEN_customerCreditIsNotAllowedAndBalanceIsInsufficient() {
        // Arrange
        Customer customer = new Customer();
        customer.setBalance(500);
        customer.setCreditAllowed(false);
        String expectedResultMessage = "insufficient account balance";
        AccountManager accountManager = new AccountManagerImpl();

        // Act
        String actualResult = accountManager.withdraw(customer, 700);

        // Assert
        Assertions.assertEquals(expectedResultMessage, actualResult);
        Assertions.assertEquals(500, customer.getBalance());
    }

    @Test
    public void withdraw_SHOULD_succeed_WHEN_customerHasCreditAllowedAndIsVIP() {
        // Arrange
        Customer customer = new Customer();
        customer.setBalance(500);
        customer.setCreditAllowed(true);
        customer.setVip(true);
        String expectedResultMessage = "success";
        AccountManager accountManager = new AccountManagerImpl();


        // Act
        String actualResult = accountManager.withdraw(customer, 700);

        // Assert
        Assertions.assertEquals(expectedResultMessage, actualResult);
        Assertions.assertEquals(500-700, customer.getBalance());
    }


    @Test
    public void withdraw_SHOULD_returnMaximumCreditExceeded_WHEN_customerCreditedAmountHitsMaximumCreditAndNotVIP() {
        // Arrange
        Customer customer = new Customer();
        customer.setBalance(500);
        customer.setCreditAllowed(true);
        customer.setVip(false);
        String expectedResultMessage = "maximum credit exceeded";
        AccountManager accountManager = new AccountManagerImpl();

        // Act
        String actualResult = accountManager.withdraw(customer, AccountManagerImpl.getMaxCredit() + 501);


        // Assert
        Assertions.assertEquals(expectedResultMessage, actualResult);
        Assertions.assertEquals(500, customer.getBalance());
    }
}
