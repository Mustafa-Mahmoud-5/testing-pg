package example.store;

import example.account.AccountManager;
import example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

// Mock testing
public class StoreV2Test {

    @Test
    void test() {
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(4);
        Customer customer = new Customer();

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(3, product.getQuantity());
    }

    // test if the dependency(AccountManager) didn't pass
    @Test
    void buy_SHOULD_throwRuntimeException_WHEN_accountManagerWithdrawFails() {
        // Arrange
        Customer customer = new Customer();
        Product product = new Product();
        product.setQuantity(5);
        AccountManager accountManager = mock(AccountManager.class); // interfaceName.Class
        when(accountManager.withdraw(any(), anyInt())).thenReturn("failed"); // any string other than "success"

        Store store = new StoreImpl(accountManager);

        // Assert
        Assertions.assertThrows(RuntimeException.class, () -> {
            // Act
            store.buy(product, customer);
        });
    }
}
