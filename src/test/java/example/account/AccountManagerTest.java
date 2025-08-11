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
    }
}
