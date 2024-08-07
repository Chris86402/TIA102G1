package com.tia102g1.event;

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

import com.tia102g1.event.model.EventVO;

public class CompositeQuery_Event {

	public static Predicate get_aPredicate_For_AnyDB(CriteriaBuilder builder, Root<EventVO> root, String columnName,
			String value) {

		Predicate predicate = null;

		try {
			// 用於Integer
			if ("eventId".equals(columnName) || "status".equals(columnName)) {
				predicate = builder.equal(root.get(columnName), Integer.valueOf(value)); // root代表查詢的實體型別

				// 用於Double
//			} else if ("eventDiscount".equals(columnName)) {
//				predicate = builder.equal(root.get(columnName), Double.valueOf(value));

			// 用於varchar
			} else if ("eventName".equals(columnName) || "eventContent".equals(columnName)
					|| "createdBy".equals(columnName) || "lastUpdatedBy".equals(columnName)) {
				predicate = builder.like(root.get(columnName), "%" + value + "%");
			
			//有開始日期 就查 大於等於 開始日期者
			} else if ("startDt".equals(columnName)) {
					predicate = builder.greaterThanOrEqualTo(root.get(columnName), java.sql.Date.valueOf(value));
			
			//有結束日期 就查 小於等於 結束日期者 最後會在getAllC()裡面組起來
			} else if ("endDt".equals(columnName)) {
					predicate = builder.lessThanOrEqualTo(root.get(columnName), java.sql.Date.valueOf(value));
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}

		return predicate;
	}

	@SuppressWarnings("unchecked")
	public static List<EventVO> getAllC(Map<String, String[]> map, Session session) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<EventVO> list = null;
		try {
			// 【●創建 CriteriaBuilder】
			CriteriaBuilder builder = session.getCriteriaBuilder();
			// 【●創建 CriteriaQuery】
			CriteriaQuery<EventVO> criteriaQuery = builder.createQuery(EventVO.class);
			// 【●創建 Root】
			Root<EventVO> root = criteriaQuery.from(EventVO.class);

			List<Predicate> predicateList = new ArrayList<Predicate>();

			Set<String> keys = map.keySet();
			int count = 0;
			for (String key : keys) {
				String value = map.get(key)[0];
				System.out.println("key內容 = " + value);
				if (value != null && value.trim().length() != 0 && !"action".equals(key)) {
					count++;
					predicateList.add(get_aPredicate_For_AnyDB(builder, root, key, value.trim()));
					System.out.println("有送出查詢資料的欄位數count = " + count);
				}
			}
			System.out.println("predicateList.size()=" + predicateList.size());
			criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
			criteriaQuery.orderBy(builder.asc(root.get("eventId")));
			// 【●最後完成創建 javax.persistence.Query●】
			Query query = session.createQuery(criteriaQuery); // javax.persistence.Query; //Hibernate 5 開始 取代原
																// org.hibernate.Query 介面
			list = query.getResultList();

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
//			throw ex; // System.out.println(ex.getMessage());
			System.out.println(ex.getMessage());
		} finally {
			session.close();

			// HibernateUtil.getSessionFactory().close();
		}

		return list;
	}

}
