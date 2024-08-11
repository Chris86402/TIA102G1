package com.tia102g1.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service("CouponService")
public class CouponService {

    @Autowired
    CouponRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 新增優惠券
     * @param coupon
     * @return
     */
    public Coupon addCoupon(Coupon coupon) {
        return repository.save(coupon);
    }

    /**
     * 修改優惠券
     *
     * @param coupon: 要傳到資料庫的 coupon
     * @return newCoupon: 方便在 controller 調用時 debug
     */
    public Coupon updateCoupon(Coupon coupon) {
        return repository.save(coupon);
    }

    /**
     * 刪除優惠券
     * @param couponId
     */
    public void deleteCoupon(Integer couponId) {
        if (repository.existsById(couponId))
            repository.deleteById(couponId);
    }

    /**
     * 查詢單項優惠券
     * @param couponId
     * @return
     */
    public Coupon getCoupon(Integer couponId) {
        Optional<Coupon> optional = repository.findById(couponId);
        return optional.orElse(null);
    }

    /**
     * 查詢全部優惠券
     * @return
     */
    public List<Coupon> getAllCoupons() {
        return repository.findAll();
    }

    /**
     * 搜尋優惠券
     * @param searchCriteria
     * @return
     */

    @Transactional(readOnly = true)
    public List<Coupon> searchCoupons(Map<String, String> searchCriteria) {
        return CompositeQuery_Coupon.getAllC(searchCriteria, entityManager);
    }
}

