package id.ac.ui.cs.advprog.cart.factory;

import id.ac.ui.cs.advprog.cart.model.Cart;

public class CartFactory implements Factory<Cart> {
    @Override
    public Cart create(){
        return new Cart();
    }

    public Cart create(String userId, String productId, String productName, Integer productPrice, String productDescription, Integer quantity){
        return new Cart(userId, productId, productName, productPrice, productDescription, quantity);
    }
}
