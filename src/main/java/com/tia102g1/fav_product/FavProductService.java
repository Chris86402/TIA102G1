package com.tia102g1.fav_product;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("favProductService")
public class FavProductService {

    @Autowired
    FavProductRepository repository;

    /**
     * 新增最愛商品
     *
     * @param favProduct
     * @return
     */
    public FavProduct addFavPrd(FavProduct favProduct) {
        repository.save(favProduct);
        return favProduct;
    }

    public void updateFavPrd(FavProduct favProduct) {
        repository.save(favProduct);
    }

    /**
     * 刪除最愛商品
     * @param favProductId
     */
    public void deleteFavPrd(Integer favProductId) {
        if (repository.existsById(favProductId))
            repository.deleteById(favProductId);
    }

    /**
     * 查詢單項最愛商品
     * @param favProductId
     * @return
     */
    public FavProduct getFavPrd(Integer favProductId) {
        Optional<FavProduct> optional = repository.findById(favProductId);
        return optional.orElse(null);
    }

    /**
     * 查詢會員全部最愛商品
     * @return
     */
    public List<FavProduct> getMyFavPrds() {

        return repository.findByMemberId(2);//先假設會員ID為2
    }

}
