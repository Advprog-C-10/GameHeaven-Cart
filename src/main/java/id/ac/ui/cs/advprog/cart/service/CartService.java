package id.ac.ui.cs.advprog.cart.service;

import id.ac.ui.cs.advprog.cart.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Cart addCart(Cart cart);
    List<Cart> getCartsByUserId(String userId);
    Optional<Cart> getCartById(String id);
    Cart updateQuantity(String id, String quantity);
    void deleteCart(String id);
}

