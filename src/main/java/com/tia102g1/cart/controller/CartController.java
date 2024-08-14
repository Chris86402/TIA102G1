package com.tia102g1.cart.controller;

import com.tia102g1.cart.model.Cart;
import com.tia102g1.cart.service.CartService;
import com.tia102g1.coupon.Coupon;
import com.tia102g1.productinfo.model.ProductInfoServiceS;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductInfoServiceS productInfoService;

    /**
     * 取得購物車內容
     *
     * @param memberId
     * @return cartList
     */
    @GetMapping("cart/{memberId}")
    public ResponseEntity<?> getAllItems(@PathVariable Integer memberId, Model model) {
        List<Cart> cartList = cartService.getAllItems(memberId);
        model.addAttribute("cartList", cartList);

//        List<ProductInfo> productInfos = productInfoService.getAll();
//        model.addAttribute("productInfos", productInfos);

        Map<String, List<?>> map = new HashMap<>();
        map.put("cartList", cartList);
//        map.put("productInfos", productInfos);
        if (cartList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(map);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * 新增商品至購物車
     *
     * @param
     * @return newCart
     */
    @PostMapping("/cart/{memberId}")
    public ResponseEntity<?> addItem(@RequestBody Cart cart) {
        val newCart = cartService.addItem(cart);
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
        Integer memberId = cart.getMemberId();
        Cart item = cartService.getCartByPK(cartId, memberId);
        //判斷購物車是否有此商品
        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //修改數量
        cartService.updateCart(cartId, cart);

        Cart updateItem = cartService.getCartByPK(cartId, memberId);
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
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 買單商品
     *
     * @param map: 從前端拿的 key-value 對資料。
     * @return: 未來會改成 String，重導到結帳頁面
     */
    @PostMapping("/api/checkout")  // 暫定 url
    public ResponseEntity<?> checkout(@RequestBody Map<String, Object>map, Model model) {
        var cartItems = (map.get("cartItems"));
        System.out.println(cartItems);
        Coupon coupon = (Coupon)map.get("coupon");
        System.out.println(coupon);
        model.addAttribute("cartListToCheckout", cartItems);
        model.addAttribute("coupon", coupon);
        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }

}
