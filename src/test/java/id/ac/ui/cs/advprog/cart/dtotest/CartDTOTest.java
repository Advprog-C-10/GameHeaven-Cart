package id.ac.ui.cs.advprog.cart.dtotest;

import id.ac.ui.cs.advprog.cart.dto.CartDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartDTOTest {

    private CartDTO cartDTO;

    @BeforeEach
    void setUp() {
        cartDTO = new CartDTO();
        cartDTO.setUserId("userId");
        cartDTO.setProductId("productId");
        cartDTO.setProductName("productName");
        cartDTO.setProductPrice(100);
        cartDTO.setProductDescription("description");
        cartDTO.setQuantity(2);
    }

    @Test
    void testGetUserId() {
        assertEquals("userId", cartDTO.getUserId());
    }

    @Test
    void testGetProductId() {
        assertEquals("productId", cartDTO.getProductId());
    }

    @Test
    void testGetProductName() {
        assertEquals("productName", cartDTO.getProductName());
    }

    @Test
    void testGetProductPrice() {
        assertEquals(100, cartDTO.getProductPrice());
    }

    @Test
    void testGetProductDescription() {
        assertEquals("description", cartDTO.getProductDescription());
    }

    @Test
    void testGetQuantity() {
        assertEquals(2, cartDTO.getQuantity());
    }

    @Test
    void testSetUserId() {
        String newUserId = "newUserId";
        cartDTO.setUserId(newUserId);
        assertEquals(newUserId, cartDTO.getUserId());
    }

    @Test
    void testSetProductId() {
        String newProductId = "newProductId";
        cartDTO.setProductId(newProductId);
        assertEquals(newProductId, cartDTO.getProductId());
    }

    @Test
    void testSetProductName() {
        String newProductName = "newProductName";
        cartDTO.setProductName(newProductName);
        assertEquals(newProductName, cartDTO.getProductName());
    }

    @Test
    void testSetProductPrice() {
        Integer newProductPrice = 200;
        cartDTO.setProductPrice(newProductPrice);
        assertEquals(newProductPrice, cartDTO.getProductPrice());
    }

    @Test
    void testSetProductDescription() {
        String newProductDescription = "newDescription";
        cartDTO.setProductDescription(newProductDescription);
        assertEquals(newProductDescription, cartDTO.getProductDescription());
    }

    @Test
    void testSetQuantity() {
        Integer newQuantity = 5;
        cartDTO.setQuantity(newQuantity);
        assertEquals(newQuantity, cartDTO.getQuantity());
    }
}

