package id.ac.ui.cs.advprog.cart.service;

import id.ac.ui.cs.advprog.cart.model.Cart;
import id.ac.ui.cs.advprog.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCartsByUserId(String userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public Optional<Cart> getCartById(String id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart updateQuantity(String id, String quantity) {
        int realQuantity;
        try {
            realQuantity = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity format");
        }

        return cartRepository.findById(id).map(cart -> {
            cart.setQuantity(realQuantity);
            return cartRepository.save(cart);
        }).orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    @Override
    public void deleteCart(String id) {
        cartRepository.deleteById(id);
    }
}
