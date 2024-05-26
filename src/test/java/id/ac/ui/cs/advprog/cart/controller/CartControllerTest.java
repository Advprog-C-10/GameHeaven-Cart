package id.ac.ui.cs.advprog.cart.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.ui.cs.advprog.cart.dto.CartDTO;
import id.ac.ui.cs.advprog.cart.model.Cart;
import id.ac.ui.cs.advprog.cart.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CartController.class)
class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Autowired
    private ObjectMapper objectMapper;

    private Cart cart;
    private CartDTO cartDTO;

    @BeforeEach
    void setUp() {
        cart = new Cart("userId", "productId", "productName", 100, "description", 2);
        cartDTO = new CartDTO();
        cartDTO.setUserId("userId");
        cartDTO.setProductId("productId");
        cartDTO.setProductName("productName");
        cartDTO.setProductPrice(100);
        cartDTO.setProductDescription("description");
        cartDTO.setQuantity(2);
    }

    @Test
    void addCart() throws Exception {
        when(cartService.addCart(any(Cart.class))).thenReturn(cart);

        mockMvc.perform(post("/api/carts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(cart.getUserId()));
    }

    @Test
    void getCartsByUserId() throws Exception {
        when(cartService.getCartsByUserId("userId")).thenReturn(Arrays.asList(cart));

        mockMvc.perform(get("/api/carts/user/userId")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId").value(cart.getUserId()));
    }

    @Test
    void getCartById() throws Exception {
        when(cartService.getCartById("id")).thenReturn(Optional.of(cart));

        mockMvc.perform(get("/api/carts/id")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(cart.getUserId()));
    }

    @Test
    void updateQuantity() throws Exception {
        cart.setQuantity(5);
        when(cartService.updateQuantity("id", "5")).thenReturn(cart);

        mockMvc.perform(put("/api/carts/id/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(5));
    }

    @Test
    void deleteCart() throws Exception {
        mockMvc.perform(delete("/api/carts/id")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
