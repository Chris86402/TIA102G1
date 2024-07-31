package com.tia102g1.fav_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Validated
@RequestMapping("/favProduct")
public class FavProductController {

    @Autowired
    FavProductService favProductService;

    @RequestMapping("/addFavPrd")
    public String addFavPrd(FavProduct favProduct) {
        favProductService.addFavPrd(favProduct);
        return "redirect:/favProduct/getAllFavPrds";
    }

    @RequestMapping("/updateFavPrd")
    public String updateFavPrd(FavProduct favProduct) {
        favProductService.updateFavPrd(favProduct);
        return "redirect:/favProduct/getAllFavPrds";
    }

    @RequestMapping("/deleteFavPrd")
    public String deleteFavPrd(Integer favProductId) {
        favProductService.deleteFavPrd(favProductId);
        return "redirect:/favProduct/getAllFavPrds";
    }

    @RequestMapping("/getFavPrd")
    public String getFavPrd(Integer favProductId) {
        favProductService.getFavPrd(favProductId);
        return "redirect:/favProduct/getAllFavPrds";
    }

    @RequestMapping("/getAllFavPrds")
    public String getAllFavPrds() {
        favProductService.getAllFavPrds();
        return "redirect:/favProduct/getAllFavPrds";
    }


}
