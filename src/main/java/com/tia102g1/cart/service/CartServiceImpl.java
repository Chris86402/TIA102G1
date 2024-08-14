package com.tia102g1.cart.service;

import com.tia102g1.cart.dao.CartDao;
import com.tia102g1.cart.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    //取得購物車內容
    @Override
    public List<Cart> getAllItems(Integer memberId) {
        return cartDao.getAllItems(memberId);
    }

    //取得購物車一筆商品資料
    @Override
    public Cart getCartByPK(Integer cartId, Integer memberId) {
        return cartDao.getCartByPK(cartId, memberId);
    }

    //新增商品至購物車
    @Override
    public Cart addItem(Cart cart) {
        return cartDao.addItem(cart);
    }

    //修改商品數量
    @Override
    public void updateCart(Integer cartId, Cart cart) {
        cartDao.updateCart(cartId, cart);
    }

    //刪除一項商品
    @Override
    public void deleteItem(Integer cartId) {
        cartDao.deleteItem(cartId);
    }
}
