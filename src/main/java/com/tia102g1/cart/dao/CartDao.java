package com.tia102g1.cart.dao;

import com.tia102g1.cart.model.Cart;

import java.util.List;

public interface CartDao {
    //取得購物車內容
    List<Cart> getAllItems(Integer memberId);

    //取得購物車一筆商品資料
    Cart getCartByPK(Integer cartId, Integer memberId);

    //新增商品至購物車
    Cart addItem(Cart cart);

    //修改商品數量
    void updateCart(Integer cartId, Cart cart);

    //刪除一項商品
    void deleteItem(Integer cartId);

}
