package id.ac.ui.cs.advprog.cart.service;

import id.ac.ui.cs.advprog.cart.factory.CartFactory;
import id.ac.ui.cs.advprog.cart.model.Cart;
import id.ac.ui.cs.advprog.cart.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    private Cart cart;
    private final CartFactory cartFactory = new CartFactory();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cart = cartFactory.create("userId", "productId", "productName", 100, "description", 2);
    }

    @Test
    void addCart() {
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart createdCart = cartService.addCart(cart);

        assertNotNull(createdCart);
        assertEquals(cart.getUserId(), createdCart.getUserId());
        verify(cartRepository, times(1)).save(cart);
    }

    @Test
    void getCartsByUserId() {
        when(cartRepository.findByUserId("userId")).thenReturn(Arrays.asList(cart));

        List<Cart> carts = cartService.getCartsByUserId("userId");

        assertEquals(1, carts.size());
        verify(cartRepository, times(1)).findByUserId("userId");
    }

    @Test
    void getCartById() {
        when(cartRepository.findById("id")).thenReturn(Optional.of(cart));

        Optional<Cart> foundCart = cartService.getCartById("id");

        assertTrue(foundCart.isPresent());
        assertEquals(cart.getUserId(), foundCart.get().getUserId());
        verify(cartRepository, times(1)).findById("id");
    }

    @Test
    void updateQuantity() {
        when(cartRepository.findById("id")).thenReturn(Optional.of(cart));
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart updatedCart = cartService.updateQuantity("id", "5");

        assertNotNull(updatedCart);
        assertEquals(5, updatedCart.getQuantity());
        verify(cartRepository, times(1)).findById("id");
        verify(cartRepository, times(1)).save(cart);
    }

    @Test
    void updateQuantityInvalidQuantityFormat() {
        when(cartRepository.findById("id")).thenReturn(Optional.of(cart));

        assertThrows(IllegalArgumentException.class, () -> cartService.updateQuantity("id", "invalid"));
    }

    @Test
    void updateQuantityCartNotFound() {
        when(cartRepository.findById("id")).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            cartService.updateQuantity("id", "5");
        });

        assertEquals("Cart not found", thrown.getMessage());
        verify(cartRepository, times(1)).findById("id");
    }

    @Test
    void deleteCart() {
        doNothing().when(cartRepository).deleteById("id");

        cartService.deleteCart("id");

        verify(cartRepository, times(1)).deleteById("id");
    }
}
