package com.tia102g1.cart.service;

import com.tia102g1.cart.model.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getAllItems(Integer memberId);

    Cart getCartByPK(Integer cartId, Integer memberId);

    Cart addItem(Cart cart);

    void updateCart(Integer cartId, Cart cart);

    void deleteItem(Integer cartId);


}
