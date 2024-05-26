package id.ac.ui.cs.advprog.cart.factory;

import id.ac.ui.cs.advprog.cart.model.Cart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    private final CartFactory cartFactory = new CartFactory();

    @Test
    void testCreateCartWithNoArguments() {
        Cart cart = cartFactory.create();
        assertNotNull(cart);
        assertNotNull(cart.getId());
        assertNotNull(cart.getDateCart());
    }

    @Test
    void testCreateCartWithArguments() {
        String userId = "userId";
        String productId = "productId";
        String productName = "productName";
        Integer productPrice = 100;
        String productDescription = "description";
        Integer quantity = 2;

        Cart cart = cartFactory.create(userId, productId, productName, productPrice, productDescription, quantity);

        assertNotNull(cart);
        assertNotNull(cart.getId());
        assertEquals(userId, cart.getUserId());
        assertEquals(productId, cart.getProductId());
        assertEquals(productName, cart.getProductName());
        assertEquals(productPrice, cart.getProductPrice());
        assertEquals(productDescription, cart.getProductDescription());
        assertEquals(quantity, cart.getQuantity());
        assertNotNull(cart.getDateCart());
    }
}
