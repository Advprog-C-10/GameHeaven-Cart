package id.ac.ui.cs.advprog.cart.factory;

public interface Factory <T> {
    T create();

    T create(String userId, String productId, String productName, Integer productPrice, String productDescription, Integer quantity);
}