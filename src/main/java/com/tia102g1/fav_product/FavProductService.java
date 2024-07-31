package com.tia102g1.fav_product;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("favProductService")
public class FavProductService {

    @Autowired
    FavProductRepository repository;

    @Autowired
    private SessionFactory sessionFactory;

    public void addFavPrd(FavProduct favProduct) {
        repository.save(favProduct);
    }

    public void updateFavPrd(FavProduct favProduct) {
        repository.save(favProduct);
    }

    public void deleteFavPrd(Integer favProductId) {
        if (repository.existsById(favProductId))
            repository.deleteById(favProductId);
    }

    public FavProduct getFavPrd(Integer favProductId) {
        Optional<FavProduct> optional = repository.findById(favProductId);
        return optional.orElse(null);  // public T orElse(T other) : 如果值存在就回傳其值，否則回傳other的值
    }

    public List<FavProduct> getAllFavPrds() {
        return repository.findAll();
    }

}
