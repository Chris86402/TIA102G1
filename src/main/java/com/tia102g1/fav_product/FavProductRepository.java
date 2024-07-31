package com.tia102g1.fav_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FavProductRepository extends JpaRepository<FavProduct, Integer> {

    /**
     * 新增最愛商品
     * @param favId
     * @param favName
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO favProduct(favId, favName) VALUES(?,?)", nativeQuery = true)
    void addFavPrd(Integer favId, String favName);

    /**
     * 查詢單項最愛商品
     * @param favName
     * @return FavProduct
     */
    @Query(value = "SELECT * FROM favProduct WHERE favName =?1", nativeQuery = true)
    FavProduct getFavPrd(String favName);

    /**
     * 查詢全部最愛商品
     * @return List<FavProduct>
     */
    @Query(value = "SELECT * FROM favProduct", nativeQuery = true)
    List<FavProduct> getAllFavPrds();

    /**
     * 刪除最愛商品
     * @param favId
     */
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM favProduct WHERE favId =?1", nativeQuery = true)
    void deleteFavPrd(Integer favId);

    /**
     * 修改最愛商品(應該用不到)
     * @param favName
     * @param favId
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE favProduct SET favName =?1 WHERE favId =?2", nativeQuery = true)
    void updateFavPrd(String favName, Integer favId);

}
