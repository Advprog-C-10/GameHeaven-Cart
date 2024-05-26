package id.ac.ui.cs.advprog.cart.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "cart")
public class Cart {
    @Id
    String id;

    @Column(name = "user_id")
    String userId;

    @Column(name = "product_id")
    String productId;

    @Column(name = "product_name")
    String productName;

    @Column(name = "product_price")
    Integer productPrice;

    @Column(name = "product_description")
    String productDescription;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "dateCart")
    LocalDateTime dateCart = LocalDateTime.now();

    public Cart(){}

    public Cart(String userId, String productId, String productName, Integer productPrice, String productDescription, Integer quantity){
    }

    public void setQuantity(int quantity){
    }
}
