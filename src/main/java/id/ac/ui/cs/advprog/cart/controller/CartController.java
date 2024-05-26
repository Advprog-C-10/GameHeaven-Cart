package id.ac.ui.cs.advprog.cart.controller;

import id.ac.ui.cs.advprog.cart.dto.CartDTO;
import id.ac.ui.cs.advprog.cart.factory.CartFactory;
import id.ac.ui.cs.advprog.cart.model.Cart;
import id.ac.ui.cs.advprog.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
@CrossOrigin("*")
public class CartController {
    @Autowired
    private CartService cartService;
    private final CartFactory cartFactory = new CartFactory();

    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody CartDTO cartDTO) {
        Cart cart = cartFactory.create(
                cartDTO.getUserId(),
                cartDTO.getProductId(),
                cartDTO.getProductName(),
                cartDTO.getProductPrice(),
                cartDTO.getProductDescription(),
                cartDTO.getQuantity()
        );
        return ResponseEntity.ok(cartService.addCart(cart));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getCartsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(cartService.getCartsByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable String id) {
        return cartService.getCartById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/{quantity}")
    public ResponseEntity<Cart> updateQuantity(@PathVariable String id, @PathVariable String quantity) {
        return ResponseEntity.ok(cartService.updateQuantity(id, quantity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable String id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
