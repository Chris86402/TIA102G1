package com.tia102g1.cart.controller;

import com.tia102g1.cart.model.Cart;
import com.tia102g1.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 取得購物車內容
     *
     * @param memberId
     * @return cartList
     */
    @GetMapping("cart/{memberId}")
    public ResponseEntity<List<Cart>> getAllItems(@PathVariable Integer memberId) {

        List<Cart> cartList = cartService.getAllItems();
        if (cartList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(cartList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * 新增商品至購物車
     *
     * @param cart
     * @return newCart
     */
    @PostMapping("/cart/{memberId}")
    public ResponseEntity<Cart> addItem(@RequestBody Cart cart) {
        Cart newCart = cartService.addItem(cart);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCart);
    }

    /**
     * 更新商品數量
     *
     * @param cartId
     * @param cart
     * @return updateItem
     */
    @PutMapping("/cart/{cartId}")
    public ResponseEntity<Cart> updateCart(@PathVariable Integer cartId, @RequestBody Cart cart) {

        Cart item = cartService.getCartByPK(cartId);
        //判斷購物車是否有此商品
        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //修改數量
        cartService.updateCart(cartId, cart);

        Cart updateItem = cartService.getCartByPK(cartId);
        return ResponseEntity.status(HttpStatus.OK).body(updateItem);
    }

    /**
     * 刪除商品
     *
     * @param cartId
     * @return
     */
    @DeleteMapping("/cart/{cartId}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer cartId) {
        cartService.deleteItem(cartId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
