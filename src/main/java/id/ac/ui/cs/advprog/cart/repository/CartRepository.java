package id.ac.ui.cs.advprog.cart.repository;

import id.ac.ui.cs.advprog.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, String> {
    List<Cart> findByUserId(String userId);
}
