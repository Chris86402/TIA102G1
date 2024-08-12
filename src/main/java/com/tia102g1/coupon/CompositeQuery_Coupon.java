package com.tia102g1.coupon;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompositeQuery_Coupon {

    public static Predicate get_aPredicate_For_AnyDB(CriteriaBuilder builder, Root<Coupon> root, String columnName, String value) {
        Predicate predicate = null;

        switch (columnName) {
            case "couponId":
                predicate = builder.equal(root.get(columnName), Integer.valueOf(value));
                break;
            case "couponCode":
            case "couponName":
            case "createdBy":
            case "lastUpdatedBy":
                predicate = builder.like(root.get(columnName), "%" + value + "%");
                break;
            case "couponStatus":
            case "discType":
            case "discAmount":
                predicate = builder.equal(root.get(columnName), Integer.valueOf(value));
                break;
            case "startDt":
            case "endDt":
                predicate = builder.equal(root.get(columnName), Date.valueOf(value));
                break;
            case "discPercentage":
                predicate = builder.equal(root.get(columnName), new BigDecimal(value));
                break;
            case "dateCreated":
            case "lastUpdated":
                predicate = builder.equal(root.get(columnName), Timestamp.valueOf(value));
                break;
            default:
                System.out.println("該欄位名稱不存在：" + columnName);
        }

        return predicate;
    }

    public static List<Coupon> getAllC(Map<String, String> map, EntityManager entityManager) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Coupon> criteriaQuery = builder.createQuery(Coupon.class);
        Root<Coupon> root = criteriaQuery.from(Coupon.class);

        List<Predicate> predicateList = new ArrayList<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null && !value.trim().isEmpty() && !"action".equals(key)) {
                Predicate predicate = get_aPredicate_For_AnyDB(builder, root, key, value.trim());
                if (predicate != null) {
                    predicateList.add(predicate);
                }
            }
        }

        criteriaQuery.where(builder.and(predicateList.toArray(new Predicate[0])));
        criteriaQuery.orderBy(builder.asc(root.get("couponId")));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
