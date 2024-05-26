package id.ac.ui.cs.advprog.cart.model;

import id.ac.ui.cs.advprog.cart.factory.CartFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private Cart cart;
    private final CartFactory cartFactory = new CartFactory();

    @BeforeEach
    void setUp() {
        cart = cartFactory.create("userId", "productId", "productName", 100, "description", 2);
    }

    @Test
    void testGetCartId() {
        assertNotNull(cart.getId());
    }

    @Test
    void testGetUserId() {
        assertEquals("userId", cart.getUserId());
    }

    @Test
    void testGetProductId() {
        assertEquals("productId", cart.getProductId());
    }

    @Test
    void testGetProductName() {
        assertEquals("productName", cart.getProductName());
    }

    @Test
    void testGetProductPrice() {
        assertEquals(100, cart.getProductPrice());
    }

    @Test
    void testGetProductDescription() {
        assertEquals("description", cart.getProductDescription());
    }

    @Test
    void testGetQuantity() {
        assertEquals(2, cart.getQuantity());
    }

    @Test
    void testGetDateCart() {
        assertNotNull(cart.getDateCart());
        assertTrue(cart.getDateCart().isBefore(LocalDateTime.now()) || cart.getDateCart().isEqual(LocalDateTime.now()));
    }

    @Test
    void testSetUserId() {
        String userId = "newUserId";
        cart.setUserId(userId);
        assertEquals(userId, cart.getUserId());
    }

    @Test
    void testSetProductId() {
        String productId = "newProductId";
        cart.setProductId(productId);
        assertEquals(productId, cart.getProductId());
    }

    @Test
    void testSetProductName() {
        String productName = "newProductName";
        cart.setProductName(productName);
        assertEquals(productName, cart.getProductName());
    }

    @Test
    void testSetProductPrice() {
        Integer productPrice = 200;
        cart.setProductPrice(productPrice);
        assertEquals(productPrice, cart.getProductPrice());
    }

    @Test
    void testSetProductDescription() {
        String productDescription = "newDescription";
        cart.setProductDescription(productDescription);
        assertEquals(productDescription, cart.getProductDescription());
    }

    @Test
    void testSetDateCart() {
        LocalDateTime dateCart = LocalDateTime.now().minusDays(1);
        cart.setDateCart(dateCart);
        assertEquals(dateCart, cart.getDateCart());
    }
    @Test
    void testDefaultConstructor() {
        Cart cart = cartFactory.create();
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

        Cart cart = cartFactory.create(userId, productId, productName, productPrice, productDescription, quantity);

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
        Cart cart = cartFactory.create();
        cart.setQuantity(5);
        assertEquals(5, cart.getQuantity());
    }

    @Test
    void testSetQuantityInvalid() {
        Cart cart = cartFactory.create();
        assertThrows(IllegalArgumentException.class, () -> cart.setQuantity(0));
        assertThrows(IllegalArgumentException.class, () -> cart.setQuantity(11));
    }
}

