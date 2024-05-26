package id.ac.ui.cs.advprog.cart.repository;

import id.ac.ui.cs.advprog.cart.factory.CartFactory;
import id.ac.ui.cs.advprog.cart.model.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CartRepositoryTest {
    @Autowired
    private CartRepository cartRepository;
    private  final CartFactory cartFactory = new CartFactory();

    @Test
    void whenFindByUserId_thenReturnCarts() {
        Cart cart = cartFactory.create("user1", "product1", "Product 1", 100, "Description 1", 1);
        cartRepository.save(cart);

        List<Cart> found = cartRepository.findByUserId("user1");
        assertThat(found).isNotEmpty();
    }
}
