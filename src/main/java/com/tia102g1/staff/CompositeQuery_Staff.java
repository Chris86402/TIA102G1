package com.tia102g1.staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tia102g1.staff.model.StaffVO;

public class CompositeQuery_Staff {
	public static Predicate get_aPredicate_For_AnyDB(CriteriaBuilder builder, Root<StaffVO> root, String columnName,
			String value) {
		Predicate predicate = null;
		if ("status".equals(columnName))
			predicate = builder.equal(root.get(columnName), Integer.valueOf(value));
		else if ("startEmployDt".equals(columnName))
			predicate = builder.greaterThanOrEqualTo(root.get("employDt"), java.sql.Date.valueOf(value));
		else if ("endEmployDt".equals(columnName))
			predicate = builder.lessThanOrEqualTo(root.get("employDt"), java.sql.Date.valueOf(value));
		else if("startEmployDt" != null && "endEmployDt" != null)
			predicate = builder.between(root.get("employDt"), java.sql.Date.valueOf(value), java.sql.Date.valueOf(value));

		return predicate;
	}

	@SuppressWarnings("unchecked")
	public static List<StaffVO> getAllC(Map<String, String[]> map, Session session) {

//	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<StaffVO> list = null;
		try {
			// 【●創建 CriteriaBuilder】
			CriteriaBuilder builder = session.getCriteriaBuilder();
			// 【●創建 CriteriaQuery】
			CriteriaQuery<StaffVO> criteriaQuery = builder.createQuery(StaffVO.class);
			// 【●創建 Root】
			Root<StaffVO> root = criteriaQuery.from(StaffVO.class);

			List<Predicate> predicateList = new ArrayList<Predicate>();

			Set<String> keys = map.keySet();
			
			int count = 0;
			for (String key : keys) {
				String value = map.get(key)[0];
				if (value != null && value.trim().length() != 0 && !"action".equals(key)) {
					count++;
					predicateList.add(get_aPredicate_For_AnyDB(builder, root, key, value.trim()));
					System.out.println("有送出查詢資料的欄位數count = " + count);
				}
			}
			System.out.println("predicateList.size()=" + predicateList.size());
			criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
			criteriaQuery.orderBy(builder.asc(root.get("staffId")));
			// 【●最後完成創建 javax.persistence.Query●】
			Query query = session.createQuery(criteriaQuery); // javax.persistence.Query; //Hibernate 5 開始 取代原
																// org.hibernate.Query 介面
			list = query.getResultList();

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			throw ex; // System.out.println(ex.getMessage());
		} finally {
			session.close();
			// HibernateUtil.getSessionFactory().close();
		}

		return list;
	}
}
