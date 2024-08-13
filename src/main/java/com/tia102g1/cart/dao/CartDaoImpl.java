package com.tia102g1.cart.dao;

import com.tia102g1.cart.model.Cart;
import com.tia102g1.cart.rowmapper.CartRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CartDaoImpl implements CartDao {

    @Autowired
    private NamedParameterJdbcTemplate npjt;

    //取得購物車內容
    @Override
    public List<Cart> getAllItems() {
//        Integer memberId = memberService.getMemberId();
        Integer memberId = 10;//暫時先假設
        String sql = "SELECT * FROM cart WHERE memberId=:memberId";
        Map<String, Object> map = new HashMap<>();
        map.put("memberId", memberId);

        return npjt.query(sql, map, new CartRowMapper());
    }

    //取得購物車一筆商品資料
    @Override
    public Cart getCartByPK(Integer cartId) {
        List<Cart> cartList = getAllItems();
        for (Cart cart : cartList) {
            if (cart.getCartId().equals(cartId)) {
                return cart;
            }
        }
        return null;
    }

    //新增商品至購物車
    @Override
    public Cart addItem(Cart cart) {

        String sql = "INSERT INTO cart VALUES (default, :memberId, :productId, :proAmount, default)";
        Map<String, Object> map = new HashMap<>();
        map.put("memberId", cart.getMemberId());
        map.put("productId", cart.getProductId());
        map.put("proAmount", cart.getProAmount());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        npjt.update(sql, new MapSqlParameterSource(map), keyHolder);

        int cartId = keyHolder.getKey().intValue();
        cart.setCartId(cartId);

        return cart;
    }

    //修改商品數量
    @Override
    public void updateCart(Integer cartId, Cart cart) {

        String sql = "UPDATE cart SET proAmount=:proAmount WHERE cartId=:cartId";
        Map<String, Object> map = new HashMap<>();
        map.put("proAmount", cart.getProAmount());
        map.put("cartId", cartId);
        npjt.update(sql, map);
    }

    //刪除一項商品
    @Override
    public void deleteItem(Integer cartId) {
        String sql = "DELETE FROM cart WHERE cartId=:cartId";
        Map<String, Object> map = new HashMap<>();
        map.put("cartId", cartId);
        npjt.update(sql, map);
    }
}
