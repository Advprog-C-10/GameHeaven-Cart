package id.ac.ui.cs.advprog.cart.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void testDefaultConstructor() {
        Cart cart = new Cart();
        assertNotNull(cart.getId());
        assertNotNull(cart.getDateCart());
        assertTrue(cart.getDateCart().isBefore(LocalDateTime.now()) || cart.getDateCart().isEqual(LocalDateTime.now()));
    }

    @Test
    void testParameterizedConstructor() {
        String userId = "userId";
        String productId = "productId";
        String productName = "productName";
        Integer productPrice = 100;
        String productDescription = "description";
        Integer quantity = 2;

        Cart cart = new Cart(userId, productId, productName, productPrice, productDescription, quantity);

        assertNotNull(cart.getId());
        assertEquals(userId, cart.getUserId());
        assertEquals(productId, cart.getProductId());
        assertEquals(productName, cart.getProductName());
        assertEquals(productPrice, cart.getProductPrice());
        assertEquals(productDescription, cart.getProductDescription());
        assertEquals(quantity, cart.getQuantity());
        assertNotNull(cart.getDateCart());
        assertTrue(cart.getDateCart().isBefore(LocalDateTime.now()) || cart.getDateCart().isEqual(LocalDateTime.now()));
    }

    @Test
    void testSetQuantityValid() {
        Cart cart = new Cart();
        cart.setQuantity(5);
        assertEquals(5, cart.getQuantity());
    }

    @Test
    void testSetQuantityInvalid() {
        Cart cart = new Cart();
        assertThrows(IllegalArgumentException.class, () -> cart.setQuantity(0));
        assertThrows(IllegalArgumentException.class, () -> cart.setQuantity(11));
    }
}

