package com.tia102g1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {
    //前台頁面
    //首頁
    @RequestMapping({"/index","/index.html"})
    public String frontendIndex(Model model) {
        return "/frontend-app/index";
    }

    //購物車
    @GetMapping("/cart-page.html")
    public String frontendShoppingCart(Model model){
        return "/frontend-app/cart-page";
    }

    //關於我們
    @GetMapping("/about-us.html")
    public String frontendAboutUs(Model model){
        return "/frontend-app/about-us";
    }

    //聯絡我們
    @GetMapping("/contact-us.html")
    public String frontendContactUs(Model model){
        return "/frontend-app/contact-us";
    }

    //商品詳細
    @GetMapping("/product-details.html")
    public String frontendProductDetail(Model model) {
        return "/frontend-app/product-details";
    }

    //願望清單 todo：改成我的最愛列表用
    @GetMapping("/wishlist.html")
    public String frontendWishlist(Model model) { return "/frontend-app/wishlist"; }
}
